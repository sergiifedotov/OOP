package hw7.springnotes.domain;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanya on 24.02.2015.
 */
@Entity
public class Store {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORE_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;

    @ManyToMany
    @JoinTable(name = "notebook_store")
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Sales> sales = new HashSet<Sales>();

    @Column
    private Integer quantity;

    @Column
    private Double price;

    public Store() {

    }

    public Store(Notebook notebook, Integer quantity, Double price) {
        this.notebooks.add(notebook);
        this.quantity = quantity;
        this.price = price;
    }

    public void setNotebook(Notebook notebook){
        this.notebooks.add(notebook);
    }

    public Set<Notebook> getNotebook(){
        return notebooks;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
