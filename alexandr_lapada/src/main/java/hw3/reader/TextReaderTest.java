package hw3.reader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 Написать текстовый ридер с плавным движением текста вниз. Текст читается из файла. Стоп от ентер.
 public void read()

 Класс задания:
 hw3.reader.TextReader

 Класс теста:
 hw3.reader.TextReaderTest
 */
public class TextReaderTest {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();

        Thread readEnter = new Thread(new Runnable() {

            @Override
            public void run() {
                int code;
                try {
                    while (-1 != (code = System.in.read())) {
                        if (code == 10) {
                            textReader.setWait(!textReader.getWait());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        readEnter.start();

        try {
            textReader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        readEnter.stop();
    }
}

