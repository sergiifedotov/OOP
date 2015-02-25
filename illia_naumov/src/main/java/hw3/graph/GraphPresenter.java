package hw3.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by illia_naumov on 27.01.2015.
 *
 *  Пользователь выбирает график функции (x*x, 10*sin(x/5), x).
 *  Построить график выбранной функции звездочками в консоле, на промежутке 0-5.

 public void print()

 Плавно строить график заданной функции (задержка в 0.5 секунды)
 пока пользователь не нажмет ентер.

 Класс задания:
 hw3.graph.GraphPresenter

 Класс теста:
 hw3.graph.GraphPresenterTest
 */

public class GraphPresenter {
    public static void main(String[] args) throws InterruptedException, IOException {
        Printer printer = new Printer();
        printer.start();
        KeyListener breaker = new KeyListener(printer);
        breaker.start();
        printer.join();
        breaker.join();


    }

    static class Printer extends Thread {
        BufferedReader buffer;

        @Override
        public void run() {
            System.out.println("Choose which graphical function you want to print");
            System.out.println("Type 1 for x*x");
            System.out.println("Type 2 for 10*sin(x/5)");
            System.out.println("Type 3 for x");

            try {
                buffer = new BufferedReader(new InputStreamReader(System.in));
                int userChoice = Integer.parseInt(buffer.readLine());
                System.out.println("Type ENTER to stop");
                switch (userChoice) {
                    case (1):
                        print(1);
                        break;
                    case (2):
                        print(2);
                        break;
                    case (3):
                        print(3);
                        break;
                }
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }

/*     @Override
     public void interrupt() {
         Thread.currentThread().interrupt();
     }*/

        public void print(int function) throws InterruptedException {

            String indents;
            for (int x = 0; x < 6; x++) {
                if (isInterrupted()) {
                    return;
                }
                indents = "";
                double y = 0;
                if (function == 1) {
                    y = x * x;
                } else if (function == 2) {
                    y = 10 * Math.sin(x * 0.2);
                } else if (function == 3) {
                    y = x;
                }
                for (int j = 0; j < y; j++) {
                    indents += " ";
                }
                System.out.println(indents + "*");
                Thread.sleep(500);
            }

        }


    }

    static class KeyListener extends Thread {
        Thread printer;

        KeyListener(Thread thread) {
            printer = thread;
        }

        @Override
        public void run() {

            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (printer.isAlive()) {
                    String i = buffer.readLine();

                    if (i.equals("a")) {

                        printer.interrupt();

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}

