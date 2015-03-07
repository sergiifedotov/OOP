package homework2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by stan on 17.02.15.
 *
 * Написать класс для вычисления частоты слов в тексте с методами:
 - String setTextFromConsole()
 - String setTextFromFile(String fileName)
 - String generateRandomText(int textLength)
 - Set<String> getWordsByFrequency(int frequency)
 - Set<String> getWordsByFrequencyLessThan(int frequency)
 - Set<String> getWordsByFrequencyMoreThan(int frequency)
 - void printAcs() - вывести все слова + частота по возрастанию частоты
 - void printDesc() - вывести все слова + частота по убыванию частоты

 Класс задания hw2.frequency.Freq
 */
public class FreqTest {
    public static void main(String[] args) {
        Freq freq = new Freq();

        try {
            // System.out.println(freq.setTextFromConsole());
            // System.out.println(freq.setTextFromFile("freqFile.txt"));
            //System.out.println(freq.generateRandomText(25));

            //Set<String> hashSet = freq.getWordsByFrequency(3);

            Set<String> hashSet = freq.getWordsByFrequencyMoreThan(3);
            Iterator<String> iterator = hashSet.iterator();
            //System.out.println("size = "+hashSet.size());
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }


        }catch(IOException exception){
            System.out.println("file not found");
        }

    }
}
class Freq {

    private File file = new File("frequency.txt");
    private File fileRandom = new File("Autotext.txt");
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private Scanner in;

    public String setTextFromConsole() throws IOException{
        System.out.print("Enter the text, please : ");
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
        if (!in.hasNext() && iter<textLength){ System.out.println("There are not so much words in the text");}
        in.close();
        return string;
    }

    public Set<String> getWordsByFrequency(int frequency) throws IOException {
        HashSet<String> hashSet = new HashSet<String>();
        HashSet<String> hashSetOut = new HashSet<String>();

        in = new Scanner(file);
        while(in.hasNext()){ hashSet.add(in.next());}
        in.close();

        Iterator<String> iter = hashSet.iterator();

        while(iter.hasNext()){
            int freq = 0;
            in = new Scanner(file);
            String string = iter.next();
            while(in.hasNext()){
                if(string.equals(in.next())){
                    freq++;
                }
            }
            if(freq == frequency){hashSetOut.add(string);}
            in.close();
        }
        return hashSetOut;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency) throws IOException{
        HashSet<String> hashSet = new HashSet<String>();
        HashSet<String> hashSetOut = new HashSet<String>();

        in = new Scanner(file);
        while(in.hasNext()){ hashSet.add(in.next());}
        in.close();

        Iterator<String> iter = hashSet.iterator();

        while(iter.hasNext()){
            int freq = 0;
            in = new Scanner(file);
            String string = iter.next();
            while(in.hasNext()){
                if(string.equals(in.next())){
                    freq++;
                }
            }
            if(freq < frequency){hashSetOut.add(string);}
            in.close();
        }
        return hashSetOut;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) throws IOException{
        HashSet<String> hashSet = new HashSet<String>();
        HashSet<String> hashSetOut = new HashSet<String>();

        in = new Scanner(file);
        while(in.hasNext()){ hashSet.add(in.next());}
        in.close();

        Iterator<String> iter = hashSet.iterator();

        while(iter.hasNext()){
            int freq = 0;
            in = new Scanner(file);
            String string = iter.next();
            while(in.hasNext()){
                if(string.equals(in.next())){
                    freq++;
                }
            }
            if(freq > frequency){hashSetOut.add(string);}
            in.close();
        }
        return hashSetOut;
    }


}
