package hw2.frequency;

/**
 * Created by Yaroslav_Syrota on 21.01.2015.
 */

public class FreqTest {
    public static void main(String[] args) {
Freq freq = new Freq();
        String outstr = freq.generateRandomText(950);
        System.out.println(outstr.length());
        //System.out.println(outstr);
        freq.fillWordMap(outstr);
        System.out.println(freq.getWordMap());
        System.out.println(freq.getWordsByFrequency(4));
        System.out.println(freq.getWordsByFrequencyMoreThan(4));
        System.out.println(freq.getWordsByFrequencyLessThan(2));

        freq.printAcs();
        freq.printDesc();
        }
}
