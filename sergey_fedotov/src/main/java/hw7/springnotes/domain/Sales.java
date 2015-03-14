package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 *Создать сущности для базы данных "Магазин ноутбуков":
 Тип ноутбука(производитель, модель, дата производства, процессор, память)
 Производители(имя)
 Процессоры(производитель, частота, модель)
 Память(производитель, размер)
 Склад ноутбуков(тип ноутбука, количество, цена)
 Продажи(склад ноутбуков, дата продажи, количество)

 domain
 hw7.springnotes.domain.Notebook
 hw7.springnotes.domain.Vendor
 hw7.springnotes.domain.CPU
 hw7.springnotes.domain.Memory
 hw7.springnotes.domain.Store
 hw7.springnotes.domain.Sales
 */
@Entity
@Table(name="SALES")
public class Sales {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_SALES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="SALES_ID")
    private Long id;

    @ManyToOne
    //@JoinColumn(name="STORE")
    private Store store;

    @Column(name="SALES_DATE")
    private Date sales_date;

    @Column(name="AMOUNT")
    private Integer amount;

    public Sales() {
    }

    public Sales(Store store, Date sales_date, Integer amount) {
        this.store = store;
        this.sales_date = sales_date;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", store=" + store +
                ", sales_date=" + sales_date +
                ", amount=" + amount +
                '}';
    }
}
