package hw3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vladimir on 27.01.2015.
 *
 * Пользователь выбирает график функции (x*x, 10*sin(x/5), x).
 * Построить график выбранной функции звездочками в консоли,
 * на промежутке 0-5.
 *
 * public void print()
 *
 * Плавно строить график заданной функции (задержка в 0.5 секунды)
 * пока пользователь не нажмет Enter.
 *
 * Класс задания:
 * hw3.graph.GraphPresenter
 *
 * Класс теста:
 * hw3.graph.GraphPresenterTest
 */

class GraphPresenter {
    private BufferedReader bufferedReader;
    private InputStreamReader inputStreamReader;
    private PrintingThread printingThread;
    private KeyboardWatchThread keyboardWatchThread;
    private Strategy strategy;

    public GraphPresenter() {
        inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(inputStreamReader);
        printingThread = new PrintingThread();
        keyboardWatchThread = new KeyboardWatchThread();
        strategy = new Strategy();
    }

    public void print() {
        System.out.println("Выберите график функции:");
        System.out.println("1 - x*x");
        System.out.println("2 - 10*sin(x/5)");
        System.out.println("3 - x");
        int userChoice;
        try {
            userChoice = Integer.parseInt(this.bufferedReader.readLine());
        } catch (IOException e) {
            //e.printStackTrace();
            userChoice = 1;
        }
        System.out.println("Для остановки нажмите Enter");
        if (userChoice == 1) {
            strategy.setComputeStrategy(new Square());
        }
        if (userChoice == 2) {
            strategy.setComputeStrategy(new Sine());
        }
        if (userChoice == 3) {
            strategy.setComputeStrategy(new Linear());
        }

        keyboardWatchThread.start();
        printingThread.start();

        keyboardWatchThread.join();
        printingThread.join();
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
            while (!thread.isInterrupted()) {
                Integer currentXShift = strategy.getxShift();
                Integer currentYShift = strategy.computeYShift();
                strategy.setxShift(++currentXShift);

                for (int i = 0; i < currentYShift; i++) {
                    System.out.print(" ");
                }
                System.out.println("*");

                if (currentXShift.equals(6)) {
                    thread.interrupt();
                }

                try {
                    thread.sleep(500);
                } catch (InterruptedException e) {
                    thread.interrupt();
                }
            }
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
                if (bufferedReader.readLine().equals("")) {
                    printingThread.interrupt();
                    this.interrupt();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class Strategy {
        private ComputeStrategy computeStrategy;
        private Integer xShift;

        public Strategy() {
            xShift = 0;
        }

        public Integer computeYShift() {
            return computeStrategy.Compute(xShift);
        }

        public ComputeStrategy getComputeStrategy() {
            return computeStrategy;
        }

        public void setComputeStrategy(ComputeStrategy computeStrategy) {
            this.computeStrategy = computeStrategy;
        }

        public Integer getxShift() {
            return xShift;
        }

        public void setxShift(Integer xShift) {
            this.xShift = xShift;
        }
    }

    private interface ComputeStrategy {
        public Integer Compute(Integer x);
    }

    private class Square implements ComputeStrategy {
        @Override
        public Integer Compute(Integer x) {
            return x * x;
        }
    }

    private class Sine implements ComputeStrategy {
        @Override
        public Integer Compute(Integer x) {
            return (int) (10 * Math.sin(x / 5));
        }
    }

    private class Linear implements ComputeStrategy {
        @Override
        public Integer Compute(Integer x) {
            return x;
        }
    }

}
