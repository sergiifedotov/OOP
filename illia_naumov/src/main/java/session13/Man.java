package session13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by illia_naumov on 21.02.2015.
 */
//@Scope
//Component("man1")
public class Man {
    //@Value("${name}")
    private String name;
    //@Value("${age})")
    private int age;

    public Man(){

    }

    public Man(int age) {
        this.age = age;
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " and his age is " + age ;
    }
}
