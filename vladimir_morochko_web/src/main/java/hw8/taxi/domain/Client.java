package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by vladimir on 03.03.2015.
 *
 Функции:
 - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 */
public class Client {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private Integer sum;
    private Date lastOrderDate;

    public Client() {
    }

    public Client(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public Client(Long id, String name, String surname, String phone, String address) {
        this.id = id;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
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
        return "Client{id=" + id
                + ", name=" + "'" + name + "'"
                + ", surname=" + "'" + surname + "'"
                + ", phone=" + "'" + phone + "'"
                + ", address=" + "'" + address + "'"
                + ", sum=" + sum
                + ", lastOrderDate=" + String.format("%tF", lastOrderDate)
                + "}";
    }
}
