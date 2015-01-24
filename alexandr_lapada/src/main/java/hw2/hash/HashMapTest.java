package hw2.hash;

/**
 * Created by sanya on 21.01.2015.
 */
 /*Написать собственную реализацию "Хэш карты".
 Карта должна хранить объекты класса "Пользователь" из первого задания.

 Реализовать методы:

 1. boolean put(int key, User elem)
 2. User get(int key)
 3. int size()
 4. boolean remove(int key)
 5. Iterator<User> iterator()

 Классы задания:
 hw2.hash.HashMap
 hw2.hash.User

 Класс теста hw2.hash.HashMapTest
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        System.out.println(map.size());
        User user1 = new User("sanya","1233456","29.12.88",78,"male");
        User user2 = new User("sasha","1233456","13.12.78",88,"male");
        User user3 = new User("katya","123456","13.12.78",88,"female");

        System.out.println(map.put(user1));
        System.out.println(map.put(user1));
        System.out.println(map.put(user2));
        System.out.println(map.put(user3));

        System.out.println(map.size());

        System.out.println("cont - "+map.contains(user1));
        System.out.println("cont - "+map.contains(user3));

        map.iterator();

       // map.test();
    }
}
