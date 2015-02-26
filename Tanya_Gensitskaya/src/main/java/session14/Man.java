package session14;

/**
 * Created by ZaR on 21.02.15.
 */

public class Man {

    private Integer age;
    private String name;

    public Man() {

    }

    public Man(Integer age) {
        this.age = age;

    }

    public Man(Integer age, String name) {
        this.age = age;
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
        final StringBuilder sb = new StringBuilder("Man{");
        sb.append("age=").append(age);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
