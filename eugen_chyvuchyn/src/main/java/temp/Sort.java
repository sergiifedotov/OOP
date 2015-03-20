package temp;

import java.util.Arrays;

/**
 * Created by Chuvychin on 12.03.2015.
 */
public class Sort {
    public static void main(String[] args) {
        int[] mass = new int[10];
        for (int i =0; i<mass.length;i++){
            int temp= (int)Math.floor(Math.random()*100);
            mass[i]= temp;
        }
        System.out.println(Arrays.toString(mass));


    }
}
