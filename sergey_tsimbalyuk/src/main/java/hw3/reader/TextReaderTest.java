package hw3.reader;

/**
 * Created by Tsimbalyuk Sergey on 31.01.15.
 * Написать текстовый ридер с плавным движением текста вниз.
 * Текст читается из файла. Стоп от ентер.
 *  public void read()
 *  Класс задания:
 *  hw3.reader.TextReader
 *  Класс теста:
 *  hw3.reader.TextReaderTest
 */
public class TextReaderTest {
    public static void main(String[] args) {
        TextReader reader = new TextReader();
        reader.openFile("/home/tsv/bash.xml");
        reader.read();
    }
}
