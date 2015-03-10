package hw7.notes.domain;

import hw7.springnotes.notes.domain.Store;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by illia_naumov on 20.02.2015.
 */
@Entity
@Table(name = "SALES")
public class Sales {
    @Id
    @SequenceGenerator(name = "salesGenerator", sequenceName = "SALES_GENERATOR_ID",
                        initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salesGenerator")
    @Column(name = "SALE_ID")
    private long id;

    @ManyToOne
    private Store stor;


    @Temporal(TemporalType.DATE)
    @Column(name = "SELLING_DATE")
    private Date sellingDate;

    @Column(name = "QUANTITY")
    private int quantity;


    public Sales(){}

    public Sales(Store stor, Date sellingDate, int quantity) {
        this.stor = stor;
        this.sellingDate = sellingDate;
        this.quantity = quantity;
    }

    //<editor-fold desc="getters">
    public long getId() {
        return id;
    }

    public Store getStor() {
        return stor;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public int getQuantity() {
        return quantity;
    }
    //</editor-fold>

    //<editor-fold desc="setters">
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public void setStor(Store stor) {
        this.stor = stor;
    }

    public void setId(long id) {
        this.id = id;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "Sale number " + id + " selt quantity " + quantity;
    }
}
