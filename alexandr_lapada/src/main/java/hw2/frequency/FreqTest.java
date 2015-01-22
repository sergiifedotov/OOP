package hw2.frequency;
import java.io.*;
import java.util.*;
/**
 * Created by sanya on 22.01.2015.
 */
public class FreqTest {
    public static void main(String[] args) {
        Freq freq = new Freq();

        try {
           // System.out.println(freq.setTextFromConsole());
           // System.out.println(freq.setTextFromFile("freqFile.txt"));
            //System.out.println(freq.generateRandomText(25));

            Set<String> hashSet = freq.getWordsByFrequency(3);
            Iterator<String> iter = hashSet.iterator();
            //System.out.println("size = "+hashSet.size());
            while(iter.hasNext()){
                System.out.println(iter.next());
            }


        }catch(IOException e){
            System.out.println("file not found");
        }

    }
}
