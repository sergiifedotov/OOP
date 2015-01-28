package hw4.parallel;

import hw4.parallel.MyArrayList;
import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Реализовать в классе MyArrayList метод
 public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 В тестах проверить поиск:
 - существующего элемента
 - не существующего элемента
 - не существующего элемента в пустом массиве
 - не существующего элемента в массиве с одним элементом
 - существующего элемента в массиве с одним элементом
 - элемента со значением null
 */
public class MyArrayListTest {

    @Test
    public void testSearchExisting(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(2);
        myArrayList.add(9);
        myArrayList.add(0);
        myArrayList.add(7);
        myArrayList.add(1);

        assertEquals(myArrayList.parallelIndexOf(1),4);

    }

    @Test
    public void testSearchNonexistent(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(2);
        myArrayList.add(9);
        myArrayList.add(0);
        myArrayList.add(7);
        myArrayList.add(1);

        assertEquals(myArrayList.parallelIndexOf(4),-1);

    }

    @Test
    public void testSearchNonexistentInEmptyArray(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        assertEquals(myArrayList.parallelIndexOf(4),-1);

    }

    @Test
    public void testSearchNonexistentInArrayOneElement(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(56);

        assertEquals(myArrayList.parallelIndexOf(4),-1);

    }

    @Test
    public void testSearchExistingInArrayOneElement(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(56);

        assertEquals(myArrayList.parallelIndexOf(56),0);

    }

    @Test
    public void testSearchElementNull(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(2);
        myArrayList.add(9);
        myArrayList.add(0);
        myArrayList.add(null);
        myArrayList.add(1);

        assertEquals(myArrayList.parallelIndexOf(null),3);

    }

}
