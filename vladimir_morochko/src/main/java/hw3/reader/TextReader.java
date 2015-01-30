package hw3.reader;

import java.io.*;
import java.util.Scanner;

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

public class TextReader {
    private String fileName;
    private Integer outputDelay = 1000;

    private BufferedReader bufferedKeyboardReader;
    private InputStreamReader keyboardStreamReader;

    private FileReader fileReader;
    private Scanner scanFile;

    private PrintingThread printingThread;
    private KeyboardWatchThread keyboardWatchThread;


    public TextReader() {
        this.fileName = "pom.xml";
        //this.fileName = "vladimir_morochko/src/main/java/hw3/reader/Lorem.txt";
    }

    public TextReader(String fileName) {
        this();
        this.fileName = fileName;
    }

    public void read() {
        keyboardStreamReader = new InputStreamReader(System.in);
        bufferedKeyboardReader = new BufferedReader(keyboardStreamReader);

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanFile = new Scanner(fileReader);

        printingThread = new PrintingThread();
        keyboardWatchThread = new KeyboardWatchThread();

        keyboardWatchThread.start();
        printingThread.start();

        keyboardWatchThread.join();
        printingThread.join();
        scanFile.close();
    }

    private class PrintingThread implements Runnable {
        private Thread thread;

        public PrintingThread() {
            thread = new Thread(this);
        }

        public void start() {
            thread.start();
        }

        public void interrupt() {
            thread.interrupt();
        }

        public void join() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (!thread.isInterrupted() && scanFile.hasNextLine()) {
                System.out.println(scanFile.nextLine());

                try {
                    thread.sleep(outputDelay);
                } catch (InterruptedException e) {
                    thread.interrupt();
                }
            }
            //keyboardWatchThread.interrupt();
        }
    }

    private class KeyboardWatchThread implements Runnable {
        private Thread thread;

        public KeyboardWatchThread() {
            thread = new Thread(this);
        }

        public void start() {
            thread.start();
        }

        public void interrupt() {
            thread.interrupt();
        }

        public void join() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                if (bufferedKeyboardReader.readLine().length() >= 0) {
                    printingThread.interrupt();
                    //this.interrupt();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getOutputDelay() {
        return outputDelay;
    }

    public void setOutputDelay(Integer outputDelay) {
        this.outputDelay = outputDelay;
    }

}
