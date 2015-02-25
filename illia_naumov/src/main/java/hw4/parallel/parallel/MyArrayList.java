package hw4.parallel.parallel;

import java.util.ArrayList;

/**
 * Created by illia_naumov on 26.01.2015.
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
 * hw3.parallel.MyArrayList
 * <p/>
 * Класс теста:
 * hw3.parallel.MyArrayListTest
 */
public class MyArrayList<E> {

    public static void main(String[] args) throws InterruptedException {
        MyArrayList<Integer> listik = new MyArrayList<>();
        listik.add(1);
        listik.add(2);
        listik.add(3);

        System.out.println(listik.parallelIndexOf(22));
    }

    ArrayList<E> list;
    public int keyRight;
    public int keyLeft;
    public boolean isFound = false;
    public int searchingElement;


    public MyArrayList() {
        list = new ArrayList<E>();
    }

    public void add(E e) {
        list.add(e);
    }

    public void setElement(Integer e) {
        searchingElement = e;
    }

    public int parallelIndexOf(E e) throws InterruptedException {
        LeftSearch ls = new LeftSearch(e);
        RightSearch rs = new RightSearch(e);
        ls.start();
        rs.start();
        if (isFound) {
            return searchingElement;
        } else {
            return -1;
        }


    }

    class LeftSearch extends Thread {
        E e;

        public LeftSearch(E e) {
            this.e = e;
        }

        @Override
        public synchronized void run() {
            keyLeft = 0;
            for (int i = keyLeft; i < list.size() - 1; i++) {
                keyLeft++;
                if (keyLeft >= keyRight) {
                    return;
                }
                if (list.get(i).equals(e)) {
                    setElement(i);
                    isFound = true;
                    return;

                }
            }
        }
    }

    class RightSearch extends Thread {
        E e;

        public RightSearch(E e) {
            this.e = e;
        }

        @Override
        public void run() {
            keyRight = list.size() / 2;
            for (int i = keyRight; i > 0; i--) {
                keyRight--;
                if (keyLeft >= keyRight) {
                    return;
                }
                if (list.get(i).equals(e)) {
                    setElement(i);
                    isFound = true;
                    return;
                }
            }
        }
    }
}
