package com.gupao.wjg.dynamicProxy.gpProxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GpProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
            throws IllegalArgumentException
    {
        //1、动态生成源代码.java文件
            String src= createSrc(interfaces);
          //  //2、Java文件输出磁盘
        String path = GpProxy.class.getResource("").getPath();
        File file=new File(path+"$Proxy0");

        FileWriter out= null;
        try {
            out = new FileWriter(file);
            out.write(src);
            out.flush();out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    private static String createSrc(Class<?>[] interfaces) {
        if(interfaces==null||interfaces.length==0) {
            throw new IllegalArgumentException("必须实现接口");
        }

        StringBuffer sb=new StringBuffer();
        Class<?> clazz = interfaces[0];
            String name = clazz.getName();
            sb.append("package com.gupao.wjg.dynamicProxy.gpProxy;"+ln);
            sb.append("import "+name+";"+ln);
            sb.append("import java.lang.reflect.*;"+ln);
            sb.append("public final class $proxy0 extends Proxy implements "+clazz.getSimpleName()+"{"+ln);

        Method[] declaredMethods = clazz.getDeclaredMethods();

        for(int j=0;j<declaredMethods.length;j++){
            sb.append("private static Method m"+j+";"+ln);
        }
        sb.append("static{"+ln);
        sb.append("try{"+ln);

        for(int i=0;i<declaredMethods.length;i++){
            Method declaredMethod = declaredMethods[i];
            String methodName = declaredMethod.getName();
            sb.append("m"+i+"= Class.forName(\""+name+"\").getMethod(\""+methodName+"\",new Class[0]);"+ln);
        }

        sb.append("}catch(NoSuchMethodException localNoSuchMethodException){"+ln);
        sb.append("throw new NoSuchMethodError(localNoSuchMethodException.getMessage());"+ln);
        sb.append("}catch(ClassNotFoundException localClassNotFoundException){"+ln);
        sb.append("throw new NoClassDefFoundError(localClassNotFoundException.getMessage());"+ln);
        sb.append("}"+ln);

        for(int i=0;i<declaredMethods.length;i++){
            Method declaredMethod = declaredMethods[i];
        }



        sb.append("}");

        //Class.forName(name)

            sb.append("}");

           return sb.toString();
    }
}
