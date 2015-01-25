package session6.provide;

/**
 * Created by Yaroslav_Syrota on 25.01.2015.
 */
public class Provider {
    public static final Provider PROVIDER = new Provider();
    private Shelf shelf = Shelf.SHELF;

    private Provider() {}

    public void put() {
        // if(shelf.getValue()==0) shelf.setValue((int) Math.random()*200);
    }
}
