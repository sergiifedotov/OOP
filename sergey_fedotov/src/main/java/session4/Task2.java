package session4;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by warit on 17.01.2015.
 */
public class Task2 {

    public static void main(String[] args) {

        TreeMap<User,String> map = new TreeMap<>();

        map.put(new User("Иван", "1"), "");
        map.put(new User("Петр", "2"), "");
        map.put(new User("Света", "3"), "");
        map.put(new User("Катя", "4"), "");

        System.out.println(map);

    }

}
class ComparatorByName implements Comparator<User>{

    @Override
    public int compare(User o1, User o2) {

        return o1.getLogin().compareToIgnoreCase(o2.getLogin());
    }

}