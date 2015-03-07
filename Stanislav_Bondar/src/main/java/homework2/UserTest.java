package homework2;

/**
 * Created by stan on 24.01.15.
 */
public class UserTest {
    public static void main(String[] args) {
        User user1 = new User("sasha","qwerty","29.12.1988",66,"male");
        User user2 = new User("ira","qwerty","29.12.1988",89,"female");
        User user3 = new User("sasha","qwerty","29.12.1988",66,"male");

        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));


    }
}
class User {
    private String login;
    private String password;
    private String registrationDate;
    private Integer rating;
    private String pol;

    public User(){}

    public User(String login, String password, String registrationDate, Integer rating, String pol){
        this.login = login;
        this.password = login;
        this.registrationDate = registrationDate;
        this.rating = rating;
        this.pol = pol;
    }

    public void setLogin(String login){this.login = login;}
    public String getLogin(){return(login);}
    public void setPassword(String password){this.password = login;}
    public String getPassword(){return(password);}
    public void setRegistrationDate(String registrationDate){this.registrationDate = registrationDate;}
    public String getRegistrationDate(){return(registrationDate);}
    public void setRating(Integer rating){this.rating = rating;}
    public Integer getRating(){return(rating);}
    public void setPol(String pol){this.pol = pol;}
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
                && this.getPol().equals(user.getPol())){rez = true;}
        return rez;
    }




}
