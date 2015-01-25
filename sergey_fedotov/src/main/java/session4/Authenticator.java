package session4;

import java.util.HashMap;

/**
 * Created by warit on 17.01.2015.
 */
public class Authenticator {

    private HashMap<String, String> memberList;

    public Authenticator(){
        memberList = new HashMap<>();
    }

    public void addMemberList(String login, String pass){
        memberList.put(login, pass);
    }

    public boolean auth(String login, String pass){
       return memberList.containsKey(login)&&memberList.get(login).equals(pass);
    }

}
