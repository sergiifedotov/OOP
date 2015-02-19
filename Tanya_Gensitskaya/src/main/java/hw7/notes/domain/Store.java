package hw7.notes.domain;

import javax.persistence.*;

@Entity
@Table(name = "STORE")
public class Store {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORE_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "STORE_ID")
    private Long id;

    @Column(name = "NOTEBOOK")
    private Notebook notebook;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "PRICE")
    private Double price;

    public Store() {

    }
    public Store(Notebook notebook, Integer amount, Double price) {
        this.notebook = notebook;
        this.amount = amount;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Store {id=" + id
                + ", notebook='" + notebook
                + ", amount='" + amount
                + ", price='" + price
                + "}";
    }
}
