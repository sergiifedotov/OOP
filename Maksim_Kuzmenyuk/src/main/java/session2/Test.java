package session2;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Maksim_Kuzmenyuk
 * Date: 27.01.15
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "ab";
        String s3 = new String("ab");
        if(s1==s3)System.out.print("true"); else System.out.print("false");
    }
}
