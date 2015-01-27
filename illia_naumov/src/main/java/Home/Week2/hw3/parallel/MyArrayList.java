package Home.Week2.hw3.parallel;

import java.util.ArrayList;

/**
 * Created by illia_naumov on 26.01.2015.
 *
 * Реализовать в классе MyArrayList метод
 public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 В тестах проверить поиск:
 - существующего элемента
 - не существующего элемента
 - не существующего элемента в пустом массиве
 - не существующего элемента в массиве с одним элементом
 - существующего элемента в массиве с одним элементом
 - элемента со значением null

 Класс задания:
 hw3.parallel.MyArrayList

 Класс теста:
 hw3.parallel.MyArrayListTest
 */
public class MyArrayList<E> {
    public static void main(String[] args) throws InterruptedException {
        MyArrayList<Integer> listik = new MyArrayList<>();
        listik.add(1);
        listik.add(2);
        listik.add(3);
        listik.add(4);
        listik.add(5);
        listik.add(6);
        listik.add(7);
        listik.add(8);
        listik.add(9);
        listik.add(10);
        listik.add(11);
        listik.add(12);
        listik.add(13);
        System.out.println(listik.parallelIndexOf(22));
    }
    ArrayList<E> list;
    public int keyRight;
    public int keyLeft;
    public boolean isFound = false;
    public int searchingElement = -1;


    public MyArrayList(){
        list = new ArrayList<E>();
    }

    public void add(E e){
        list.add(e);
    }
    public void setElement(Integer e){
        searchingElement = e;
    }
    public int parallelIndexOf(E e) throws InterruptedException {
        LeftSearch ls = new LeftSearch(e);
        RightSearch rs = new RightSearch(e);
        ls.start();
        rs.start();
        ls.join();
        rs.join();
        //Thread.sleep(1000);
        if(isFound = true){
            return searchingElement;
        } else{
            return -1;
        }

    }
    class LeftSearch extends Thread{
        E e;
        public LeftSearch(E e){
            this.e = e;
        }
        @Override
        public void  run(){
            keyLeft = 0;
            for(int i = keyLeft; i < list.size()-1; i++){
                keyLeft++;
                if(keyLeft == keyRight){
                    Thread.interrupted();
                }
                if(list.get(i).equals(e)){
                    setElement(i);
                    isFound = true;
                    Thread.interrupted();
                }
            }
        }
    }

    class RightSearch extends Thread{
        E e;
        public RightSearch(E e){
            this.e = e;
        }
        @Override
        public  void run(){
            keyRight = list.size()-1;
            for(int i = keyRight; i > 0; i-- ){
                keyRight--;
                if(keyLeft == keyRight){
                    Thread.interrupted();
                }
                if(list.get(i).equals(e)){
                    searchingElement = i;
                    isFound = true;
                    Thread.interrupted();
                }
            }
        }
    }
}
