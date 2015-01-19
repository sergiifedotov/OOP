package OOP.lesson9;

import java.util.ArrayList;
 
public class FilterPair {
   public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<Integer>();
       for (int i = 0; i < 20; i++) {
           list.add((int)(Math.random() * 11 + 120)); // [120 - 130]
       }
       System.out.println(list);
       new FilterPair().revovePairs(list, 130);
       System.out.println(list);
   }
   
   public void revovePairs(ArrayList<Integer> list, Integer val) {
       for (int i = 0; i < list.size(); i++) {
           if (list.get(i).equals(val)) {
               list.remove(i);
               i--;
           }
       }
   }
}