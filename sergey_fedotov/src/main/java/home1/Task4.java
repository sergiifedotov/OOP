package home1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by warit on 13.01.2015.
 */
public class Task4 {

    public static void testArrayListIndexSize_2(int size){
        long timeStart;
        long timeEnd;

        ArrayList<Integer> listTest = new ArrayList<Integer>();
        double pastIndex = 0;

        timeStart = System.nanoTime();
        for(int sizeListTest = 0; sizeListTest<size; sizeListTest++){
            listTest.add(sizeListTest,(int)pastIndex);
        }
        timeEnd = System.nanoTime();

        System.out.print(timeEnd - timeStart);
    }

    public static void testArrayListIndexSize_0(int size){
        long timeStart;
        long timeEnd;

        ArrayList<Integer> listTest = new ArrayList<Integer>();

        timeStart = System.nanoTime();
        for(int sizeListTest = 0; sizeListTest<size; sizeListTest++){
            listTest.add(sizeListTest,0);
        }
        timeEnd = System.nanoTime();

        System.out.print(timeEnd - timeStart);
    }

    public static void testArrayListIndexSize(int size){
        long timeStart;
        long timeEnd;

        ArrayList<Integer> listTest = new ArrayList<Integer>();

        timeStart = System.nanoTime();
        for(int sizeListTest = 0; sizeListTest<size; sizeListTest++){
            listTest.add(sizeListTest,sizeListTest);
        }
        timeEnd = System.nanoTime();

        System.out.print(timeEnd - timeStart);
    }

    public static void testLinkedListIndexSize_2(int size){
        long timeStart;
        long timeEnd;

        LinkedList<Integer> listTest = new LinkedList<Integer>();
        double pastIndex = 0;

        timeStart = System.nanoTime();
        for(int sizeListTest = 0; sizeListTest<size; sizeListTest++){
            listTest.add(sizeListTest,(int)pastIndex);
        }
        timeEnd = System.nanoTime();

        System.out.print(timeEnd - timeStart);
    }

    public static void testLinkedListIndexSize_0(int size){
        long timeStart;
        long timeEnd;

        LinkedList<Integer> listTest = new LinkedList<Integer>();

        timeStart = System.nanoTime();
        for(int sizeListTest = 0; sizeListTest<size; sizeListTest++){
            listTest.add(sizeListTest,0);
        }
        timeEnd = System.nanoTime();

        System.out.print(timeEnd - timeStart);
    }

    public static void testLinkedListIndexSize(int size){
        long timeStart;
        long timeEnd;

        LinkedList<Integer> listTest = new LinkedList<Integer>();

        timeStart = System.nanoTime();
        for(int sizeListTest = 0; sizeListTest<size; sizeListTest++){
            listTest.add(sizeListTest,sizeListTest);
        }
        timeEnd = System.nanoTime();

        System.out.print(timeEnd - timeStart);
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите размер коллекции");
        int size = scan.nextInt();

        if (size == 0){
            size = 10000;
        }

        System.out.println("Тестирование по типу Integer");
        System.out.println("Index               ArrayList               LinkedList");
        System.out.print("size/2");
        System.out.print("              ");
        testArrayListIndexSize_2(size);
        System.out.print("              ");
        testLinkedListIndexSize_2(size);
        System.out.println();

        System.out.print("0     ");
        System.out.print("              ");
        testArrayListIndexSize_0(size);
        System.out.print("              ");
        testLinkedListIndexSize_0(size);
        System.out.println();

        System.out.print("size-1");
        System.out.print("              ");
        testArrayListIndexSize(size);
        System.out.print("              ");
        testLinkedListIndexSize(size);
        System.out.println();
    }

}
