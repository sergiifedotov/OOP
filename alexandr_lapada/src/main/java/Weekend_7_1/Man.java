package Weekend_7_1;

/**
 * Created by sanya on 21.02.2015.
 */
public class Man {
    private String name;
    private Integer age;

    public Man() {
    }

    public Man(Integer age) {
        this.age = age;
    }

    public Man(Integer age, String name) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Man{" +"name='" + name + '\'' +", age=" + age +'}';
    }
}
