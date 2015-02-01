package hw2.frequency;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by warit on 23.01.2015.
 */
public class Freq1 {

    private HashMap<String, String> textMap;

    public Freq1() {
        textMap = new HashMap<>();
    }

    public HashMap<String, String> getTextMap() {
        return textMap;
    }

    private void setText(String text){

        String[] tempVector;
        tempVector = text.split("\\s+");
        for (String elVector : tempVector){
            textMap.put(elVector, null);
        }

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

}
