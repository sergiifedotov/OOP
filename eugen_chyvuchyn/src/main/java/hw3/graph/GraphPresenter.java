package hw3.graph;

import java.util.Scanner;

import static java.lang.Math.sin;

/**
 * Created by Chuvychin on 07.02.2015.
 *  Пользователь выбирает график функции (x*x, 10*sin(x/5), x). Построить график выбранной функции звездочками в консоле, на промежутке 0-5.

 public void print()

 Плавно строить график заданной функции (задержка в 0.5 секунды) пока пользователь не нажмет ентер.

 Класс задания:
 hw3.graph.GraphPresenter

 Класс теста:
 hw3.graph.GraphPresenterTest
 */
public class GraphPresenter {
 public void print() {
  Scanner scanner = new Scanner(System.in);
  System.out.println("Выберите функцию:");
  System.out.println("1. y = x*x  Парабола");
  System.out.println("2. y = 10*sin(x/5) Синусоида");
  System.out.println("3. y = x Прямая");
  System.out.print("Выберите один из пунктов(1, 2, 3): ");
  int userSelection = 0;
  while ((userSelection < 1) || (userSelection > 3)) {
   userSelection = scanner.nextInt();
  }
  System.out.println("Выбрано: " + userSelection);

  GraphPresenterThread thread = new GraphPresenterThread(userSelection);
  thread.start();

  scanner = new Scanner(System.in);
  scanner.nextLine();
  thread.interrupt();
 }
}

class GraphPresenterMain {
 public static void main(String[] args) {
  GraphPresenter graphPresenter = new GraphPresenter();
  graphPresenter.print();
 }
}

class GraphPresenterThread implements Runnable {
 private int funcMenuNumber;
 private Thread thread;

 public GraphPresenterThread(int functionMenuNumber) {
  if ((functionMenuNumber < 1) || (functionMenuNumber > 3)) {
   functionMenuNumber = 1;
  }
  this.funcMenuNumber = functionMenuNumber;
  this.thread = new Thread(this);
 }

 private int setFunction(int x) {
  switch (funcMenuNumber) {
   case 1:
    return x * x;
   case 2:
    return (int) (10 + 10 * sin((double) x / 5));
   case 3:
    return x;
  }
  return x;
 }

 private String getLineByX(int x) {
  String str = "";
  for (int i = 0; i < setFunction(x); i++) {
   str += " ";
  }
  str += "*";
  return str;
 }

 @Override
 public void run() {
  try {
   for (int x = 0; x < 50; x++) {
    System.out.println(getLineByX(x));
   Thread.sleep(500);
  }
  } catch (InterruptedException e) {
   System.out.println("Прервано пользователем.");
  }
 }

 public void start() {
  thread.start();
 }

 public void interrupt() {
  thread.interrupt();
 }
}
