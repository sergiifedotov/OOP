package hw3.reader;

/**
 * Created by Tanya on 27.01.2015.
 */
public class TextReaderTest {
    public static void main(String[] args) {
        TextReader.ConsoleViewing concView = new TextReader.ConsoleViewing();
        TextReader.Reader r = new  TextReader.Reader(concView);
        r.start();
        TextReader.Console cons = new  TextReader.Console(concView);
        cons.start();
    }
}


