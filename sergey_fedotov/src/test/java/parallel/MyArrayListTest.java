package parallel;

import hw4.parallel.MyArrayList;

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

    public static void testSearchExisting(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(2);
        myArrayList.add(9);
        myArrayList.add(0);
        myArrayList.add(7);
        myArrayList.add(1);

        String nameTest = "Test1. SearchExisting: ";

        if(myArrayList.parallelIndexOf(1)==4){
            System.out.println(nameTest.concat("ok"));
        }else{
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void testSearchNonexistent(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(2);
        myArrayList.add(9);
        myArrayList.add(0);
        myArrayList.add(7);
        myArrayList.add(1);

        String nameTest = "Test2. SearchNonexistent: ";

        if(myArrayList.parallelIndexOf(4)==-1){
            System.out.println(nameTest.concat("ok"));
        }else{
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void testSearchNonexistentInEmptyArray(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        String nameTest = "Test3. SearchNonexistentInEmptyArray: ";

        if(myArrayList.parallelIndexOf(4)==-1){
            System.out.println(nameTest.concat("ok"));
        }else{
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void testSearchNonexistentInArrayOneElement(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(56);
        String nameTest = "Test4. SearchNonexistentInArrayOneElement: ";

        if(myArrayList.parallelIndexOf(4)==-1){
            System.out.println(nameTest.concat("ok"));
        }else{
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void testSearchExistingInArrayOneElement(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(56);
        String nameTest = "Test5. SearchExistingInArrayOneElement: ";

        if(myArrayList.parallelIndexOf(56)==0){
            System.out.println(nameTest.concat("ok"));
        }else{
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void testSearchElementNull(){

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(2);
        myArrayList.add(9);
        myArrayList.add(0);
        myArrayList.add(null);
        myArrayList.add(1);

        String nameTest = "Test6. SearchElementNull: ";

        if(myArrayList.parallelIndexOf(null)==3){
            System.out.println(nameTest.concat("ok"));
        }else{
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void main(String[] args) {

        testSearchExisting();
        testSearchNonexistent();
        testSearchNonexistentInEmptyArray();
        testSearchNonexistentInArrayOneElement();
        testSearchExistingInArrayOneElement();
        testSearchElementNull();

    }

}
