package main.java.session4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.01.15
 */
public class MapEx {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "0");
        map.put(1, "1");
        map.put(2, "1");
        map.put(3, "2");
        map.put(4, "1");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }
    }
}
