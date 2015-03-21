package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by illia_naumov on 10.03.2015.
 */
@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @Column(name = "CLIENT_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "client_id",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String phone;
    @Column
    private String adress;
    @Column
    private int sum;
    @Column(name = "DATE_OF_LAST_ORDER")
    private Date dateOfLastOrder;

    public Client() {
    }

    public Client(String firstName, String lastName, String phone, String adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.adress = adress;
    }

    public Client(String firstName, String lastName, String phone, String adress, int sum, Date dateOfLastOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.adress = adress;
        this.sum = sum;
        this.dateOfLastOrder = dateOfLastOrder;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public int getSum() {
        return sum;
    }

    public Date getDateOfLastOrder() {
        return dateOfLastOrder;
    }

    public void setDateOfLastOrder(Date dateOfLastOrder) {
        this.dateOfLastOrder = dateOfLastOrder;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName + " " + phone + " " + adress;
    }
}
