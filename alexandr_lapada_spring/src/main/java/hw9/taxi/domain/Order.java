package hw9.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sanya on 12.03.2015.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_ORDER_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "DATE_ORDER")
    private Date dateOrder;

    @ManyToOne
    private Client client;

    @Column(name = "ORDER_PRICE")
    private Double summa;

    @Column(name = "ADDRESS_TO")
    private String addressTo;

    @Column(name = "ADDRESS_FROM")
    private String addressFrom;

    public Order() {
    }

    public Order(Date dateOrder, Client client, Double summa, String addressTo, String addressFrom) {
        this.dateOrder = dateOrder;
        this.client = client;
        this.summa = summa;
        this.addressTo = addressTo;
        this.addressFrom = addressFrom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateOrder=" + dateOrder +
                ", client=" + client +
                ", summa=" + summa +
                ", addressTo='" + addressTo + '\'' +
                ", addressFrom='" + addressFrom + '\'' +
                '}';
    }
}
