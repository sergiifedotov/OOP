package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Chuvychin on 27.02.2015.
 */
@Entity
@Table(name = "STORE")
public class Store {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "STORE_ID")
    private Long id;

    @OneToOne
    private Notebook notebook;

    private Integer amount;

    private Double price;

    public Store() {
    }

    public Store(Notebook notebook, Integer amount, Double price) {
        this.notebook = notebook;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public String toString(){
        return notebook + "/ "+amount+"/ "+price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

