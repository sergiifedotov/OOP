package main.java.hw2.frequency;

import java.io.*;
import java.util.*;

/**
 * Created by illia_naumov on 21.01.2015.
 *
 * Написать класс для вычисления частоты слов в тексте с методами:
 - String setTextFromConsole()
 - String setTextFromFile(String fileName)
 - String generateRandomText(int textLength)
 - Set<String> getWordsByFrequency(int frequency)
 - Set<String> getWordsByFrequencyLessThan(int frequency)
 - Set<String> getWordsByFrequencyMoreThan(int frequency)
 - void printAcs() - вывести все слова + частота по возрастанию частоты
 - void printDesc() - вывести все слова + частота по убыванию частоты

 Класс задания hw2.frequency.Freq
 */
public class Freq {
    String text;
    public static void main(String[] args) throws IOException {
        Freq freq = new Freq();
        freq.setTextFromConsole();
        freq.printAcs();
        freq.printDesc();

    }
    Freq(){

    }
    public String setTextFromConsole() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String txt;
        String text = "";
        do{
            txt = bf.readLine();
            text = text + txt + " ";
        } while(!txt.equals(""));
        this.text = text;
        return text;
    }

    public String setTextFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            this.text = everything;
            return everything;
        } finally {
            br.close();
        }
    }

    public String generateRandomText(int textLength){
        String [] wordArray = {"мама ", "мыла ", "раму "};
        String text = "";
        Random rand = new Random();
        int j = wordArray.length;
        for(int i = 0; i < textLength - 1; i++){
            text = text + wordArray[(int)(Math.random()*j)];
        }
        this.text = text;
        return text;
    }

    public HashMap<String, Integer> setFrequency() {
        String[] wordsInText = text.toLowerCase().split(" ");
        HashMap<String, Integer> friq = new HashMap<String, Integer>();
        for (String i : wordsInText) {
            if (friq.containsKey(i)) {
                friq.put(i, friq.get(i) + 1);
            } else {
                    friq.put(i, 1);
            }

        }
        return friq;
    }

    public Set<String> getWordsByFrequency(int frequency){
        Set<String> list = new HashSet<>();
        HashMap<String, Integer> map  = setFrequency();
        for(HashMap.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue() == frequency){
                list.add(entry.getKey());
            }
        }
        return list;
    }
    public Set<String> getWordsByFrequencyLessThan(int frequency){
        Set<String> list = new HashSet<>();
        HashMap<String, Integer> map  = setFrequency();
        for(HashMap.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue() < frequency){
                list.add(entry.getKey());
            }
        }
        return list;
    }
    public Set<String> getWordsByFrequencyMoreThan(int frequency){
        Set<String> list = new HashSet<>();
        HashMap<String, Integer> map  = setFrequency();
        for(HashMap.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue() > frequency){
                list.add(entry.getKey());
            }
        }
        return list;
    }
    public void printAcs(){
        Map<String, Integer> map = new TreeMap<>((fr1, fr2) -> {
            return fr1.compareTo(fr2);
        });
            map.putAll(setFrequency());
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
    public void printDesc(){
        Map<String, Integer> map = new TreeMap<>((fr1, fr2) -> -fr1.compareTo(fr2));
        map.putAll(setFrequency());
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
    public void print(HashMap<String, Integer> map){
        for(HashMap.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
