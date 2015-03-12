package hw9.taxi.domain;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanya on 11.03.2015.
 */
@Entity
public class Client {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENT_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column(name = "CLIENT_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "SUMMA")
    private Double summa;

    @Column(name = "DATE_LAST_ORDER")
    private Date dateLastOrder;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Order> orders;

    public Client() {
        orders = new HashSet<Order>();
    }

    public Client(String firstName, String lastName, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Client(String firstName, String lastName, String phone, String address, Double summa, Date dateLastOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.summa = summa;
        this.dateLastOrder = dateLastOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public Date getDateLastOrder() {
        return dateLastOrder;
    }

    public void setDateLastOrder(Date dateLastOrder) {
        this.dateLastOrder = dateLastOrder;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", summa=" + summa +
                ", dateLastOrder=" + dateLastOrder +
                '}';
    }
}
