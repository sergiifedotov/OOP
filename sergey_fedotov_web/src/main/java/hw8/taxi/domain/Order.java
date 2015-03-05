package hw8.taxi.domain;

import java.util.Date;

/**
 * оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 */
public class Order {
    private Date date;
    private Client client;
    private int amount;
    private String addressFrom;
    private String addressTo;

    public Order() {
    }

    public Order(Date date, Client client, int amount, String addressFrom, String addressTo) {
        this.date = date;
        this.client = client;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", client=" + client +
                ", amount=" + amount +
                ", addressFrom='" + addressFrom + '\'' +
                ", addressTo='" + addressTo + '\'' +
                '}';
    }
}
