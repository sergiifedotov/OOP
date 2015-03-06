package hw2.hash;

import java.util.Iterator;

/**
 * Created by vladimir on 23.01.2015.
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        boolean isPut;
        isPut = hashMap.put(1, new User("111", "222"));
        System.out.println(isPut);
        System.out.println(hashMap);
        isPut = hashMap.put(3, new User("333", "444"));
        System.out.println(isPut);
        System.out.println(hashMap);
        isPut = hashMap.put(100, new User("555", "666"));
        System.out.println(isPut);
        System.out.println(hashMap);

        boolean isRemoved;
        isRemoved = hashMap.remove(3);
        System.out.println(isRemoved);
        isRemoved = hashMap.remove(3);
        System.out.println(isRemoved);
        System.out.println(hashMap);

        Iterator<User> iterator = hashMap.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
