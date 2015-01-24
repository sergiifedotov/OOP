package hw2.frequencyWords;

import java.util.*;

public class MapSort {

    public static void main(String[] args) {
        Map<Character, Integer> m = new HashMap<Character, Integer>() {
            {
                put('b', 2);
                put('a', 3);
                put('c', 1);
            }
        };

//        System.out.println(m);
        m = new TreeMap<Character, Integer>(m);
        System.out.println(m);
        Map<Character, Integer> n = new TreeMap<Character, Integer>(new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                return (int) o2 - (int) o1;
            }
        });
        n.putAll(m);
        System.out.println(n);

    }
}
