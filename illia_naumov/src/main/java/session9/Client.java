package main.java.session9;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
@Entity
@Table(name="CLIENTS")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="CLIENT_ID")
    private Long id;

    private String name;
    private String surname;
    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_VISIT_DATE")
    private Date date;
    private Double sum;

    public Client() {
    }

    public Client(String name, String surname, int age, Date date, double sum) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.date = date;
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }
}
