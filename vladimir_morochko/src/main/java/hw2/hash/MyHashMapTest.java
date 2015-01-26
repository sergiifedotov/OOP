package hw2.hash;

import java.util.Iterator;

/**
 * Created by vladimir on 23.01.2015.
 */
public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        boolean isPut;
        isPut = myHashMap.put(1, new User("111", "222"));
        System.out.println(isPut);
        System.out.println(myHashMap);
        isPut = myHashMap.put(3, new User("333", "444"));
        System.out.println(isPut);
        System.out.println(myHashMap);
        isPut = myHashMap.put(100, new User("555", "666"));
        System.out.println(isPut);
        System.out.println(myHashMap);

        boolean isRemoved;
        isRemoved = myHashMap.remove(3);
        System.out.println(isRemoved);
        isRemoved = myHashMap.remove(3);
        System.out.println(isRemoved);
        System.out.println(myHashMap);

        Iterator<User> iterator = myHashMap.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
