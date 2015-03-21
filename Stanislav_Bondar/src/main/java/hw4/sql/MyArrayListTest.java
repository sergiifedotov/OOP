package hw4.sql;

/**
 * Created by stan on 13.02.20.

 */
public class MyArrayListTest {

    public static void main(String[] args) throws InterruptedException {

        MyArrayList<String> list = new MyArrayList<String>();
        list.add("MarkAndSpencer");
        list.add("GEOX");
        list.add("napapijri");
        list.add("Penti");
        list.add("befree");
        list.add("Timberland");

        System.out.println(list.parallelIndexOf("Trimberalnd"));

        System.out.println(list.parallelIndexOf("y"));

        list.clear();
        System.out.println(list.parallelIndexOf("y"));

        list.add("ytrewq");
        System.out.println(list.parallelIndexOf("y"));

        System.out.println(list.parallelIndexOf("ytrewq"));

        list.add("Trimberland");
        list.add("vcxz");

        System.out.println(list.parallelIndexOf(null));


    }

}
