package hw2.frequencyWords;

import java.io.*;
import java.util.*;


/**
 * Написать класс для вычисления частоты слов в тексте с методами:
 * - String setTextFromConsole()
 * - String setTextFromFile(String fileName)
 * - String generateRandomText(int textLength)
 * - Set<String> getWordsByFrequency(int frequencyWords)
 * - Set<String> getWordsByFrequencyLessThan(int frequencyWords)
 * - Set<String> getWordsByFrequencyMoreThan(int frequencyWords)
 * - void printAcs() - вывести все слова + частота по возрастанию частоты
 * - void printDesc() - вывести все слова + частота по убыванию частоты
 * <p/>
 * Класс задания hw2.frequencyWords.Freq
 */
public class Freq {


    public Freq() {
    }

    //добавляет текст с консоли в строку и возвращает строку
    public String setTextFromConsole() {
        String text = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("введите текст:");
            text = br.readLine();
            br.close();
        } catch (IOException ex) {
            System.out.println("Reading error");
        }
        return text;
    }


    //добавляет текст из указанного поимени файла в строку и возвращает строку
    public String setTextFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    //генерирует случайный текст по указанной длинне
    public String generateRandomText(int textLength) {
        char[] chars = "ab cdefgh ijk lmnopqrs tuvwxyz ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < textLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public HashMap<String, Integer> wordsAndFreq() {
        String strFile = setTextFromFile("Tanya_Gensitskaya/src/main/java/hw2/frequencyWords/hello");
        String[] strArray = strFile.split("\\s+");
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < strArray.length; i++) {
            if (hm.get(strArray[i]) != null) {
                Integer value = hm.get(strArray[i]);
                hm.put(strArray[i], value + 1);
            } else {
                hm.put(strArray[i], new Integer(1));
            }
        }
        return hm;
    }


    //возвращает множество слов, которые встречаются указанное количество раз
    public Set<String> getWordsByFrequency(int frequency) {
        String str = setTextFromFile("Tanya_Gensitskaya/src/main/java/hw2/frequencyWords/hello");
        String[] strN = str.split("\\s+");
        Set<String> set = new HashSet<>();
        int count = 1;
        for (int i = 0; i < strN.length; i++) {
            if (strN[i] == null) {
                continue;
            }
            for (int j = i + 1; j < strN.length; j++) {
                if (strN[i].equals(strN[j])) {
                    strN[j] = null;
                    count++;
                }
            }
            if (count == frequency) {
                set.add(strN[i]);
            }
            count = 1;
        }
        return set;
    }

    //    множество, которое встречается реже
    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> hm = wordsAndFreq();
        for (HashMap.Entry<String, Integer> i : hm.entrySet()) {
            String key = i.getKey();
            Integer value = i.getValue();
            if (value <= frequency) {
                set.add(key);
            }
        }
        return set;
    }


    //множество, которое встречается чаще
    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> hm = wordsAndFreq();
        for (HashMap.Entry<String, Integer> i : hm.entrySet()) {
            String key = i.getKey();
            Integer value = i.getValue();
            if (value >= frequency) {
                set.add(key);
            }
        }
        return set;
    }


    //    вывести все слова + частота по возрастанию частоты
    public void printAcs() {
        Map<String, Integer> map = wordsAndFreq();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
        for (Object aList : list) {
            System.out.println(((Map.Entry<String, Integer>) aList).getKey() + " "
                    + ((Map.Entry<String, Integer>) aList).getValue());
        }
    }


    //вывести все слова + частота по убыванию частоты
    public void printDesc() {
        Map<String, Integer> map = wordsAndFreq();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return -a.getValue() + b.getValue();
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    public void print(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String elem = it.next();
            System.out.println(elem);
        }
    }

    public void print(HashMap<String, Integer> set) {
        for (HashMap.Entry<String, Integer> elem : set.entrySet()) {
            String key = elem.getKey();
            Integer value = elem.getValue();
            System.out.println(key + " " + value);
        }
    }

    public void revertValueAndKey(HashMap<String, Integer> set) {
        for (HashMap.Entry<String, Integer> i : set.entrySet()) {
            String key = i.getKey();
            Integer value = i.getValue();
            System.out.println(key + " " + value);
        }
    }

}
