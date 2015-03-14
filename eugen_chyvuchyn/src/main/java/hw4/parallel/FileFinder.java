package hw4.parallel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chuvychin on 04.02.2015.
 */
public class FileFinder implements Runnable{
    public static void main(String[] args) {
        FileFinder ff = new FileFinder();
        ff.parallelFind(new File("D:\\Java"),"test.java");
        int count = ff.getList().size();
        if(count ==0){
            System.out.println("\nNo result found!");
        } else {
            System.out.println("\nFound: "+ count+" result!\n");
            for (String matched : ff.getList()){
                System.out.println("Found: "+ matched);
            }
        }
    }

    private String fileName;
    private List<String> list = new ArrayList<String>();

    public FileFinder() {

    }
    public void parallelFind(String path, String fileName){
        //for jon
    }
    public void parallelFind(File path, String fileName) {

        setFileName(fileName);

        if(path.isDirectory()){
            search(path);
        } else {
            System.out.println(path.getAbsoluteFile()+"is not a directory!");
        }


    }

    public synchronized void search(File file){
        if (file.isDirectory()){
            System.out.println("Searching directory..."+ file.getAbsoluteFile());

            if (file.canRead()){
                for (File temp : file.listFiles()){
                    if(temp.isDirectory()){
                        search(temp);
                    } else{
                        if(getFileName().toLowerCase().equals(temp.getName().toLowerCase())){
                            list.add(temp.getAbsoluteFile().toString());
                        }
                    }
                }
            } else {
                System.out.println(file.getAbsoluteFile()+"Permission Denied");
            }
        }
    }



    @Override
    public void run() {


    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
