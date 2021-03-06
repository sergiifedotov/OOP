package hw4.parallel;

/**
 * Created by vladimir on 27.01.2015.
 *
 * Реализовать в классе MyArrayList метод
 * public int parallelIndexOf(E e), выполняющий линейный
 * многопоточный поиск в списке.
 *
 * Примечание: в списке может быть несколько подходящих элементов.
 * Поиск должен останавливаться при первом совпадении.
 *
 * В тестах проверить поиск:
 * - существующего элемента
 * - несуществующего элемента
 * - несуществующего элемента в пустом массиве
 * - несуществующего элемента в массиве с одним элементом
 * - существующего элемента в массиве с одним элементом
 * - элемента со значением null
 *
 * Класс задания:
 * hw3.parallel.MyArrayList
 *
 * Класс теста:
 * hw3.parallel.MyArrayListTest
 */

public class MyArrayListTest {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        MyArrayList<Integer> myArrayList = new MyArrayList();

        boolean actual;
        boolean expected;

        System.out.println("несуществующего элемента в пустом массиве");
        actual = myArrayList.parallelIndexOf(new Integer(123)) == -1;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();

        myArrayList.add(0);
        //System.out.println(myArrayList);
        System.out.println("несуществующего элемента в массиве с одним элементом");
        actual = myArrayList.parallelIndexOf(new Integer(123)) == -1;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();

        //
        for (int i = 1; i < 25; i++) {
            myArrayList.add(i);
        }
        //System.out.println(myArrayList);
        System.out.println("существующего элемента");
        actual = myArrayList.parallelIndexOf(new Integer(19)) != -1;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();

        System.out.println("несуществующего элемента");
        actual = myArrayList.parallelIndexOf(new Integer(123)) == -1;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();

        myArrayList.set(15, null);
        //System.out.println(myArrayList);
        System.out.println("элемента со значением null");
        actual = myArrayList.parallelIndexOf(null) != -1;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();
    }
}
