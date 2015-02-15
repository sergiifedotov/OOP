package hw3.parallel;

/**
 * Created by user on 28.01.2015.
 */
public class MyArrayListTest {
    MyArrayList<Integer> listik;
    public static void main(String[] args) throws InterruptedException {
        MyArrayListTest test = new MyArrayListTest();
        test.Test1();
        test.Test2();
        test.Test3();
        test.Test4();
        test.Test5();
        test.Test6();



    }
    public void createList(){
        listik = new MyArrayList<>();
        for(int i = 0; i < 20; i++){
            listik.add(i);
        }
    }
    public void createListWithOneElement(){
        listik = new MyArrayList<>();
        listik.add(1);
    }
    public void Test1() throws InterruptedException {
        createList();
        int index = listik.parallelIndexOf(1);
        if(index == 1){
            System.out.println("Test1 OK");
        } else{
            System.out.println("Test1 failed");
        }
        System.out.println(index);

    }
    public void Test2()throws InterruptedException{
        createList();
        int index = listik.parallelIndexOf(100);
        if(index == -1){
            System.out.println("Test2 OK");
        } else{
            System.out.println("Test2 failed");
        }

    }

    public void Test3() throws InterruptedException{
        listik = new MyArrayList<>();
        int index = listik.parallelIndexOf(666);

        if(index == -1){
            System.out.println("Test3 OK");
        } else{
            System.out.println("Test3 failed");
        }

    }
    public void Test4()throws InterruptedException{
        createListWithOneElement();
        int index = listik.parallelIndexOf(1);
        if(index == 0){
            System.out.println("Test4 OK");
        } else{
            System.out.println("Test4 failed");
        }
        System.out.println(index);
    }
    public void Test5()throws InterruptedException{
        createListWithOneElement();
        int index = listik.parallelIndexOf(666);
        if(index == -1){
            System.out.println("Test5 OK");
        } else{
            System.out.println("Test5 failed");
        }
    }
    public void Test6()throws InterruptedException{
        createList();
        int index = listik.parallelIndexOf(null);
        if(index == -1){
            System.out.println("Test6 OK");
        } else{
            System.out.println("Test6 failed");
        }
    }

}
