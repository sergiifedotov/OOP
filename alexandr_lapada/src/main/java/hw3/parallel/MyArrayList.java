package hw3.parallel;
import java.io.IOException;
import java.util.*;
/**
 * Created by sanya on 25.01.2015.
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
////////////////////////////////////////////////////////////////
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
///////////////////////////////////////////////////////////////////
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
/////////////////////////////////////////////////////////////////////
        thread1.start();
        thread2.start();
        while(thread1.isAlive() || thread2.isAlive()) {

        }
        return index;
    }
}



