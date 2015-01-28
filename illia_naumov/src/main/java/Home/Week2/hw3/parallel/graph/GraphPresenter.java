package Home.Week2.hw3.parallel.graph;


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
    boolean suspendFlag = false;

    public static void main(String[] args) throws InterruptedException, IOException {
        GraphPresenter graph = new GraphPresenter();
        graph.print();
    }

    public void print() throws InterruptedException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        KeyListenerTester breaker = new KeyListenerTester();

        System.out.println("Choose which graphical function you want to print");
        System.out.println("Type 1 for x*x");
        System.out.println("Type 2 for 10*sin(x/5)");
        System.out.println("Type 3 for x");
        String cho = bf.readLine();
        int choice = Integer.parseInt(cho);
        breaker.start();

        switch (choice) {
            case (1):
                printXX();
                break;
            case (2):
                printSin();
                break;
            case (3):
                printX();
                break;
        }
        breaker.join();
    }

    public void printXX() throws InterruptedException {
        String indents;
        for (int x = 0; x < 6; x++) {
            indents = "";
            for (int j = 0; j < x * x; j++) {
                indents += " ";
            }
            synchronized (this) {
                while (suspendFlag) {
                    Thread.interrupted();
                }
            }
            System.out.println(indents + "*");
            Thread.sleep(500);
        }
    }

    public void printSin() throws InterruptedException {
        String indents;
        for (int x = 0; x < 6; x++) {
            indents = "";
            for (int j = 0; j < 10 * Math.sin(x * 0.2); j++) {
                indents += " ";
            }
            synchronized (this) {
                while (suspendFlag) {
                    Thread.interrupted();
                }
            }
            System.out.println(indents + "*");
            Thread.sleep(500);
        }
    }

    public void printX() throws InterruptedException {
        String indents;
        for (int x = 0; x < 6; x++) {
            indents = "";
            for (int j = 0; j < x; j++) {
                indents += " ";
            }
            synchronized (this) {
                while (suspendFlag) {
                    Thread.interrupted();
                }
            }
            System.out.println(indents + "*");
            Thread.sleep(500);
        }
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    class KeyListenerTester extends Thread {

        @Override

        public void run() {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                try {

                    String str = bf.readLine();
                    if (str.contains("\n")) {
                        mysuspend();
                    }
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                /**JTextField function = new JTextField(8);
                 function.addActionListener(new ActionListener() {

                 public void actionPerformed(ActionEvent e) {

                 //statements!!!
                 int key = e.getID();
                 if(key == KeyEvent.VK_ENTER){
                 mysuspend();
                 }

                 }
                 });*/
                }
            }
        }
    }



