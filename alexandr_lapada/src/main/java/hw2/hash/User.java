package hw2.hash;

import java.util.Date;

/**
 * Created by sanya on 20.01.2015.
 */
public class User {
    private String login;
    private String password;
    private String date;
    private Integer rating;
    private String pol;

    public User(){}

    public User(String login, String password, String date, Integer rating, String pol){
        this.login = login;
        this.password = login;
        this.date = date;
        this.rating = rating;
        this.pol = pol;
    }

    public void setLogin(String login){this.login = login;}
    public void setPassword(String password){this.password = login;}
    public void setDate(String date){this.date = date;}
    public void setRating(Integer rating){this.rating = rating;}
    public void setPol(String pol){this.pol = pol;}

    public String getLogin(){return(login);}
    public String getPassword(){return(password);}
    public String getDate(){return(date);}
    public Integer getRating(){return(rating);}
    public String getPol(){return(pol);}

    @Override
    public boolean equals(Object obj){
        boolean rez = false;
        if (this == obj){rez = true;}
        if (this == null){rez = false;}
        if (this.getClass() != obj.getClass()){rez = false;}

        User user = (User)obj;
        if (this.getLogin().equals(user.getLogin())
                && this.getPassword().equals(user.getPassword())
                && this.getPol().equals(user.getPol())
                && this.getRating().equals(user.getRating())){rez = true;}
        return rez;
    }

    @Override
    public int hashCode(){
       return (this.getPassword().hashCode() + this.getLogin().hashCode() + this.getPol().hashCode() + this.getRating())%31;
    }



}
