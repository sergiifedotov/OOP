package hw4.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Пользователь выбирает график функции (x*x, 10*sin(x/5), x). Построить график выбранной функции звездочками в консоле, на промежутке 0-5.
 * public void print()
 * <p/>
 * Плавно строить график заданной функции (задержка в 0.5 секунды) пока пользователь не нажмет ентер.
 * Класс задания:
 * GraphPresenter
 * Класс теста:
 * GraphPresenterTest
 */
public class GraphPresenter {
    private final ArrayList <String> listFromConsole = new ArrayList<>();
    private Thread thread1;


    public void present() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Сделайте выбор № графика для презентации: \n" +
                "1. у = x*x \n" +
                "2. у = x \n" +
                "3. у = 10*sin(x/5) \n" +
                "4. Enter for EXIT");
        if (listFromConsole.isEmpty()) {
            listFromConsole.add("notNull");
        }
        while(!listFromConsole.get(0).equals("")) {
           String str = scan.nextLine();
            listFromConsole.set(0, str);
            if ("".equals(str) && thread1 != null) {
                thread1.interrupt();
            } else {
                thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String code = listFromConsole.get(0);
                        switch (code) {
                            case "1":
                                presentGraph1();
                                break;
                            case "2":
                                presentGraph2();
                                break;
                            case "3":
                                presentGraph3();
                                break;
                            default:

                                break;
                        }
                    }
                });
                thread1.start();
            }
        }
    }


    public void presentGraph1() {
        for (int i = 0; i < 6; i++) {
            int y1 = i * i;
            for (int j = 0; j <= y1; j++) {
                if (j == y1) {
                    System.out.println("*");
                }
                System.out.print(" ");
            }
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void presentGraph2() {
        for (int i = 0; i < 6; i++) {
            int y2 = i;
            for (int j = 0; j <= y2; j++) {
                if (j == y2) {
                    System.out.println("*");
                }
                System.out.print(" ");
            }
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }


    public void presentGraph3() {
        for (int i = 0; i < 181; i += 30) {
            int y3 = (int) (10 * Math.sin((i * (Math.PI / 180)) / 5));
            for (int j = 0; j <= y3; j++) {
                if (j == y3) {
                    System.out.println("*");
                }
                System.out.print(" ");
            }
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
