package hw3.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 Created by stan on 17.02.15.
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
            System.out.println("File not found");
        }
    }

    public void read() {
        int logc = 0;
        Thread readerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                char cach = 0;
                do {
                    StringBuilder builder = new StringBuilder();
                    do try {
                        cach = (char) reader.read();
                        builder.append(cach);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    } while (cach != '\n');
                    System.out.print(builder.toString());
                    try {
                        Thread.sleep(999);
                    } catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                } while (cach != -1);
            }
        });
        readerThread.start();

        do {
            try {
                logc = System.in.read();
                if (logc == '\n') {
                    System.exit(0);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        } while ((logc == 13));
    }
}