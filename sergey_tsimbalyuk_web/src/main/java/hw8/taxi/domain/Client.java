package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
public class Client {
    String name;
    String surname;
    String phone;
    String address;
    int sumOrders;
    Date lastOrderDate;

    public Client() {

    }

    public Client(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
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

    public int getSumOrders() {
        return sumOrders;
    }

    public void setSumOrders(int sumOrders) {
        this.sumOrders = sumOrders;
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
                '}';
    }
}
