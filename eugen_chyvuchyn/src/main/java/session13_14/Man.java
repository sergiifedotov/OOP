package session13_14;

/**
 * Created by Chuvychin on 21.02.2015.
 */
public class Man {
    private String name;
    private int age;

    public Man() {
    }

    public Man(int age) {

        this.age = age;
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
