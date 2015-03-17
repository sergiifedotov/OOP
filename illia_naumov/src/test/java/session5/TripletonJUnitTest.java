package session5;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class TripletonJUnitTest {
    private Tripleton instance;
    @Before
    public void setUp() {
        instance = Tripleton.getInstance();
    }

    @Ignore
    @Test(expected = IOException.class)
    public void testFull() {
        Tripleton tripleton1 = Tripleton.getInstance();
        Tripleton tripleton2 = Tripleton.getInstance();
        Tripleton tripleton3 = Tripleton.getInstance();
        Tripleton tripleton4 = Tripleton.getInstance();

        assertTrue(tripleton1 != null && tripleton2 != null &&
                tripleton3 != null);
        assertTrue(tripleton1 != tripleton2 && tripleton2 != tripleton3 &&
                tripleton3 != tripleton1);
        assertTrue(tripleton4 == tripleton2 || tripleton4 == tripleton3 ||
                tripleton4 == tripleton1);
    }
}