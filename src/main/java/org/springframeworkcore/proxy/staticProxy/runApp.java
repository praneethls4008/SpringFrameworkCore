package org.springframeworkcore.proxy.staticProxy;

import org.springframeworkcore.proxy.staticProxy.business.FileReaderImplementation;
import org.springframeworkcore.proxy.staticProxy.business.FileReaderInterface;
import org.springframeworkcore.proxy.staticProxy.proxy.FileReaderProxyInvocationHandler;

import java.lang.reflect.Proxy;

public class runApp {


    public static void main(String args[]){

        FileReaderInterface fileReaderProxyObj = (FileReaderInterface) Proxy.newProxyInstance(
                FileReaderImplementation.class.getClassLoader(),
                new Class[]{FileReaderInterface.class},
                new FileReaderProxyInvocationHandler(new FileReaderImplementation())
        );

        fileReaderProxyObj.readFile("myFile1.txt", true);
        fileReaderProxyObj.readFile("myFile1.txt", false);

        fileReaderProxyObj.writeFile("myFile2.txt", true);
        fileReaderProxyObj.writeFile("myFile2.txt", false);


    }

}
