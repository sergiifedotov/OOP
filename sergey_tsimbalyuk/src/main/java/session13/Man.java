package session13;

/**
 * Created by tsv on 21.02.15.
 */
public class Man {
    private String name;
    private Integer age;

    public Man() {

    }

    public Man(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Man(String s) {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" + "Name: " + this.name + " , " + "Age: " + this.age + "}";
    }


}