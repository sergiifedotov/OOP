package hw7.springnotes.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 20.02.2015.
 */
@Entity
@Table(name = "store")
public class Store {
    @Id
    @SequenceGenerator(name = "storeGenerator", sequenceName ="STORE_ID_GENERATOR", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storeGenerator")
    @Column(name = "STORE_ID")
    private long id;

    @ManyToMany
    @JoinTable(name = "notebook_store")
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Sales> sales = new HashSet<Sales>();

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRICE")
    private double price;

    public Store(){}

    public Store(Notebook notebookType, int quantity, double price) {
        this.notebooks.add(notebookType);
        this.quantity = quantity;
        this.price = price;
    }

    //<editor-fold desc="getters">
    public long getId() {
        return id;
    }

    public Set<Notebook> getNotebook(){
        return notebooks;
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

    public void setNotebook(Notebook notebook){
        this.notebooks.add(notebook);
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
        return "Notebook in the store :" + " quantity is: " + quantity;
    }
}
