package hw2.hash;

/**
 * Created by vladimir on 25.01.2015.
 */
public class Entry {
    private Integer key;
    private User user;

    public Entry() {
    }

    public Entry(int key, User user) {
        this();
        this.key = key;
        this.user = user;
    }

    public Integer getKey() {
        return key;
    }
    public void setKey(Integer key) {
        this.key = key;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "" + key + " " + user;
    }

}
