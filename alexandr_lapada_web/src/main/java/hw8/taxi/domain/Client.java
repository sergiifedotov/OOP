package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by sanya on 04.03.2015.
 */
public class Client {

    private String firstName;
    private String lastName;
    private String foneNumber;
    private String address;
    private Double sum;
    private Date dateLastOrder;

    public Client(){

    }

    public Client(String firstName, String lastName, String foneNumber, String address, Double sum, Date dateLastOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.foneNumber = foneNumber;
        this.address = address;
        this.sum = sum;
        this.dateLastOrder = dateLastOrder;
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

    public String getFoneNumber() {
        return foneNumber;
    }

    public void setFoneNumber(String foneNumber) {
        this.foneNumber = foneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getDateLastOrder() {
        return dateLastOrder;
    }

    public void setDateLastOrder(Date dateLastOrder) {
        this.dateLastOrder = dateLastOrder;
    }
}
