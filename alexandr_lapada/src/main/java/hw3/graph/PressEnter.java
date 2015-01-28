package hw3.graph;

import java.io.IOException;

/**
 * Created by sanya on 26.01.2015.
 */
public class PressEnter extends Thread {
    private int code;
    private int i = 0;
    private char ch;
    private Holder hold;

    public PressEnter() {

    }

    public PressEnter(Holder hold) {
        this.hold = hold;
    }

    @Override
    public void run() {
        try {
            while (-1 != (code = System.in.read())) {
                ch = (char) code;
                if ((ch == 10) && (i == 0)) {
                    hold.setValue(true);
                    i = 1;
                } else {
                    if (ch == 10 && i == 1) {;
                        hold.setValue(false);
                        i = 0;
                    }
                }
                if (ch == 'q'){
                    System.exit(0);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
