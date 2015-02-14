package hw3.parallel;

/**
 * Created by @CAT_Caterpiller on 10.02.2015.
 */
public class MyArrayListTest {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>();

        for(int i = 0; i < 30; i++) {
            list.add(list.size()/2, i + 2);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.println(list.parallelIndexOf(0));
        System.out.println(list.parallelIndexOf(null));
        System.out.println(list.parallelIndexOf(3));
        System.out.println(list.parallelIndexOf(2));
        System.out.println(list.parallelIndexOf(1));
    }
}
