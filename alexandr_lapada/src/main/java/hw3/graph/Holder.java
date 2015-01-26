package hw3.graph;

/**
 * Created by sanya on 26.01.2015.
 */
public class Holder {

    private boolean value = false;

    public synchronized void setValue(boolean value) {
        this.value = value;
    }
    public synchronized boolean getValue() {
        return value;
    }
}

