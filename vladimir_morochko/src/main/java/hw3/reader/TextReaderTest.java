package hw3.reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by vladimir on 27.01.2015.
 *
 * Написать текстовый ридер с плавным движением текста вниз.
 * Текст читается из файла. Стоп от Enter.
 * public void read()
 *
 * Класс задания:
 * hw3.reader.TextReader
 *
 * Класс теста:
 * hw3.reader.TextReaderTest
 */

public class TextReaderTest {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        textReader.read();
    }
}
