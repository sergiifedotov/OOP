package session13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by stan on 21.02.15.
 */
@Component
public class Man {
    @Value("director")
    private String name;
    @Value("27")
    private Integer age;

    public Man(String name) {
        this.name = name;
    }

    public Man() {
    }

    public Man(String age, String name){

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
        return "Man{" + "Name: " + this.name + " , " + "Age: " + this.age + "}";
    }


}