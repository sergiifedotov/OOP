package hw3.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Chuvychin on 07.02.2015.
 */
public class TextReader {
    public static void main(String[] args) throws IOException {
        TextReader tr = new TextReader("D:/txt/Firm.txt/",800);
        tr.read();


    }
    private String fileName;
    private long timer;
    BufferedReader br;
    List<String> fileContent = new ArrayList<String>();
    Output out = new Output();
    Scanner scan;


    public TextReader(String fileName, int timer){
        this.fileName = fileName;
        this.timer = timer;
    }

    public void read() {
        try {
            br = new BufferedReader( new InputStreamReader(new FileInputStream(fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String str;
        try {
            while( (str = br.readLine()) !=null){
                fileContent.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        out.start();




        try {
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class Output extends Thread{

        @Override
        public void run(){

            for (int i=0;i<fileContent.size();i++){
                try {
                    Thread.sleep(timer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(fileContent.get(i));

            }
        }
    }
}
