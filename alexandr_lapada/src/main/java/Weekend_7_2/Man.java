package Weekend_7_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sanya on 22.02.2015.
 */
@Component
public class Man {
    @Value("${name}")
    private String name;
    @Value("23")
    private Integer age;

    public Man() {
    }

    public Man(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
