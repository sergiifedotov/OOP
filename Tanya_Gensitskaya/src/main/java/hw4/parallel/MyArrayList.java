package hw4.parallel;

import java.util.ArrayList;

/**
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
 * hw4.parallel.MyArrayList
 * <p/>
 * Класс теста:
 * hw4.parallel.MyArrayListTest
 */
public class MyArrayList {
    private ArrayList<Integer> list = new ArrayList<>();
    private int[] index = new int[1];
    private Thread thread1;
    private Thread thread2;
    private Thread thread3;
    private Thread thread4;


    public int parallelIndexOf(Object el) {
        Integer e = (Integer)el;
        index[0] = -1;
        int minStep = list.size() / 4;

        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < minStep; i++) {
                    Integer value = list.get(i);
                    if (e.equals(value)) {
                        index[0] = i;
                        System.out.println(e + " is find");
                    }
                }
            }
        });

        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = minStep; j < 2 * minStep; j++) {
                    Integer value = list.get(j);
                    if (e.equals(value)) {
                        index[0] = j;
                        System.out.println(e + " is find");
                    }
                }
            }
        });

        thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 2 * minStep; k < 3 * minStep; k++) {
                    Integer value = list.get(k);
                    if (e.equals(value)) {
                        index[0] = k;
                        System.out.println(e + " is find");
                    }
                }
            }
        });

        thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int m = (3 * minStep); m < list.size(); m++) {
                    Integer value = list.get(m);
                    if (e.equals(value)) {
                        index[0] = m;
                        System.out.println(e + " is find");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive()) {
        }
        return index[0];
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }


}
