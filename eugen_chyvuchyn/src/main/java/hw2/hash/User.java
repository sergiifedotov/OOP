package hw2.hash;

/**
 * Created by Tsimbalyuk Sergey
 * 2/1/2015.
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 * Поля класса пользователь:
 * 1. Логин
 * 2. Пароль
 * 3. Дата регистрации
 * 4. Рейтинг (вещественное число)
 * 5. Пол
 * Класс задания hw2.hash.User
 */
class User {
    private String login;
    private String password;
    private String regDate;
    private int rating;
    private String sex;

    public User(String login, String password, String regDate, int rating, String sex) {
        this.login = login;
        this.password = password;
        this.regDate = regDate;
        this.rating = rating;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            if (login.equals(user.login) && password.equals(user.password)
                    && regDate.equals(user.regDate)
                    && rating == user.rating && sex.equals(user.sex)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return login.hashCode() + password.hashCode() + regDate.hashCode() + rating + sex.hashCode();
    }
}

class UserTest {
    public static void main(String[] args) {
        User user01 = new User("user001", "sasjdfas", "01-10-2000", 12, "male");
        User usr2 = new User("user002", "adgsdfg", "01-10-2000", 4, "female");
        User usr3 = new User("user003", "zxcqaqwe", "01-10-2000", 0, "female");

        if (user01.equals(usr2) && user01.hashCode() == usr2.hashCode()) {
            System.out.println("true");
        }
        if (user01.equals(usr3) && user01.hashCode() == usr3.hashCode()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}