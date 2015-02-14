package hw3.parallel;

import java.util.ArrayList;


/**
 * Created by Chuvychin on 28.01.2015.
 */
public class MyArrayList <E> {
    public static void main(String[] args) throws InterruptedException {
        MyArrayList<Integer> myList= new MyArrayList<>();

        myList.add(0);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        System.out.println(myList.parallelIndexOf(5));

    }

    private ArrayList<E> array;
    private int sElIndex = -1;
    private int leftkey;
    private int rightkey;



    public MyArrayList (){
        array = new ArrayList<E>();
    }

    public void add(E e){
        array.add(e);
    }

    public int parallelIndexOf(E e) throws InterruptedException {
        if(array.size()==0){
            return getsElIndex();
        }

        LeftRight lr = new LeftRight(e);
        RightLeft rl = new RightLeft(e);
        lr.start();
        rl.start();
        lr.join();
        rl.join();

        return getsElIndex();
    }



    public ArrayList<E> getArray() {
        return array;
    }

    public int getsElIndex() {
        return sElIndex;
    }

    public void setsElIndex(int sElIndex) {
        this.sElIndex = sElIndex;
    }

    class LeftRight extends Thread{
        E e;
        public LeftRight(E e){
            this.e = e;
        }

        @Override
        public void run(){
            leftkey=0;
            for(int i=0; i<array.size();i++){
                if(leftkey==rightkey){
                    Thread.interrupted();
                }
                if(array.get(i).equals(e)==true){
                    setsElIndex(i);
                    Thread.interrupted();
                }
            }
        }
    }

    class RightLeft extends Thread{
        E e;
        public RightLeft (E e){
            this.e = e;
        }

        @Override
        public void run(){
            rightkey = array.size()-1;
            for(int i= rightkey; i>0;i--){
                if(rightkey == leftkey){
                    Thread.interrupted();
                }

                if(array.get(i).equals(e)==true){
                    setsElIndex(i);
                    Thread.interrupted();
                }
            }
        }
    }
}



