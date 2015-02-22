package session13;

/**
 * Created by tsv on 21.02.15.
 */
public class Director {
    String name;
    int age;
    Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCar() {
        return name;
    }

    public Director(){

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

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
