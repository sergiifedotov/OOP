package hw3.parallel;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by CAT_Caterpiller on 28.01.2015.
 */

/*
Написать собственную реализацию динамического массива MyArrayList.
 Сделать параметризированную релизацию списка, параметр E.
 Реализовать следующие методы
 - void add(E value)
 - int get(int index)
 - boolean set(int index, E value)
 - boolean add(int index, E value)
 - int indexOf(E value)
 - int size()
 - E remove(int index)
 */

public class MyArrayList<E> extends ArrayList {
    private E obj;
    private int index = -1;

    public synchronized int getIndex(){
        return index;
    }

    public synchronized  void setIndex(int index){
        this.index = index;
    }

    public int parallelIndexOf(E e) {
        index = -1;

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (getIndex() == -1) {
                    if (e == null) {
                        for (int i = 0; i < size(); i++) {
                            if (getIndex() == -1) {
                                obj = (E) get(i);
                                if (obj == null) {
                                    System.out.println("thread1 ");
                                    setIndex(i);
                                }
                            }
                        }
                    } else {
                        for (int i = 0; i < size(); i++) {
                            if (getIndex() == -1) {
                                obj = (E) get(i);
                                if (e.equals(obj)) {
                                    System.out.print("thread1 ");
                                    setIndex(i);
                                }
                            }
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (getIndex() == -1) {
                    if (e == null) {
                        for (int i = size() - 1; i >= 0; i--) {
                            if (getIndex() == -1) {
                                obj = (E) get(i);
                                if (obj == null) {
                                    System.out.print("thread2 ");
                                    setIndex(i);
                                }
                            }
                        }
                    } else {
                        for (int i = size() - 1; i >= 0; i--) {
                            if (getIndex() == -1) {
                                obj = (E) get(i);
                                if (e.equals(obj)) {
                                    System.out.print("thread2 ");
                                    setIndex(i);
                                }

                            }
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        return index;
    }
}



