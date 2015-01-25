package Session3_4_DZ;

import java.util.Date;

/**
 * Created by Chuvychin on 22.01.2015.

 Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол

 Класс задания hw2.hash.User
 */
public class User {



    private String login;
    private String pass;
    private Date date;
    private int rating;
    private String sex;

    public User(){
        this.date = new Date();
    }

     public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
        this.date = new Date();
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

        if (this.login == null || user.getLogin() == null){
            return false;
        }

        if (this.pass == null || user.getPass() == null){
            return false;
        }

        if (login != null && user.login !=null) {
            if(!login.equals(user.login)){
                return false;
            }

        }
        if (pass != null && user.pass !=null) {
            if (!pass.equals(user.pass))
            return false;
        }

        if (!date.equals(user.date)){

            return false;
        }

        if (sex != null && user.sex !=null){
            if(!sex.equals(user.sex))
            return false;
        }



        return true;
    }

    @Override
    public int hashCode() {
        try {
            int result = date.hashCode();
            result = 31 * result + pass.hashCode() + login.hashCode()  + sex.hashCode();
            return result;
        } catch (NullPointerException ex){
            int result = date.hashCode()*31;
            return  result;
        }
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



}
