package session04;

/**
 * Created by tsv on 18.01.15.
 */
public class User {
    private final int age;
    private final String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

//    public User(String s, String name) {
//
//    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == null) {
            return false;
        } else if (this == ob) {
            return true;
        } else if (!(ob instanceof User)) {
            return false;
        }

        User user = (User) ob;

        if (user.age != age) {
            return false;
        } else if (!user.name.equals(name)) {
            return false;
        } else {
            return true;
        }
    }
}