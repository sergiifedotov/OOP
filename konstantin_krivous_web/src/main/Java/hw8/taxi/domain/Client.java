package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by Konstantin on 02.03.2015.
 */
public class Client {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String cost;
    private String date;

    public Client(String name, String surname, String phone, String address, String cost, String date) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.cost = cost;
        this.date = date;
    }

    public Client() {
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String   toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", cost='" + cost + '\'' +
                ", date=" + date +
                '}';
    }
}
