package Session4;

/**
 * Created by Chuvychin on 18.01.2015.
 * Пользователь вводит логин и пароль - использовать класс User и authentificator - проверить правильность, использовать HashMap.
 */
public class Main {
 public static void main(String[]args) {
     Authenticator a = new Authenticator();
     System.out.println(a.auth("1", "1"));
     System.out.println(a.auth("1","5"));


 }
}
