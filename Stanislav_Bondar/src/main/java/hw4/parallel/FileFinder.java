package hw4.parallel;

import java.io.File;

/**
 Created by stan on 13.02.20.
 */
public class FileFinder implements Runnable {
    private String path = null;
    private String fileName = null;

    public FileFinder() {}

    private FileFinder(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public void parallelFind(String path, String fileName) {
        Thread thread = new Thread(new FileFinder(path, fileName));
        thread.start();
    }

    @Override
    public void run() {
        File startPath = new File(path);
        if (startPath.isDirectory()) {
            for (File file : startPath.listFiles()) {
                if (file.isDirectory()) {
                    Thread thread = new Thread(new FileFinder(file.getAbsolutePath(), fileName));
                    thread.start();
                } else if (file.getName().equals(fileName)){
                    System.out.println(file.getAbsolutePath());
                }
            }
        }

    }
}