package hw4.sql.parallel;

/**
 * Created by warit on 28.01.2015.
 */
public class TaskTest {


    public static void fillVector(MyArrayList<Integer> vector, int size)
    {
        for(int i=0; i<size; i++){

                vector.add((int) (1000*Math.random()));

        }
    }

    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        fillVector(myArrayList,100000);
        /*myArrayList.add(2);
        myArrayList.add(9);
        myArrayList.add(0);
        myArrayList.add(7);
        myArrayList.add(1);*/
        //System.out.println(myArrayList.toString());
        System.out.println(myArrayList.parallelIndexOf(923));

    }

}
