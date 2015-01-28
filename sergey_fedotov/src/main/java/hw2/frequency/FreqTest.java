package hw2.frequency;

import java.util.Map;

/**
 * Created by warit on 23.01.2015.
 */
public class FreqTest {

    public static void setTextFromConsoleTest(String nameTest, Freq freq, String text, String rezult) {
        String rez;
        rez = freq.setTextFromConsole(text);

        if (rez.equals(rezult)) {
            System.out.println(nameTest.concat("completed successfully"));
        } else {
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void setTextFromFileTest(String nameTest, Freq freq, String fileName, String rezult) {
        String rez;

        try {
            rez = freq.setTextFromFile(fileName);
            System.out.println(rez);
        } catch (Exception e) {
            //e.printStackTrace();
            rez = "";
        }

        if (rez.equals(rezult)) {
            System.out.println(nameTest.concat("completed successfully"));
        } else {
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void main(String[] args) {

        Freq freq = new Freq();

        String nameTest;

        nameTest = "setTextFromConsoleTest1:";
        setTextFromConsoleTest(nameTest, freq, "Иван", "Иван");

        nameTest = "setTextFromFileTest1:";
        setTextFromFileTest(nameTest, freq, "file1.txt", "23 25");

    }
}