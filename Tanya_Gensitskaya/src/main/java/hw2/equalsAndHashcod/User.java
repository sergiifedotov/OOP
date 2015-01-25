package hw2.equalsAndHashcod;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 * Поля класса пользователь:
 * 1. Логин
 * 2. Пароль
 * 3. Дата регистрации
 * 4. Рейтинг (вещественное число)
 * 5. Пол
 * <p/>
 * Класс задания hw2.hashMap.User
 */
public class User {
    private String login;
    private String pass;
    private Date dayRegistration;
    private float rating;
    private String sex;

    public User() {
    }

    public User(String login, String pass, int year, int month, int day, float rating, String sex) {
        this.login = login;
        this.pass = pass;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day); // январю соответствует 0
        dayRegistration = calendar.getTime();
        this.rating = rating;
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
        if (!pass.equals(user.pass)) {
            return false;
        }
        if (!dayRegistration.equals(user.dayRegistration)) {
            return false;
        }
        if (Float.compare(user.rating, rating) != 0) {
            return false;
        }
        if (rating != user.rating) {
            return false;
        }
        if (!sex.equals(user.sex)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        float temp = new Float(rating).hashCode();
        int ratingHashCod = (int) temp;
        int result = login.hashCode();
        result = 31 * result + pass.hashCode();
        result = 31 * result + dayRegistration.hashCode();
        result = 31 * result + ratingHashCod;
        result = 31 * result + sex.hashCode();
        return result;
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

    public Date getDayRegistration() {
        return dayRegistration;
    }

    public void setDayRegistration(Date dayRegistration) {
        this.dayRegistration = dayRegistration;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}


