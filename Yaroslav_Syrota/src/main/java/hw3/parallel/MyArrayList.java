package hw3.parallel;

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

public class MyArrayList<E> implements Runnable{
    private int size;
    private E[] array;


    public MyArrayList () {
        array = (E[]) new Object[10];
    }

    public MyArrayList (int ensureCapacityNum) {
        array = (E[]) new Object[ensureCapacityNum];
    }


    public void run() {

    }

    public void add(E e) {
        add(size, e);
    }

    public boolean add(int index, E e) {
        if (index != size) {
            checkIndex(index);
        }

        if(array.length == size) {
            arraySizeExtender();
        }

        if (index == size) {
            System.arraycopy(array, index, array, index+1, size - index);
        }

        array[index] = e;
        size++;
        return true;
    }

    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    public boolean set(int index, E t) {
        checkIndex(index);
        array[index] = t;
        return true;
    }

    public E remove(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        E temp = array[index];
        System.arraycopy(array, index+1, array, index, size-index-1);
        array[size-1] = null;
        size--;
        return temp;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }


    // Resizing inner array
    private void arraySizeExtender() {
        E[] temp = array.clone();
        Object[] obj = new Object[array.length*3/2+1];
        array = (E[]) obj;
        System.arraycopy(temp, 0, array, 0, temp.length);
    }

    // Checks if out of bounds
    private void checkIndex(int index) {
        if(size == 0 || index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < size; i++) {
            build.append(array[i] + " ");
        }
        return build.toString();
    }

    public int parallelIndexOf(E e) {
        int result = -1;
        return result;
    }



    class parallelThread extends Thread {

    }










    public Object[] getArray() {
        return array;
    }
    public void setArray(Object[] myArray) {
        this.array = array;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
