package hw2.hash;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *Написать собственную реализацию "Хэш карты".
 Карта должна хранить объекты класса "Пользователь" из первого задания.

 Реализовать методы:

 1. boolean put(int key, User elem)
 2. User get(int key)
 3. int size()
 4. boolean remove(int key)
 5. Iterator<User> iterator()

 */
public class HashMap {
    private List<Map.Entry<Integer, User>>[] buckets;

    public HashMap() {
        buckets = new List[30];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
            buckets[i].add(new AbstractMap.SimpleEntry<Integer, User>(1,null));
        }
    }

    public boolean put(int key, User elem) {
        int hashCode = key;
        int index = hashCode % buckets.length;
        List<Map.Entry<Integer, User>> list = buckets[index];
        boolean isContains = contains(key, elem);

        return true;
    }

    private boolean contains(Integer key, User user) {
        return false;
    }


    public User get(Integer key) {
        boolean isContains = false;
        for (List<Map.Entry<Integer, User>> bucket : buckets) {
            for (int i=0;i<bucket.size();i++) {
                if (isContains) {
                    return bucket.get(i).getValue();
                }
            }
            //isContains =  bucket.contains(user);
        }
        return null;
    }


}
