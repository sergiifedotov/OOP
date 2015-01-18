package home1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by warit on 13.01.2015.
 */
public class Task5 {

    public static int getTestSize(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите размер коллекции");
        int size = scan.nextInt();

        if (size == 0){
            size = 10000;
        }

        return size;
    }

    public static void fillVectorIndexSizeDiv2(int[] vectorIndex){

        for(int i=0; i<vectorIndex.length;i++){
            vectorIndex[i] = (int) (0.5*i);
        }

    }

    public static void fillVectorIndex0(int[] vectorIndex){

        for(int i=0; i<vectorIndex.length;i++){
            vectorIndex[i] = 0;
        }

    }

    public static void fillVectorIndexSizeMinus1(int[] vectorIndex){

        for(int i=0; i<vectorIndex.length;i++){
            vectorIndex[i] = i;
        }

    }

    public static void testArrayList(int[] vectorIndex,String typeValue){
        long timeStart;
        long timeEnd;
        if(typeValue.equals("Integer")){
            ArrayList<Integer> listTest = new ArrayList<>();
            int prefix = 0;
            timeStart = System.nanoTime();
            for(int el: vectorIndex){
                listTest.add(el,prefix+el);
            }
            timeEnd = System.nanoTime();
            //System.out.println(listTest.toString());
        }
        else{
            ArrayList<String> listTest = new ArrayList<>();
            String prefix = "";
            timeStart = System.nanoTime();
            for(int el: vectorIndex){
                listTest.add(el,prefix+el);
            }
            timeEnd = System.nanoTime();
            //System.out.println(listTest.toString());
        }

        System.out.print(timeEnd - timeStart);

    }

    public static void testLinkedList(int[] vectorIndex,String typeValue){
        long timeStart;
        long timeEnd;

        if(typeValue.equals("Integer")){
            LinkedList<Integer> listTest = new LinkedList<>();
            int prefix = 0;
            timeStart = System.nanoTime();
            for(int el: vectorIndex){
                listTest.add(el,prefix+el);
            }
            timeEnd = System.nanoTime();
            //System.out.println(listTest.toString());
        }
        else{
            LinkedList<String> listTest = new LinkedList<>();
            String prefix = "";
            timeStart = System.nanoTime();
            for(int el: vectorIndex){
                listTest.add(el,prefix+el);
            }
            timeEnd = System.nanoTime();
            //System.out.println(listTest.toString());
        }

        System.out.print(timeEnd - timeStart);
    }

    public static void main(String[] args) {

        int size = getTestSize();

        int[] vectorIndex = new int[size];

        System.out.println("Тестирование по типу Integer");
        System.out.println("\t           Integer\t               String");
        System.out.println("Index\tArrayList\tLinkedList\tArrayList\tLinkedList");
        System.out.print("size/2");
        fillVectorIndexSizeDiv2(vectorIndex);
        //System.out.println(Arrays.toString(vectorIndex));
        System.out.print("\t");
        testArrayList(vectorIndex,"Integer");
        System.out.print("\t");
        testLinkedList(vectorIndex, "Integer");
        System.out.print("\t");
        testArrayList(vectorIndex,"String");
        System.out.print("\t");
        testLinkedList(vectorIndex, "String");
        System.out.println();

        System.out.print("0     ");
        fillVectorIndex0(vectorIndex);
        //System.out.println(Arrays.toString(vectorIndex));
        System.out.print("\t");
        testArrayList(vectorIndex,"Integer");
        System.out.print("\t");
        testLinkedList(vectorIndex, "Integer");
        System.out.print("\t");
        testArrayList(vectorIndex,"String");
        System.out.print("\t");
        testLinkedList(vectorIndex, "String");
        System.out.println();

        System.out.print("size-1");
        fillVectorIndexSizeMinus1(vectorIndex);
       // System.out.println(Arrays.toString(vectorIndex));
        System.out.print("\t");
        testArrayList(vectorIndex,"Integer");
        System.out.print("\t");
        testLinkedList(vectorIndex, "Integer");
        System.out.print("\t");
        testArrayList(vectorIndex,"String");
        System.out.print("\t");
        testLinkedList(vectorIndex, "String");
        System.out.println();

    }

}
