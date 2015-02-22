package session13;

/**
 * Created by tsv on 21.02.15.
 */
public class Company {
    private String name;
    private int anInt;
    private Human director;

    public Company() {
    }

    public Company(String name, Human director, int anInt) {
        this.name = name;
        this.director = director;
        this.anInt = anInt;
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(int anInt) {
        this.anInt = anInt;
    }

    public Company(Human director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public Human getDirector() {
        return director;
    }

    public void setDirector(Human director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", anInt=" + anInt +
                ", director=" + director +
                '}';
    }
}