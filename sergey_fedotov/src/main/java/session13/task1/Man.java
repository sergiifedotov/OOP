package session13.task1;

/**
 * Created by warit on 21.02.2015.
 */
public class Man {
    private int age;
    String name;

    public Man() {

    }

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Man(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
