package hw2.frequency;
import java.io.*;
import java.util.*;
/**
 * Created by sanya on 19.01.2015.
 */
public class Freq {

        private File file = new File("freqFile.txt");
        private File fileRandom = new File("generateRandomText.txt");
        private FileInputStream inputStream;
        private FileOutputStream outputStream;
        private Scanner in;

    public String setTextFromConsole() throws IOException{
        System.out.print("Введите текст : ");
        in = new Scanner(System.in);
        String string = in.next();
        in.close();
        if (!file.exists()) {
            file.createNewFile();
        }
        return string;
    }

    public String setTextFromFile(String fileName) throws IOException{
        inputStream = new FileInputStream(fileName);
        int data = inputStream.read();
        String string = "";
        while(data!=-1){
            string = string + (char)data;
            data = inputStream.read();
        }
        inputStream.close();
        return string;
    }

    public String generateRandomText(int textLength)throws IOException{
        in = new Scanner(fileRandom);
        String string = "";
        int iter = 0;
        while(in.hasNext() && iter < textLength){
            string = string+ " " + in.next();
            iter++;
            if(iter == 10){System.out.println();}
        }
        if (!in.hasNext() && iter<textLength){ System.out.println("В тексте нет столько слов");}
        in.close();
        return string;
    }



    public Set<String> getWordsByFrequency(int frequency) throws IOException {
        HashSet<String> hashSet = new HashSet<String>();
        HashSet<String> hashSetOut = new HashSet<String>();

        in = new Scanner(file);
        while(in.hasNext()){ hashSet.add(in.next());}
        in.close();

        /*for(String e: hashSet){
            System.out.println(e);
        }*/
        Iterator<String> iter = hashSet.iterator();

        while(iter.hasNext()){
            int freq = 0;

            in = new Scanner(file);
            //Thread.sleep(500);
            String string = iter.next();
            //System.out.println(string);
            while(in.hasNext()){
                if(string.equals(in.next())){
                    freq++;
                }
            }
            if(freq == frequency){hashSetOut.add(string);}
            in.close();
            //Thread.sleep(500);
        }

        return hashSetOut;

    }


}
