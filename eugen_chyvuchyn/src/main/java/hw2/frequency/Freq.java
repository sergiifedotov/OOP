package hw2.frequency;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sergey Tsimbalyuk
 * on 26.02.15 // 0:41
 */
public class Freq {
    String string;

    public Freq() {
        string = "";
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String setTextFromConsole() {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            string = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return string;
    }


    public String setTextFromFile(String fileName) {

        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            String line;
            while ((line = bf.readLine()) != null) {
                string += line + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return string;
    }


    public String randomTextGen(int textLength) {
        Random rm = new Random();
        for (int i = 0; i < textLength; i++) {
            int symbol = 32 + (int) (rm.nextDouble() * 100);

            string += (char) symbol;
        }
        return string;
    }


    private HashMap<String, Integer> createHashMap() {
        String[] arrayString = string.split("[ .:,!?;\"()-]");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arrayString.length; i++) {
            if (hashMap.containsKey(arrayString[i])) {
                hashMap.put(arrayString[i], hashMap.get(arrayString[i]) + 1);
            } else {
                hashMap.put(arrayString[i], 1);
            }
        }
        return hashMap;
    }


    private TreeMap<String, Integer> inTreeMap(HashMap<String, Integer> hashMap) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry :
                hashMap.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }
        return treeMap;
    }

    public Set<String> getWordsByFrequency(int frequency) {
        Set<String> set = new TreeSet<>();
        TreeMap<String, Integer> treeMap = inTreeMap(createHashMap());
        set.addAll(treeMap.entrySet().stream().filter(entry -> entry.getValue() == frequency).map(Map.Entry<String, Integer>::getKey).collect(Collectors.toList()));
        return set;
    }


    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> set = new TreeSet<>();
        TreeMap<String, Integer> treeMap = inTreeMap(createHashMap());
        set.addAll(treeMap.entrySet().stream().filter(entry -> entry.getValue() < frequency).map(Map.Entry<String, Integer>::getKey).collect(Collectors.toList()));
        return set;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<String> set = new TreeSet<>();
        TreeMap<String, Integer> treeMap = inTreeMap(createHashMap());
        set.addAll(treeMap.entrySet().stream().filter(entry -> entry.getValue() > frequency).map(Map.Entry<String, Integer>::getKey).collect(Collectors.toList()));
        return set;
    }

    public void printAcs() {
        TreeMap<String, Integer> treeMap = inTreeMap(createHashMap());
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }
    }

    public void printSet(Set<String> set) {
        for (String s : set) {
            System.out.println(s + " ");
        }
    }

    public void printDesc() {
        Comparator cmp = Collections.reverseOrder();
        List<String> list = new ArrayList<>();
        TreeMap<String, Integer> treeMap = inTreeMap(createHashMap());
        list.addAll(treeMap.entrySet().stream().map(entry -> entry.getValue() + " => " + entry.getKey()).collect(Collectors.toList()));
        Collections.sort(list, cmp);
        list.forEach(System.out::println);
    }

}

class FreqTest {

}