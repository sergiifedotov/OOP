package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Chuvychin on 19.02.2015.
 */
@Entity
@Table(name = "SALES")
public class Sales {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "SALES_ID")
    private Long id;

    @OneToOne
    private Store store;

    @Temporal(TemporalType.DATE)
    private Date sales_date;

    private Integer amount;

    public Sales() {
    }

    public Sales(Store store, Date sales_date, Integer amount) {
        this.store = store;
        this.sales_date = sales_date;
        this.amount = amount;
    }

    @Override
    public String toString(){
        return store+" / "+"Sales date: "+sales_date.toString()+" / "+amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getSales_date() {
        return sales_date;
    }

    public void setSales_date(Date sales_date) {
        this.sales_date = sales_date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
