package hw4.parallel;

import java.lang.reflect.Array;

/**
 Created by stan on 06.02.15.
 *
 * Реализовать в классе MyArrayList  метод
 * public int parallelIndexOf(E e), выполняющий линейный
 * многопоточный поиск в списке.
 *
 * Примечание: в списке может быть несколько подходящих элементов.
 * Поиск должен останавливаться при первом совпадении.
 *
 * В тестах проверить поиск:
 * - существующего элемента
 * - несуществующего элемента
 * - несуществующего элемента в пустом массиве
 * - несуществующего элемента в массиве с одним элементом
 * - существующего элемента в массиве с одним элементом
 * - элемента со значением null
 *
 * Класс задания:
 * hw3.parallel.MyArrayList
 *
 * Класс теста:
 * hw3.parallel.MyArrayListTest
 */

public class MyArrayList<Ecspantion> {
    private Ecspantion[] myArray;
    private final int threadCount = 4;
    private SearchThread[] threadPool;
    private int searchResult;
    public MyArrayList(Ecspantion[] myArray) {
        this.myArray = myArray;
    }
    public MyArrayList() {
        myArray = (Ecspantion[]) new Object[0];
    }

    public void add(Ecspantion e) {
        @SuppressWarnings("unchecked")
        Ecspantion[] myNewArray = (Ecspantion[]) new Object[myArray.length + 1];
        System.arraycopy(myArray, 0, myNewArray, 0, myArray.length);
        myNewArray[myArray.length] = e;
        myArray = myNewArray;
    }

    public Ecspantion get(int index) {
        return myArray[index];
    }

    public boolean set(int index, Ecspantion e) {
        if (index >= 0 && index < myArray.length) {
            myArray[index] = e;
            return true;
        }
        return false;
    }

    public boolean add(int index, Ecspantion e) {
        if (index >= 0 && index < myArray.length) {
            @SuppressWarnings("unchecked")
            Ecspantion[] myNewArray = (Ecspantion[]) new Object[myArray.length + 1];
            System.arraycopy(myArray, 0, myNewArray, 0, index);
            myNewArray[index] = e;

            System.arraycopy(myArray, index, myNewArray, index + 1, myArray.length - index);
            myArray = myNewArray;
            return true;
        }
        return false;
    }

    public int size() {
        return myArray.length;
    }

    public int indexOf(Ecspantion e) {
        for (int i = 0; i < myArray.length; i++) {
            if ((e == null && myArray[i] == null) ||
                    myArray[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public Ecspantion remove(int index) {
        Ecspantion answer = null;
        if (index >= 0 && index < myArray.length) {
            answer = myArray[index];
            @SuppressWarnings("unchecked")
            Ecspantion[] myNewArray = (Ecspantion[]) new Object[myArray.length - 1];
            System.arraycopy(myArray, 0, myNewArray, 0, index - 1);
            System.arraycopy(myArray, index + 1, myNewArray, index, myArray.length - (index + 1));
            myArray = myNewArray;
        }
        return answer;
    }

    @Override
    public String toString() {
        String outString = "[ ";
        for (Object current : myArray) {
            outString += (current + " ");
        }
        outString += "]";
        return outString;
    }

    @SuppressWarnings("unchecked")
    public int parallelIndexOf(Ecspantion e) {
        searchResult = -1;
        threadPool = (SearchThread[]) Array.newInstance(SearchThread.class, threadCount);
        for (int i = 0; i < threadCount; i++) {
            int startIndex = myArray.length / threadCount * i;
            int endIndex = myArray.length / threadCount * (i + 1);
            if (endIndex >= myArray.length) {
                endIndex = myArray.length - 1;
            }
            threadPool[i] = new SearchThread(e, myArray, startIndex, endIndex);
        }

        for (SearchThread searchThread : threadPool) {
            searchThread.start();
        }

        for (SearchThread searchThread : threadPool) {
            searchThread.join();
        }

        return searchResult;
    }

    private void interruptAllThreads() {
        for (SearchThread searchThread : threadPool) {
            searchThread.interrupt();
        }
    }

    private class SearchThread implements Runnable {
        private Thread thread;
        Ecspantion[] searchArray;
        int startIndex;
        int endIndex;
        Ecspantion searchValue;

        public SearchThread() {
            thread = new Thread(this);
        }

        public SearchThread(Ecspantion searchValue, Ecspantion[] searchArray, int startIndex, int endIndex) {
            this();
            this.searchValue = searchValue;
            this.searchArray = searchArray;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public void start() {
            thread.start();
        }

        public void join() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void interrupt() {
            thread.interrupt();
        }

        @Override
        public void run() {
            for (int i = startIndex; i <= endIndex; i++) {
                if (thread.isInterrupted()) {
                    break;
                }
                if ((searchValue == null && searchArray[i] == null) ||
                        searchArray[i].equals(searchValue)) {
                    searchResult = i;
                    interruptAllThreads();
                    break;
                }
            }
        }
    }


}
