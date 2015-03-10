package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Entity
@Table(name = "Sales")
public class Sales {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PERSON_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "STORE")
    private Store store;

    @Column(name = "DATE_SALES")
    private String date;

    @Column(name = "AMOUNT")
    private int amount;

    public Sales(){}

    public Sales(Store store, String date, int amount){
        this.store = store;
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Store = " + store + ", date = " + date + ", amount = " + amount + ". ";
    }
}
