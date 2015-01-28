package hw2.frequency;

import java.io.FileReader;
import java.util.*;

/**
 * Created by warit on 23.01.2015.
 */
public class Freq {

    private String text;

    public Freq() {
        text = "";
    }

    public String getTex() {
        return text;
    }

    private void setText(String text){
        this.text = text;
    }

    public String setTextFromConsole(String text){

        setText(text);

        return text;
    }

    public String setTextFromConsole(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Set line:");
        String setText = scan.nextLine();

        setText(setText);

        return setText;
    }

    public String setTextFromFile(String fileName)  throws Exception{

        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);

        String setText="";

        while (scan.hasNextLine())
            setText.concat("\n").concat(scan.nextLine());

        scan.close();
        fr.close();

        setText(setText);

        return setText;
    }

    public String generateRandomText(int textLength){

        String setText="";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<textLength/2; i++)
        {
            setText = String.valueOf((int) (10*Math.random()));
            sb.append(setText);
            sb.append(" ");
        }
        if (sb.length() > textLength){
            sb = sb.delete(textLength-1,textLength-1);
        }else if(sb.length() < textLength){
            sb.append(" ");
        }
        setText = sb.toString();
        setText(setText);
        return setText;
    }

    private void getWords(TreeMap<String, Integer>  textMap){
        String[] tempVector;
        tempVector = text.split("\\s+");
        for (String elVector : tempVector){
            Integer countWorld = textMap.get(elVector);
            if (countWorld==null) countWorld = 0;
            textMap.put(elVector, countWorld+1);
        }
    }

    public Set<String> getWordsByFrequency(int frequency){
        Set<String> result = new HashSet<>();
        TreeMap<String, Integer>  textMap = new TreeMap<>();
        getWords(textMap);
        if (textMap.containsValue(frequency)){
            for(Map.Entry<String, Integer> el:textMap.entrySet()){
                if (el.getValue()==frequency){
                result.add(el.getKey());}
            }
        }
        return result;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency){
        Set<String> result = new HashSet<>();
        TreeMap<String, Integer>  textMap = new TreeMap<>();
        getWords(textMap);
        for(Map.Entry<String, Integer> el:textMap.entrySet()){
            if (el.getValue()<frequency){
                result.add(el.getKey());}
        }

        return result;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency){
        Set<String> result = new HashSet<>();
        TreeMap<String, Integer>  textMap = new TreeMap<>();
        getWords(textMap);
        for(Map.Entry<String, Integer> el:textMap.entrySet()){
            if (el.getValue()<frequency){
                result.add(el.getKey());}
        }

        return result;
    }

    public void printAcs(){

        /*TreeMap<String, Integer>  textMap = new TreeMap<>(new Comparator<String>() {
            public int compare(String k1, String k2) {
                int compare = textMap.get(k1).compareTo(textMap.get(k2));
                if (compare == 0) return 1;
                else return compare;
            }
        });*/
        TreeMap<String, Integer>  textMap = new TreeMap<>();
        getWords(textMap);
        System.out.println(textMap.toString());
    }

    public void printDesc(){

        /*TreeMap<String, Integer>  textMap = new TreeMap<>(new Comparator<String>() {
            public int compare(String k1, String k2) {
                int compare = textMap.get(k1).compareTo(textMap.get(k2));
                if (compare == 0) return 1;
                else return compare;
            }
        });*/
        TreeMap<String, Integer>  textMap = new TreeMap<>();
        getWords(textMap);
        System.out.println(textMap.toString());
    }

}