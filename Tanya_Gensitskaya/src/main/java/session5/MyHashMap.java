package session5;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.01.15
 */
public class MyHashMap {
    private List<Map.Entry<Integer, session5.User>>[] buckets;

    public MyHashMap() {
        buckets = new List[30];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean put(Integer key, session5.User user) {
        int hashCode = key;
        int index = hashCode % buckets.length;
        List<Map.Entry<Integer, session5.User>> list = buckets[index];
        boolean isContains = contains(key, user);
/*
        if (!isContains) {
            for () {

            }
            return list.add(user);
        }
*/
        return true;
    }

    private boolean contains(Integer key, session5.User user) {
        return false;
    }

/*
    public User get(Integer key) {
        boolean isContains = false;
        for (List<Map.Entry<Integer, User>> bucket : buckets) {
            for () {
                if (isContains) {
                    return bucket.get(i).getValue();
                }
            }
//            isContains =  bucket.contains(user);
        }
        return false;
    }
*/

}
