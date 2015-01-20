package hw2.hash;

import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.01.15
 *
 * Написать модульные тесты для класса пользователь,
 * на методы equals и hashCode.
 * Поля класса пользователь:
 * 1. Логин
 * 2. Пароль
 * 3. Дата регистрации
 * 4. Рейтинг (вещественное число)
 * 5. Пол
 *
 * Класс задания hw2.hash.User
 */

public class User {
    private String login;
    private String password;
    private GregorianCalendar regDate;
    private Double rating;
    private enum gender {MALE, FEMALE}
    private gender sex;

    public User() {
        login = "John Doe";
        password = "111";
        regDate = new GregorianCalendar();
        rating = 1.0;
        sex = gender.MALE;
    }

    public User(String login, String password) {
        this();
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GregorianCalendar getRegDate() {
        return regDate;
    }

    public void setRegDate(GregorianCalendar regDate) {
        this.regDate = regDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public gender getSex() {
        return sex;
    }

    public void setSex(gender sex) {
        this.sex = sex;
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
        if (!password.equals(user.password)) {
            return false;
        }
        if (!regDate.equals(user.regDate)) {
            return false;
        }
        if (!rating.equals(user.rating)) {
            return false;
        }
        if (!sex.equals(user.sex)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + regDate.hashCode();
        result = 31 * result + rating.hashCode();
        result = 31 * result + sex.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{login=" + login + "password=" + password + "}";
    }

}
