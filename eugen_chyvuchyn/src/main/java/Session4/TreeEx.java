package Session4;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Chuvychin on 18.01.2015.
 */
public class TreeEx {
    public static void main(String[]args){
        Map<Integer,String> map = new TreeMap<>((e1,e2)->e1-e2);
        // new Comporator()
        //@Override
        // public int compare(Integer o1, Integer 02){
        // return 02-01;
        //}
        map.put(1,"1");
        map.put(3,"3");
        map.put(2,"2");
        System.out.println(map);

        Map<User,Object> users = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u2.getLogin().compareTo(u1.getLogin());
            }
        });


        users.put(new User("a1c","1"),null);
        users.put(new User("bdufb","1"),null);
        users.put(new User("a2f","1"),null);
        users.put(new User("a3eihg","1"),null);

        System.out.println(users);

       users = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getLogin().compareTo(u2.getLogin());
            }
        });


        users.put(new User("a1c","1"),null);
        users.put(new User("bdufb","1"),null);
        users.put(new User("a2f","1"),null);
        users.put(new User("a3eihg","1"),null);

        System.out.println(users);

    }
}
