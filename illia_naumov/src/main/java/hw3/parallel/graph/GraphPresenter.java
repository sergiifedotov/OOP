package hw3.parallel.graph;


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
    BufferedReader buffer;
    public static void main(String[] args) throws InterruptedException, IOException {
        KeyListener breaker = new KeyListener();
        breaker.start();
        GraphPresenter graph = new GraphPresenter();
        breaker.start();
        breaker.join();


    }

        public void choose (){
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
            } catch (IOException excep) {
                excep.printStackTrace();
            } catch (InterruptedException excep) {
                //e.printStackTrace();
            }
        }

        public void print(int function) throws InterruptedException {

            String indents;
            for (int ix = 0; ix < 6; ix++) {
                indents = "";
                double iy = 0;
                if (function == 1) {
                    iy = ix * ix;
                } else if (function == 2) {
                    iy = 10 * Math.sin(ix * 0.2);
                } else if (function == 3) {
                    iy = ix;
                }
                for (int j = 0; j < iy; j++) {
                    indents += " ";
                }
                System.out.println(indents + "*");
                Thread.sleep(500);
            }

        }




   static class KeyListener extends Thread {

        KeyListener(Thread thread) {

        }

       public KeyListener() {

       }

       @Override
        public void run() {

            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (true) {
                    String i = buffer.readLine();

                    if (i.equals("a")) {

                        Thread.currentThread().interrupt();

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}



