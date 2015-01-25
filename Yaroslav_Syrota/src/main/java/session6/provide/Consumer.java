package session6.provide;

/**
 * Created by Yaroslav_Syrota on 25.01.2015.
 */
public class Consumer extends Thread{
    public static final Consumer CONSUMER = new Consumer();
    public Shelf shelf = Shelf.SHELF;

    private Consumer() {}


}
