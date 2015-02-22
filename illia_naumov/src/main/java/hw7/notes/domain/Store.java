package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by user on 20.02.2015.
 */
@Entity
@Table(name = "store")
public class Store {
    @Id
    @SequenceGenerator(name = "storeGenerator", sequenceName ="STORE_ID_GENERATOR", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storeGenerator")
    private long id;

    @OneToOne
    private Notebook notebookType;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRICE")
    private double price;

    public Store(){}

    public Store(Notebook notebookType, int quantity, double price) {
        this.notebookType = notebookType;
        this.quantity = quantity;
        this.price = price;
    }

    //<editor-fold desc="getters">
    public long getId() {
        return id;
    }

    public Notebook getNotebookType() {
        return notebookType;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    //</editor-fold>

    //<editor-fold desc="setters">
    public void setId(long id) {
        this.id = id;
    }

    public void setNotebookType(Notebook notebookType) {
        this.notebookType = notebookType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "Notebook in the store :" + notebookType + " quantity is: " + quantity;
    }
}
