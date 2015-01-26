package hw2.hash;

import java.util.*;

/**
 * Created by vladimir on 23.01.2015.
 *
 * Написать собственную реализацию "Хэш карты".
 * Карта должна хранить объекты класса "Пользователь" из первого задания.
 *
 * Реализовать методы:
 *
 * 1. boolean put(int key, User elem)
 * 2. User get(int key)
 * 3. int size()
 * 4. boolean remove(int key)
 * 5. Iterator<User> iterator()
 *
 * Классы задания:
 * hw2.hash.HashMap
 * hw2.hash.User
 *
 * Класс теста hw2.hash.HashMapTest
 */
public class MyHashMap implements Iterable {
    private List<Entry>[] entries;
    private int defaultSize = 16;
    private final double loadFactor = 0.75;
    private int currentSize;

    public MyHashMap() {
        currentSize = 0;
        entries = new List[defaultSize];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new LinkedList<>();
            // AbstractMap.SimpleEntry<>
        }
    }

    public boolean put(int key, User user) {
        List<Entry> list = entries[key % entries.length];
        Entry entryToAdd = new Entry(key, user);
        if (!list.contains(entryToAdd)) {
            list.add(entryToAdd);
            currentSize++;
            resizeEntriesListIfNeeded();
            return true;
        }
        return false;
    }

    private void resizeEntriesListIfNeeded() {
        if (currentSize > (int) defaultSize * loadFactor) {
            defaultSize *= 2;
//            System.out.println("resizing to " + defaultSize);
            List<Entry>[] newEntries = new List[defaultSize];
            for (int i = 0; i < newEntries.length; i++) {
                newEntries[i] = new LinkedList<>();
            }

            int currentEntryIndex = 0;
            int entriesIndex = 0;
            int listIndex = 0;

            while (currentEntryIndex < currentSize) {
                if (listIndex >= entries[entriesIndex].size()) {
                    entriesIndex++;
                    listIndex = 0;
                } else {
                    List<Entry> list = newEntries[entries[entriesIndex].get(listIndex).getKey() % newEntries.length];
                    Entry entryToAdd = new Entry(entries[entriesIndex].get(listIndex).getKey(),
                            entries[entriesIndex].get(listIndex).getUser());
                    list.add(entryToAdd);
                    currentEntryIndex++;
                    listIndex++;
                }
            }
            entries = newEntries;
        }
    }

    public User get(int key) {
        List<Entry> list = entries[key % entries.length];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return list.get(i).getUser();
            }
        }
        return null;
    }

    public int size() {
        return currentSize;
    }

    public boolean remove(int key) {
        List<Entry> list = entries[key % entries.length];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                list.remove(i);
                currentSize--;
                return true;
            }
        }
        return false;
    }

    public Iterator<User> iterator() {
        return new Iterator<User>() {
            int currentEntryIndex = 0;
            int entriesIndex = 0;
            int listIndex = 0;

            @Override
            public boolean hasNext() {
                return currentEntryIndex < currentSize;
            }

            @Override
            public User next() {
                while (hasNext()) {
                    if (listIndex >= entries[entriesIndex].size()) {
                        entriesIndex++;
                        listIndex = 0;
                    } else {
                        currentEntryIndex++;
                        return entries[entriesIndex].get(listIndex++).getUser();
                    }
                }
                return null;
            }
        };
    }

    @Override
    public String toString() {
        String stringToReturn = new String();
        for (List<Entry> list : entries) {
            stringToReturn += list;
        }
        return stringToReturn;
    }


}
