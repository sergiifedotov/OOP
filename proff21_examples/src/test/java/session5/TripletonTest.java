package session5;

public class TripletonTest  {

    public static void main(String[] args) {
        TripletonTest test = new TripletonTest();
        test.testInstances();
        test.testFour();
        test.testNull();
    }

    public void testNull() {
        Tripleton tripleton1 = Tripleton.getInstance();
        Tripleton tripleton2 = Tripleton.getInstance();
        Tripleton tripleton3 = Tripleton.getInstance();

        if (tripleton1 != null && tripleton2 != null &&
                tripleton3 != null) {
            System.out.println("Test Ok");
        } else {
            System.out.println("Test failed");
        }

    }

    public void testInstances() {
        Tripleton tripleton1 = Tripleton.getInstance();
        Tripleton tripleton2 = Tripleton.getInstance();
        Tripleton tripleton3 = Tripleton.getInstance();

        if (tripleton1 != tripleton2 && tripleton2 != tripleton3 &&
                tripleton3 != tripleton1) {
            System.out.println("Test Ok");
        } else {
            System.out.println("Test failed");
        }
    }

    public void testFour() {
        Tripleton tripleton1 = Tripleton.getInstance();
        Tripleton tripleton2 = Tripleton.getInstance();
        Tripleton tripleton3 = Tripleton.getInstance();
        Tripleton tripleton4 = Tripleton.getInstance();

        if (tripleton4 == tripleton2 || tripleton4 == tripleton3 ||
                tripleton4 == tripleton1) {
            System.out.println("Test Ok");
        } else {
            System.out.println("Test failed");
        }

    }
}