package hw8.taxi.domain;

/**
 * Created by vladimir on 03.03.2015.
 *
 * оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 */
public class Order {
    private Long id;
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

    public Order(Long id, Client client, Integer amount, String addressFrom, String addressTo) {
        this.id = id;
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
