package hw7.notes;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sanya on 17.02.2015.
 */
@Entity
public class Sales {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALES_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;

    @ManyToOne
    private Store store;

    @Column
    private Date salesDate;

    @Column
    private Integer quantity;

    public Sales(){

    }

    public Sales(Store store, Date date, Integer quantity){
        this.store = store;
        this.salesDate = date;
        this.quantity = quantity;
    }

    public void setStore(Store store){
        this.store = store;
    }

    public void setDate(Date date){
        this.salesDate = date;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public Store getStore(){
        return store;
    }

    public Date getDate(){
        return salesDate;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
