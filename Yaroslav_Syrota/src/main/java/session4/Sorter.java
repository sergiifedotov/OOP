package session4;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

/**
 * Created by Admin on 18.01.2015.
 */
public class Sorter {
    static TreeMap<String, String> users = new TreeMap<String, String>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    });

    public static void main(String[] args) {
        users.put("tom", "layka");
        users.put("aka", "soyer");
        users.put("nik", "kave");
        Iterator<Map.Entry<String, String>> iterator = users.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey());
        }
    }

}
