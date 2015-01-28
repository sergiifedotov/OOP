package hw3.graph;

/**
 * Created by sanya on 25.01.2015.
 */
public class GraphPresenter {
    private double x;
    private double y;
    private boolean wait = false;

    public GraphPresenter() {

    }

    public synchronized void setWait(boolean wait) {
        this.wait = wait;
    }

    public synchronized boolean getWait() {
        return wait;
    }

    public void print() {
        double i = 0;
        while (i < 10) {
            if (getWait()) {
                try {
                    x = i;
                    y = x * x;
                    for (double ox = 0; ox < x; ox += 1) {
                        System.out.println("");
                        for (double oy = 0; oy < y; oy += 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print("*");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i += 1;
            }

        }

    }
}
