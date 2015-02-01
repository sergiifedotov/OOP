package hw4.parallel;

import java.util.ArrayList;

/**
 * Created by Tanya on 27.01.2015.
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        for(int i=0; i<10; i++){
            list.add(i);
        }

        for(Integer i: list){
            System.out.print(list.get(i) + " ");
        }



        MyArrayList l = new MyArrayList();
        l.setList(list);
        System.out.println();
        System.out.println(l.parallelIndexOf(10));
    }

}
