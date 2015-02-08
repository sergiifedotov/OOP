package session5;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by tsv on 24.01.15.
 */
public class ThreetonTest {
    //логика
    private ThreetonLazy instance;

    @Before
    public void setUp() {
        instance = ThreetonLazy.getInstanceOne();
    }

//    @Ignore //what????
    @Test(expected = IOException.class)
    public void testNull() {
        ThreetonLazy threetonLazy1 = ThreetonLazy.getInstanceOne();
        ThreetonLazy threetonLazy2 = ThreetonLazy.getInstanceTwo();
        ThreetonLazy threetonLazy3 = ThreetonLazy.getInstanceThree();

        assertTrue(threetonLazy1 != threetonLazy2 && threetonLazy2 != threetonLazy3 && threetonLazy3 != threetonLazy1);
//        {
//            System.out.println("Test ok!");
//        if (threetonLazy1 != threetonLazy2 && threetonLazy2 != threetonLazy3 && threetonLazy3 != threetonLazy1) {
//            System.out.println("Test ok!");
//        } else {
//            System.out.println("Failed");
//        }

        }
}
