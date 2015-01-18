package session3;

import java.util.HashSet;

/**
 * Created by warit on 17.01.2015.
 */
public class Authenticator {

    private HashSet<User> memberList;

    public Authenticator(){
        memberList = new HashSet<>();
    }

    public void addMemberList(User user){
        memberList.add(user);
    }

    public boolean auth(String login, String pass){
       return memberList.contains(new User(login,pass));
    }

}
