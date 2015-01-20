package hw2.authentication;

import java.io.IOException;

/**
 * Created by Yaroslav_Syrota on 19.01.2015.
 */
public class AuthTest {
    public static void main(String[] args) throws IOException{
        Auth auth = Auth.AUTH;

        auth.add("vasiliy", "leonid");
        auth.add("lena", "elena");
        auth.add("nova", "poshta");

        System.out.println(auth.authenticate("lena", "elena"));
        System.out.println(auth.authenticate("nova", "leonid"));
        System.out.println(auth.authenticate("", ""));

        System.out.println();

        boolean p = auth.authenticate();
        System.out.println(p);

        auth.remove("nova");
        auth.remove("");
    }
}
