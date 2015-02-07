package session5;

/**
 * Created by tsv on 24.01.15.  
 */
public class ThreetonLazy {

    private static ThreetonLazy instanceOne = new ThreetonLazy();
    private static ThreetonLazy instanceTwo = new ThreetonLazy();
    private static ThreetonLazy instanceThree = new ThreetonLazy();

    private ThreetonLazy() {
    }

    public synchronized static ThreetonLazy getInstanceOne() {
        if (instanceOne == null) {
            return new ThreetonLazy();
        }
        return instanceOne;
    }

    public synchronized static ThreetonLazy getInstanceTwo() {
        if (instanceTwo == null) {
            return new ThreetonLazy();
        }
        return instanceTwo;
    }

    public synchronized static ThreetonLazy getInstanceThree() {
        if (instanceThree == null) {
            return new ThreetonLazy();
        }
        return instanceThree;
    }
}
