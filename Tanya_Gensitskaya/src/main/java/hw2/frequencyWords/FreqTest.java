package hw2.frequencyWords;


/**
 * Created by Tanya on 22.01.2015.
 */
public class FreqTest {
    public static void main(String[] args) {
        Freq f = new Freq();
        f.setTextFromFile("Tanya_Gensitskaya/src/main/java/hw2/frequencyWords/hello");
//        System.out.println("Содержимое текстового файла:");
        System.out.println(f.setTextFromFile("Tanya_Gensitskaya/src/main/java/hw2/frequencyWords/hello"));
//      System.out.println(f.generateRandomText(200));

        System.out.println("возвращает множество слов, которые встречаются указанное количество раз");
        f.print(f.getWordsByFrequency(1));

        System.out.println("возвращает множество слов (слово , частота)");
        f.print(f.wordsAndFreq());

        System.out.println("множество, которое встречается реже");
        f.print(f.getWordsByFrequencyLessThan(5));

        System.out.println("множество, которое встречается чаще");
        f.print(f.getWordsByFrequencyMoreThan(4));

        System.out.println("вывести все слова + частота по возрастанию частоты");
        f.printAcs();

        System.out.println("вывести все слова + частота по убыванию частоты");
        f.printDesc();


    }
}





