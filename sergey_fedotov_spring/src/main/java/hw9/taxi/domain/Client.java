package hw9.taxi.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 */
@Entity
@Table(name="CLIENTS")
public class Client {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "CLIENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="CLIENT_ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME")
    private String surname;

    @Column(name="PHONE")
    private String phone;

    @Column(name="ADRESS")
    private String address;

    @Column(name="SUM")
    private int sum;

    @Column(name="LAST_ORDER_DATE")
    private Date lastOrderDate;

    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
                    fetch = FetchType.EAGER, // подргужать все сразу
                    mappedBy = "client", // включить двунаправленность
                    cascade = CascadeType.ALL // каскадирование
            )
    private List<Order> orders = new LinkedList<>();

    public Client() {
    }

    public Client(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sum=" + sum +
                ", lastOrderDate=" + lastOrderDate +
                '}';
    }

}
