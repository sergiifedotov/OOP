package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sales")
public class Sales {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORE_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "SALES_ID")
    private Long id;


    @Temporal(TemporalType.DATE)
    @Column(name = "SALES_DATE")
    private Date salesDate;

    @Column(name = "AMOUNT")
    private Integer amount;

    @OneToOne(cascade = CascadeType.ALL)
    private Store store;

    public Sales() {
    }
    public Sales(Store store,  Integer amount) {
        this.store = store;
        this.amount = amount;
    }
    public Sales(Store store, Date salesDate, Integer amount) {
        this.store = store;
        this.salesDate = salesDate;
        this.amount = amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    @Override
    public String toString() {
        return "Sales {id=" + id

                + ", salesDate='" + salesDate
                + ", amount='" + amount
                + "}";
    }
}

