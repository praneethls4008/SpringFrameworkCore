package org.springframework.proxy.staticProxy.business;


public class FileReaderImplementation implements FileReaderInterface{
    @Override
    public void readFile(String filename, boolean canRead) {
        System.out.println("Reading a "+ filename);
    }

    @Override
    public void writeFile(String filename, boolean canWrite) {
        System.out.println("Writing to "+ filename);
    }
}
