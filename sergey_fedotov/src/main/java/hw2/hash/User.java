package hw2.hash;

import java.util.GregorianCalendar;

/**
 *Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол
 */
public class User {

    private String login;
    private String pass;
    private GregorianCalendar dateOfRegistration;
    private double rating;
    private String sex;

    public User(){

    }

    public User(String login, String pass, GregorianCalendar dateOfRegistration, double rating, String sex){
        this.login = login;
        this.pass = pass;
        this.dateOfRegistration = dateOfRegistration;
        this.rating = rating;
        this.sex = sex;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public GregorianCalendar getDateOfRegistration() {
        return dateOfRegistration;
    }

    public double getRating() {
        return rating;
    }

    public String getSex() {
        return sex;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object user){

        if (user == null)
            return false;
        if (getClass() != user.getClass())
            return false;
        User other = (User) user;

        return (login.equals(other.login))
                &&(pass.equals(other.pass))
                &&(dateOfRegistration.equals(other.dateOfRegistration))
                &&(sex.equals(other.sex));
    }

    @Override
    public int hashCode() {
        return login.hashCode()+pass.hashCode()+dateOfRegistration.hashCode()+sex.hashCode();
    }

}
