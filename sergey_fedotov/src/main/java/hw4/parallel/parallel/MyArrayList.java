package hw4.parallel.parallel;

import java.util.ArrayList;

/**
 * Реализовать в классе MyArrayList метод
 public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 */
public class MyArrayList<E> extends ArrayList<E> {

    private static final int MAX_NUMBER_STREAMS = 50;

    private Integer elementIndex;
    private int finishedStreams;

    public int parallelIndexOf(E e){

        int sizeArray = size();

        if (sizeArray==0){
            return -1;
        }

        int numberStreams = MAX_NUMBER_STREAMS;
        int step = (int)size()/numberStreams;
        while (step<1){
            numberStreams--;
            step = (int)size()/numberStreams;
        }
        int selectedNumberStreams = numberStreams;
        int indexStart;
        for (indexStart=0;numberStreams>1&&getElementIndex()==null;indexStart+=step){
            MyArrayListEx<E> myArrayListEx = new MyArrayListEx<E>(this,e,indexStart,indexStart+step-1);
            myArrayListEx.start();
            numberStreams--;
        }

        if (getElementIndex()==null){
            MyArrayListEx<E> myArrayListEx = new MyArrayListEx<E>(this,e,indexStart,sizeArray-1);
            myArrayListEx.start();
        }

        while (true) {
			if(selectedNumberStreams==finishedStreams||getElementIndex()!=null){

                if (elementIndex==null){
                    return -1;
                }else{
                    return elementIndex;
                }

            }
		}


    }

    public void setElementIndex(int index){
        //System.out.println(Thread.currentThread().getName().concat(":find"));
        elementIndex = index;
    }

    public void setFinishedStreams(){
        finishedStreams+=1;
    }

    public Integer getElementIndex(){
        return elementIndex;
    }

}

class MyArrayListEx<E> extends Thread {

    private MyArrayList<E> instance;
    private int indexStart;
    private int IndexEnd;
    private E e;

    public MyArrayListEx(MyArrayList<E> myArrayList,E e,int indexStart,int indexEnd){
        this.instance = myArrayList;
        this.indexStart = indexStart;
        this.IndexEnd = indexEnd;
        this.e = e;
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName().concat(":started"));
        int i;
        if (e == null) {
            for (i = indexStart; instance.getElementIndex()==null&&i <= IndexEnd; i++){
                if (instance.get(i)==null){
                    instance.setElementIndex(i);
                    break;
                }}
        } else {
            for (i = indexStart; instance.getElementIndex()==null&&i <= IndexEnd; i++){
                if (e.equals(instance.get(i))){
                    instance.setElementIndex(i);
                    break;
                }}
        }
        //System.out.println(Thread.currentThread().getName().concat(":IndexEnd").concat(" "+IndexEnd).concat(" i: ").concat(""+i));
        instance.setFinishedStreams();
    }

}