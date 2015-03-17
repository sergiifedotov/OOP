package hw2.hash;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Sergey Tsimbalyuk
 * on 26.02.15 // 0:48
 * Написать собственную реализацию "Хэш карты".
 * Карта должна хранить объекты класса "Пользователь" из первого задания.
 * <p/>
 * Реализовать методы:
 * <p/>
 * 1. boolean put(int key, User elem)
 * 2. User get(int key)
 * 3. int size()
 * 4. boolean remove(int key)
 * 5. Iterator<User> iterator()
 * <p/>
 * Классы задания:
 * hw2.hash.HashMap
 * hw2.hash.User
 * <p/>
 * Класс теста hw2.hash.HashMapTest
 */
public class MyHashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<entryPoint>[] basket;
    private int size = 0;

    public MyHashMap() {
        basket = new LinkedList[DEFAULT_CAPACITY];
    }
    public MyHashMap(int customCapacity) {
        basket = new LinkedList[customCapacity];
    }

    public boolean put(int key, User elem){
        int keyHash = new Integer(key).hashCode();
        System.out.println("Key hash: "+keyHash);
        try{
            size = basket[keyHash].size();
            System.out.println("entries[keyHash].size() = "+size);
        }catch (NullPointerException e){
            basket[keyHash] = new LinkedList<>();
            size = 0;
            System.out.println("n = 0");
        }

        for (int i = 0; i < size; i++) {
            if (basket[keyHash].get(i).getKey() == key) {
                basket[keyHash].set(i, new entryPoint(key, elem));
                System.out.println("entries["+keyHash+"].get("+i+").getKey() = "+key);
                return false;
            }
        }
        basket[keyHash].add(new entryPoint(key, elem));
        size++;
        System.out.println("entries["+keyHash+"].add(new Entry("+key+"))");
        return true;
    }

    public User get(int key){

        int keyHash = new Integer(key).hashCode();

        try{
            size = basket[keyHash].size();
        }catch (NullPointerException e){
            size = 0;
            return null;
        }

        for (int i = 0; i < size; i++) {
            if (basket[keyHash].get(i).getKey()==key) {
                return basket[keyHash].get(i).getVal();
            }
        }

        return null;
    }

    public int size(){
        return basket.length;
    }

    public boolean remove(int key){
        int keyHash = new Integer(key).hashCode();
        try{
            size = basket[keyHash].size();
        }catch (NullPointerException e){
            size = 0;
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (basket[keyHash].get(i).getKey()==key) {
                basket[keyHash].remove(i);
                return true;
            }
        }

        return false;
    }

    public Iterator<User> iterator(){
        LinkedList<User> users = new LinkedList<>();
        for(int i=0;i< basket.length;i++ ){
            for(int chainIndex = 0; chainIndex<size; chainIndex++) {
                users.add(basket[i].get(chainIndex).getVal());
            }
        }
        return users.iterator();
    }

    class entryPoint {
        int key;
        User val;

        public entryPoint(int key, User val){
            this.key = key;
            this.val = val;
        }
        public int getKey() {
            return key;
        }
        public User getVal() {
            return val;
        }
    }
}

class MyHashMapTest {

}