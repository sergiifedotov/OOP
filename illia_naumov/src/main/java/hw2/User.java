package hw2;

/**
 * Created by user on 20.01.2015.
 */
/**
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол

 Класс задания hw2.hash.User
 */
public class User {
    private String teststring;
    private String login;
    private String pass;
    private String registrationDate;
    private int rate;
    private String gender;

    public User() {
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        if (!login.equals(user.login)) {
            return false;
        }
        if (!pass.equals(user.pass)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + pass.hashCode();
        return result;
    }
    class UserTest {
        public void equalsTest(){

        }
        public void hashCodeTest(){
            int hashCode = 31*("Zina".hashCode())+("111".hashCode()); //ожидаемый результат
            int test1 = (new User("Zina", "111")).hashCode();  //параметры
            int test2 = (new User("Magda", "666")).hashCode();
            int test3 = (new User("", "-1")).hashCode();
            if(test1 == hashCode && test2 != hashCode && test3 != hashCode){
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }
        }
        public boolean assertEquals(int a, int b){
            return a == b ? true : false;
        }
    }
}