package org.springframework.proxy.staticProxy.business;

public interface FileReaderInterface {
    public void readFile(String filename, boolean canRead);
    public void writeFile(String filename, boolean canWrite);
}
