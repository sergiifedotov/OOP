package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
public class Order {
    Date date;
    Client client;
    int sum;
    String addressFrom;
    String addressTo;

    public Order() {
    }

    public Order(Date date, Client client, int sum, String addressFrom, String addressTo) {
        this.date = date;
        this.client = client;
        this.sum = sum;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }
}
