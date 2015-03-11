package hw9.taxi.domain;

import javax.persistence.*;

/**
 * Created by vladimir on 09.03.2015.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_ORDERS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "ORDER_ID")
    private Long id;
    @ManyToOne
    private Client client;
    private Integer amount;
    private String addressFrom;
    private String addressTo;

    public Order() {
    }

    public Order(Client client, Integer amount, String addressFrom, String addressTo) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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
        return "Order{id=" + id
                + ", client=" + client
                + ", amount=" + amount
                + ", addressFrom=" + "'" + addressFrom + "'"
                + ", addressTo=" + "'" + addressTo + "'"
                + "}";
    }
}
