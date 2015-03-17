package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Entity
@Table(name = "STORE")
public class Store {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PERSON_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK")
    private Notebook notebook;

    @Column (name = "AMOUNT")
    private int amount;

    @Column(name = "PRICE")
    private int price;

    public Store(){

    }
    public Store(Notebook notebook, int amount, int price){
        this.notebook = notebook;
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        return "Notebook = " + notebook + ", amount = " + amount + ", price = " + price + ".";
    }
}
