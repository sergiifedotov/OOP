package hw3.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Написать текстовый ридер с плавным движением текста вниз. Текст читается из файла. Стоп от ентер.
 * public void read()
 * Класс задания:
 * hw3.reader.TextReader
 * Класс теста:
 * hw3.reader.TextReaderTest
 */
public class TextReader {

    public void read() {
        TextReader.ConsoleViewing concView = new TextReader.ConsoleViewing();
        TextReader.Reader r = new TextReader.Reader(concView);
        r.start();
        TextReader.Console cons = new TextReader.Console(concView);
        cons.start();
    }

    static class Reader implements Runnable {
        private String strFile;
        private Thread thread1;
        private ConsoleViewing cons;

        public Reader(ConsoleViewing con) {
            this.thread1 = new Thread(this);
            this.cons = con;
        }

        @Override
        public void run() {
            read();
            String[] arrayStr = strFile.split("\n");
            for (String i : arrayStr) {
                try {
                    cons.doPrint(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sleep();
            }
        }

        //добавляет текст из указанного по имени файла в строку
        private void read() {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader in = new BufferedReader(new FileReader(new File("Tanya_Gensitskaya/src/main/java/hw3/reader/hello").getAbsoluteFile()));
                try {
                    String str;
                    while ((str = in.readLine()) != null) {
                        sb.append(str);
                        sb.append("\n");
                    }
                } finally {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            strFile = sb.toString();
        }

        public void sleep() {
            try {
                thread1.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void start() {
            thread1.start();
        }

    }


    static class Console implements Runnable {
        private Thread thread2;
        private ConsoleViewing cons;


        public Console(ConsoleViewing con) {
            this.thread2 = new Thread(this);
            this.cons = con;
        }

        @Override
        public void run() {
            try {
                int count = 0;
                while (true) {
                    int i = 0;
                    while (i == 0) {
                        i = System.in.read();
                    }
                    cons.setEnter("enter");
                    count++;
                    if (count % 2 == 0 && count != 0) {
                        cons.setEnter(null);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void start() {
            thread2.start();
        }
    }


    static class ConsoleViewing {
        private int TIMEOUT = 1000;
        private String enter;

        public synchronized void doPrint(String str) throws InterruptedException {
            while (enter != null) {
                wait(TIMEOUT);
            }
            notify();
            System.out.println(str);
        }

        public synchronized void setEnter(String entr) {
            this.enter = entr;
        }
    }

}