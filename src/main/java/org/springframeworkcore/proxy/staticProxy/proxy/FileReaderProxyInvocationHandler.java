package org.springframeworkcore.proxy.staticProxy.proxy;

import org.springframeworkcore.proxy.staticProxy.business.FileReaderInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FileReaderProxyInvocationHandler implements InvocationHandler {
    private final FileReaderInterface targetObject;

    public FileReaderProxyInvocationHandler(FileReaderInterface targetObject){
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().equalsIgnoreCase("readFile") && ((Boolean)args[1])){
            System.out.println("can read file");
            return method.invoke(targetObject, args);
        }
        else if(method.getName().equalsIgnoreCase("writeFile") && ((Boolean)args[1])){
            System.out.println("can write file");
            return method.invoke(targetObject, args);
        }
        else{
            System.out.println("acess denied for function "+ method.getName());
        }
        return null;
    }
}
