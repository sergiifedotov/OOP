package session5;

/**
 * Created by warit on 24.01.2015.
 */
public class TripletonTest {

    public static void main(String[] args) {

        TripletonTest test = new TripletonTest();
        test.testFour();
        test.testInstance();
        test.testNull();

    }

    public void testNull(){

        Tripleton tripleton1 = Tripleton.getInstance();
        Tripleton tripleton2 = Tripleton.getInstance();
        Tripleton tripleton3 = Tripleton.getInstance();

        if(tripleton1!=null&&tripleton2!=null&&tripleton3!=null){
            System.out.println("Test ok");
        }else{
            System.out.println("Test error");
        }

    }

    public  void testInstance(){

        Tripleton tripleton1 = Tripleton.getInstance();
        Tripleton tripleton2 = Tripleton.getInstance();
        Tripleton tripleton3 = Tripleton.getInstance();

        if(tripleton1!=tripleton2&&tripleton1!=tripleton3&&tripleton2!=tripleton3){
            System.out.println("Test ok");
        }else{
            System.out.println("Test error");
        }

    }

    public  void testFour(){

        Tripleton tripleton1 = Tripleton.getInstance();
        Tripleton tripleton2 = Tripleton.getInstance();
        Tripleton tripleton3 = Tripleton.getInstance();
        Tripleton tripleton4 = Tripleton.getInstance();

        if(tripleton4==tripleton1||tripleton4==tripleton2||tripleton4==tripleton3){
            System.out.println("Test ok");
        }else{
            System.out.println("Test error");
        }

    }

}
