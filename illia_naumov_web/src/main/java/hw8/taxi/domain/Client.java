package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by illia_naumov on 10.03.2015.
 */
public class Client {
    private String firstName;
    private String lastName;
    private String phone;
    private String adress;
    private int sum;
    private Date dateOfLastOrder;

    public Client() {
    }

    public Client(String firstName, String lastName, String phone, String adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.adress = adress;
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
}
