package com.gupao.wjg.dynamicProxy.gpProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.xml.crypto.dsig.keyinfo.PGPData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GpProxy {

    public static final String ln = "\r\n";

    private GpInvocationHandler h;

    public GpProxy(GpInvocationHandler h) {
        this.h = h;
    }

    private static Map<String, Method> methodMap = new ConcurrentHashMap<String, Method>();

    public static Object newProxyInstance(GpClassLoader loader,
                                          Class<?>[] interfaces,
                                          GpInvocationHandler h)
            throws IllegalArgumentException {
        //1、动态生成源代码.java文件
        String src = createSrc(interfaces);
        //  //2、Java文件输出磁盘
        String path = GpProxy.class.getResource("").getPath();
        File file = new File(path + "$proxy0.java");

        FileWriter out = null;
        try {
            out = new FileWriter(file);
            out.write(src);
            out.flush();
            out.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manage.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
            task.call();
            manage.close();

            //4、编译生成的.class文件加载到JVM中来
           Class proxyClass = loader.findClass("$proxy0");
            Constructor c = proxyClass.getConstructor(GpInvocationHandler.class);
         //  file.delete();

            //5、返回字节码重组以后的新的代理对象
            return c.newInstance(h);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    private static String createSrc(Class<?>[] interfaces) {
        if (interfaces == null || interfaces.length == 0) {
            throw new IllegalArgumentException("必须实现接口");
        }

        StringBuffer sb = new StringBuffer();
        Class<?> clazz = interfaces[0];
        String name = clazz.getName();
        String packageName = GpProxy.class.getPackage().getName();
        sb.append("package " + packageName + ";" + ln);
        sb.append("import " + name + ";" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public  class $proxy0  implements " + clazz.getSimpleName() + "{" + ln);

        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (int j = 0; j < declaredMethods.length; j++) {
            sb.append("private static Method m" + j + ";" + ln);
        }
        sb.append("static{" + ln);
        sb.append("try{" + ln);


        for (int i = 0; i < declaredMethods.length; i++) {
            Method declaredMethod = declaredMethods[i];
            String methodName = declaredMethod.getName();

            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            StringBuffer paramNames = new StringBuffer();

            for (int j = 0; j < parameterTypes.length; j++) {
                Class<?> parameterType = parameterTypes[j];
                String type = parameterType.getName();
                String typeName = toLowerFirstCase(parameterType.getSimpleName());
                paramNames.append(type);

                if (j>0&&j != (parameterTypes.length - 1)) {
                    paramNames.append(",");
                }
            }


            try {
                Method method=null;
                if(parameterTypes.length>0){
                    sb.append("m" + i + "= Class.forName(\"" + name + "\").getMethod(\"" + methodName + "\",new Class[]{"+paramNames.toString()+".class});" + ln);
                    method= Class.forName(name).getMethod(methodName,parameterTypes);

                }else{
                    sb.append("m" + i + "= Class.forName(\"" + name + "\").getMethod(\"" + methodName + "\",new Class[]{});" + ln);
                    method = Class.forName(name).getMethod(methodName);

                }
                methodMap.put("m" + i, method);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

        sb.append("}catch(NoSuchMethodException localNoSuchMethodException){" + ln);
        sb.append("throw new NoSuchMethodError(localNoSuchMethodException.getMessage());" + ln);
        sb.append("}catch(ClassNotFoundException localClassNotFoundException){" + ln);
        sb.append("throw new NoClassDefFoundError(localClassNotFoundException.getMessage());" + ln);
        sb.append("}" + ln);
        sb.append("}");
        Set<Map.Entry<String, Method>> entries = methodMap.entrySet();
       /* for(int i=0;i<declaredMethods.length;i++){
            Method declaredMethod = declaredMethods[i];
        }*/

        sb.append("GpInvocationHandler h;" + ln);
        sb.append("public $proxy0(GpInvocationHandler h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);



        for (Map.Entry<String, Method> entry : entries) {
            Method method = entry.getValue();
            Class<?>[] parameterTypes = method.getParameterTypes();


            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                String type = parameterType.getName();
                String typeName = toLowerFirstCase(parameterType.getSimpleName());
                paramValues.append(typeName);
                paramClasses.append(type + ".class");
                paramNames.append(type + " " + typeName);

                if (i != (parameterTypes.length - 1)) {
                    paramValues.append(",");
                    paramClasses.append(",");
                    paramNames.append(",");
                }
            }
            sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramNames.toString() + "){" + ln);
            sb.append("try{" + ln);
            sb.append((hasReturn(method.getReturnType()) ? "return  ("+method.getReturnType().getName()+")" : " ") +"this.h.invoke(this," + entry.getKey() + ",new Object[]{" + paramValues.toString() + "});" + ln);

            sb.append("}catch(Throwable throwable) { " + ln);
            sb.append("throwable.printStackTrace();" + ln);
            sb.append("}" + ln);
            if(hasReturn(method.getReturnType())){
                sb.append("return "+mappings.get(method.getReturnType())+";"+ ln);

            }

            sb.append("}" + ln);


        }


        //Class.forName(name)

        sb.append("}");

        return sb.toString();
    }

    private static Map<Class,Object> mappings = new HashMap<Class, Object>();
    static {
        mappings.put(int.class,0);
        mappings.put(long.class,0);
        mappings.put(short.class,0);
        mappings.put(double.class,0.0d);
        mappings.put(float.class,0.0f);
        mappings.put(char.class,0);
        mappings.put(boolean.class,false);
        mappings.put(byte.class,0);
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static boolean hasReturn(Class<?> clazz) {
        return clazz != void.class;
    }
}
