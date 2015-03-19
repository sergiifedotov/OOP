package hw9.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 */
@Entity
@Table(name="ORDERS")
public class Order {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="ORDER_ID")
    private Long id;

    @Column(name="DATE_ORDER")
    private Date date;

    @ManyToOne
    private Client client;

    @Column(name="AMOUNT")
    private int amount;

    @Column(name="ADRESS_FROM")
    private String addressFrom;

    @Column(name="ADRESS_TO")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", amount=" + amount +
                ", addressFrom='" + addressFrom + '\'' +
                ", addressTo='" + addressTo + '\'' +
                '}';
    }

}
