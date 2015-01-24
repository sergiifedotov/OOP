package hw2.hash;

/**
 * Created by Yaroslav_Syrota on 20.01.2015.
 */

/*
Написать собственную реализацию "Хэш карты".
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

    import java.util.AbstractMap;
    import java.util.LinkedList;
    import java.util.AbstractMap;
    import java.util.Map;

public class HashMap<Integer, User> {
    private int sizeUsers;
    private int indexSize;
    // private ArrayList<User> usersList;
    private LinkedList<User>[] usersMass = new LinkedList[10];

    public HashMap(){}



    public boolean put(int key, User elm) {
        boolean b = false;
        return b;
    }

    public User get(int key) {
        User temp = null;
        return temp;
    }

    public boolean remove(int key) {
        boolean b = false;
        return b;
    }


    public int size() {
        return sizeUsers;
    }
}
