package session4;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.01.15
 */
public class TreeEx {
    public static void main(String[] args) {
        Map<User, Object> map = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getLogin().compareTo(o2.getLogin());
            }
        });
        map.put(new User("1", "1"), null);
        map.put(new User("2", "1"), null);
        map.put(new User("3", "1"), null);
        map.put(new User("4", "1"), null);

        System.out.println(map);

        map = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return 0 - o1.getLogin().compareTo(o2.getLogin());
            }
        });
        map.put(new User("1", "1"), null);
        map.put(new User("2", "1"), null);
        map.put(new User("3", "1"), null);
        map.put(new User("4", "1"), null);
        System.out.println(map);
    }
}
