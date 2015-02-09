package hw3.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
public class TextReader {
    FileReader reader;

    public void openFile(String fileName) {
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException exc) {
            System.out.println("File not found.");
        }
    }

    public void read() {
        int key = 0;
        Thread readerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                char chr = 0;
                do {
                    StringBuilder builder = new StringBuilder();
                    do try {
                        chr = (char) reader.read();
                        builder.append(chr);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    } while (chr != '\n');
                    System.out.print(builder.toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                } while (chr != -1);
            }
        });
        readerThread.start();

        do {
            try {
                key = System.in.read();
                if (key == '\n') {
                    System.exit(0);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        } while ((key == 13));
    }
}