package hw2.authentication;


/**
 * Created by warit on 17.01.2015.
 */
public class AuthTest {

    public static void addTest(String nameTest, Auth auth, String login, String pass, boolean rezult) {
        boolean rez;
        try {
            auth.add(login, pass);
            rez = true;
        } catch (Exception e) {
            //e.printStackTrace();
            rez = false;
        }
        if (rez == rezult) {
            System.out.println(nameTest.concat("completed successfully"));
        } else {
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void removeTest(String nameTest, Auth auth, String login, boolean rezult) {
        boolean rez;
        try {
            auth.remove(login);
            rez = true;
        } catch (Exception e) {
            //e.printStackTrace();
            rez = false;
        }
        if (rez == rezult) {
            System.out.println(nameTest.concat("completed successfully"));
        } else {
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void authenticateTest(String nameTest, Auth auth, String login, String pass, boolean rezult) {
        boolean rez;
        try {
            rez = auth.authenticate(login, pass);
        } catch (Exception e) {
            //e.printStackTrace();
            rez = false;
        }
        if (rez == rezult) {
            System.out.println(nameTest.concat("completed successfully"));
        } else {
            System.err.println(nameTest.concat("error"));
        }

    }

    public static void main(String[] args) {

        Auth auth = new Auth();

        String nameTest;

        nameTest = "addTest1:";
        addTest(nameTest, auth, "Иван", "1", true);

        nameTest = "addTest2:";
        addTest(nameTest, auth, "Петр", "1", true);

        nameTest = "addTest3:";
        addTest(nameTest, auth, null, null, true);

        nameTest = "removeTest1:";
        removeTest(nameTest, auth, "Иван", true);

        nameTest = "removeTest2:";
        removeTest(nameTest, auth, "Степа", true);

        nameTest = "removeTest3:";
        removeTest(nameTest, auth, null, true);

        nameTest = "authenticateTest1:";
        authenticateTest(nameTest, auth, "Петр", "1", true);

        nameTest = "authenticateTest2:";
        authenticateTest(nameTest, auth, "Иван", "2", false);

        nameTest = "authenticateTest3:";
        authenticateTest(nameTest, auth, null, "2", false);

    }
}