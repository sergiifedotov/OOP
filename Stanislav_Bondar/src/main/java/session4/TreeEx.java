//package session4;
//
//import session2.*;
//
//import java.util.Comparator;
//import java.util.Map;
//import java.util.Objects;
//import java.util.TreeMap;
//
///**
// * Created by stan on 18.01.15.
// */
//public class TreeEx {
//    public static void main(String[] args) {
//        Map<User, Objects> map = new TreeMap<>(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getLogin().compareTo(o2.getLogin());
//            }
//        });
//        map.put(new User("1", "1"), null);
//        map.put("2", );
//        map.put(3, "1");
//        map.put(4, "1");
//
//        System.out.println(map);
//    }
//}
