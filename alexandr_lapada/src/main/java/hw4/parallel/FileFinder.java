package hw4.parallel;

import java.io.File;
import java.util.Scanner;

/**
 * Created by sanya on 02.02.2015.
 */
public class FileFinder extends Thread {
    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        File f;
        String path, file;
        boolean result = false;
        System.out.println("Enter the required path for search: ");
        path = input.nextLine();
        f = new File(path + ".");
        //System.out.println(f.getAbsolutePath());
        //System.out.println(f.getPath());
        System.out.println("Enter the name of required file: ");
        file = input.nextLine();
        File[] files = f.listFiles();
        for (int i = 0;i < files.length; i++) {
            if (files[i].toString().equals(path + ".\\" + file) && files[i].isFile()) {
                result = true;
                break;
            }
        }
        if (result == true)

            System.out.println("File located in the folder");
        else System.out.println("File was not found ");
    }
}
