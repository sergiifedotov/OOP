package hw3.graph;

import java.io.IOException;

/**
 Пользователь выбирает график функции (x*x, 10*sin(x/5), x). Построить график выбранной функции звездочками в консоле, на промежутке 0-5.

 public void print()

 Плавно строить график заданной функции (задержка в 0.5 секунды) пока пользователь не нажмет ентер.

 Класс задания:
 hw3.graph.GraphPresenter

 Класс теста:
 hw3.graph.GraphPresenterTest
 */
public class GraphPresenterTest {

    public static void main(String[] args) {
        Holder hold = new Holder();

        GraphPresenter thr1 = new GraphPresenter(hold);
        thr1.start();
        PressEnter thr2 =new PressEnter(hold);
        thr2.start();



    }
}




