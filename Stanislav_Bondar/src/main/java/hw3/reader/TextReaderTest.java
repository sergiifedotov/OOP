package hw3.reader;

/**
 Created by stan on 17.02.15.
 */
public class TextReaderTest {
    public static void main(String[] args) {
        TextReader reader = new TextReader();
        reader.openFile("/home/stan/blablabla");
        reader.read();
    }
}
