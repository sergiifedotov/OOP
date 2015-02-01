package hw3.parallel;

/**
 * Created by Tsimbalyuk Sergey
 * 1/31/2015.
 * random word generator - http://watchout4snakes.com/wo4snakes/Random/RandomWord
 */
public class MyArrayListTest {

    public static void main(String[] args) throws InterruptedException {

        MyArrayList<String> list = new MyArrayList<String>();
        list.add("bind");
        list.add("consistency");
        list.add("sunrise");
        list.add("ego");
        list.add("undoing");
        list.add("segment");

        // - существующего элемента
        System.out.println(list.parallelIndexOf("asdf"));

        // - не существующего элемента
        System.out.println(list.parallelIndexOf("q"));

        // - не существующего элемента в пустом массиве
        list.clear();
        System.out.println(list.parallelIndexOf("q"));

        // - не существующего элемента в массиве с одним элементом
        list.add("qwerty");
        System.out.println(list.parallelIndexOf("q"));

        // - существующего элемента в массиве с одним элементом
        System.out.println(list.parallelIndexOf("qwerty"));

        list.add("asdf");
        list.add("zxcv");
        // - элемента со значением null
        System.out.println(list.parallelIndexOf(null));


    }

}
