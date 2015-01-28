package hw3.graph;

/**
 * Created by sanya on 25.01.2015.
 */
public class GraphPresenter extends Thread {
    private double x;
    private double y;
    private Holder hold;

    public GraphPresenter() {

    }

    public GraphPresenter(Holder hold) {
        this.hold = hold;
    }

    public void print(){
        double i = 0;
        while (i < 15) {
            if (hold.getValue()) {
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

    @Override
    public void run() {
        print();
    }
}
