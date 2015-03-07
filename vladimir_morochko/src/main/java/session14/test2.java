package session14;

/**
 * Created by vladimir on 06.03.2015.
 */
public class test2 {
    public static void main(String[] args) {
        String string = "123q";
        String pattern = "(?=.*[0-9])(?=.*[a-z]).{0,}";
        boolean match = string.matches(pattern);
        System.out.println(string + " " + match);
    }
}
