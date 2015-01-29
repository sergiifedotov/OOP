package hw4.graph;

import java.util.Scanner;

/**
 * Пользователь выбирает график функции (x*x, 10*sin(x/5), x).
 * Построить график выбранной функции звездочками в консоле, на промежутке 0-5.
 */

public class GraphPresenterEx extends Thread {

    @Override
    public void run() {
        GraphPresenter graphPresenter = new GraphPresenter();

        System.out.println("Select type function:");
        System.out.print("1 - Parabola(y=x*x)\t");
        System.out.print("2 - Sinusoid(y=10*sin(x/5))\t");
        System.out.print("3 - Linear(y=x)\t");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int typeFunction = scanner.nextInt();

        if ((typeFunction > 0)&&(typeFunction < 4)) {
            if (typeFunction == 1) {
                graphPresenter.setTypeFunction(new ParabolaFunction());
            } else if (typeFunction == 2) {
                graphPresenter.setTypeFunction(new SinusoidFunction());
            } else if (typeFunction == 3) {
                graphPresenter.setTypeFunction(new LinearFunction());
            }
        }
        graphPresenter.print();

    }

    public static void main(String[] args) {
        GraphPresenterEx graphPresenterEx = new GraphPresenterEx();
        graphPresenterEx.start();
        GraphPresenterExStop graphPresenterExStop = new GraphPresenterExStop();
        graphPresenterExStop.start();
    }
}

class GraphPresenterExStop extends Thread {

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);

        while (!interrupted()) {
            if (scan.nextLine().length()==0){
                /*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                interrupt();
                currentThread().stop();*/
            }

        }

    }

    public static void main(String[] args) {
        GraphPresenterEx graphPresenterEx = new GraphPresenterEx();
        graphPresenterEx.start();
    }

}