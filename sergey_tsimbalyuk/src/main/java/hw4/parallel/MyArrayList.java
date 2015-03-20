package hw4.parallel;

import java.util.Arrays;

/**
 * Created by Tsimbalyuk Sergey
 * 1/31/2015.
 * <p/>
 * Реализовать в классе MyArrayList метод
 * public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 * В тестах проверить поиск:
 * - существующего элемента
 * - не существующего элемента
 * - не существующего элемента в пустом массиве
 * - не существующего элемента в массиве с одним элементом
 * - существующего элемента в массиве с одним элементом
 * - элемента со значением null
 * <p/>
 * Класс задания:
 * MyArrayList
 * Класс теста:
 * MyArrayListTest
 */

public class MyArrayList {

}
/*
public class MyArrayList<E> {

    private E[] array;
    private int size;

    public MyArrayList() {
        array = (E[]) new Object[5];
    }

    public void add(E e) {
        if (size < array.length) {
            array[size++] = e;
        } else if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
            array[size++] = e;
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        return array[index];
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            array[i] = null;
        }
        size = 0;

    }

    public int parallelIndexOf(E elem) {
        new ListThread(1).start();
        new ListThread(2).start();
        new ListThread(3).start();
        new ListThread(4).start();
        new ListThread(5).start();
        for (int i = 0; i < size(); i++) {
            if (elem != null && elem.equals(array[i])) {
                return 1;
            }
        }
        return 0;
    }

    public class ListThread extends Thread {
        int number;
        int part = size / 5;

        public ListThread(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            if (number == 1) {
                for (int i = 0; i < part; i++) {
                    get(i);
                }
            }
            if (number == 2) {
                for (int i = part; i < part * 2; i++) {
                    get(i);
                }
            }
            if (number == 3) {
                for (int i = part * 2; i < part * 3; i++) {
                    get(i);
                }
            }
            if (number == 4) {
                for (int i = part * 3; i < part * 4; i++) {
                    get(i);
                }
            }
            if (number == 5) {
                for (int i = part * 4; i < size; i++) {
                    get(i);
                }
            }
            if (number > 5) {
                System.err.println("Can't create more than five threads");

            }
        }

    }

    }
    */



/*class ArrayMain {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(list.parallelIndexOf(90));

    }
}*/
