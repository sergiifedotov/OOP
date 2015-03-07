package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by sanya on 04.03.2015.
 */
public class Order {

    private Client client;
    private Date dateOreder;
    private Double price;
    private String addressDeliveryFrom;
    private String addressDeliveryTo;

    public Order(){

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateOreder() {
        return dateOreder;
    }

    public void setDateOreder(Date dateOreder) {
        this.dateOreder = dateOreder;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddressDeliveryFrom() {
        return addressDeliveryFrom;
    }

    public void setAddressDeliveryFrom(String addressDeliveryFrom) {
        this.addressDeliveryFrom = addressDeliveryFrom;
    }

    public String getAddressDeliveryTo() {
        return addressDeliveryTo;
    }

    public void setAddressDeliveryTo(String addressDeliveryTo) {
        this.addressDeliveryTo = addressDeliveryTo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", dateOreder=" + dateOreder +
                ", price=" + price +
                ", addressDeliveryFrom='" + addressDeliveryFrom + '\'' +
                ", addressDeliveryTo='" + addressDeliveryTo + '\'' +
                '}';
    }
}
