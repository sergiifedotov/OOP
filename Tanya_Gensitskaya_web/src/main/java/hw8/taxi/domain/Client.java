package hw8.taxi.domain;

import javax.persistence.*;

/**
 * Created by Tanya on 05.03.2015.
 */
@Entity
@Table(name= "CLIENT")
public class Client {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENT_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "CLIENT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADRESS")
    private String address;

    @Column(name = "MONEY")
    private String money;

    @Column(name = "DATE_REGIST")
    private String date;



    public Client() {
    }

    public Client(String name, String lastName, String phone, String address, String money, String date) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.money = money;
        this.date = date;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", money='" + money + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
