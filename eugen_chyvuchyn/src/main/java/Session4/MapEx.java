package Session4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Chuvychin on 18.01.2015.
 */
public class MapEx {
    public static void main(String []args){
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"0");
        map.put(2,"2");
        map.put(3,"2");
        map.put(4,"3");
        map.put(5,"1");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();

        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }
    }
}

