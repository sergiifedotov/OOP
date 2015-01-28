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
        final GraphPresenter graph = new GraphPresenter();

        Thread readEnter = new Thread(new Runnable() {
            @Override
            public void run() {
                int code;
                boolean wait = false;
                try {
                    while (-1 != (code = System.in.read())) {
                        if (code == 10) {
                            wait = !wait;
                            graph.setWait(wait);
                            System.out.println(wait);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        readEnter.start();

        graph.print();

    }

}





