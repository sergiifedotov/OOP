package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vladimir on 17.02.2015.
 *
 * 1. Создать сущности для базы данных "Магазин ноутбуков":
 Тип ноутбука(производитель, модель, дата производства, процессор, память)
 Производители(имя)
 Процессоры(производитель, частота, модель)
 Память(производитель, размер)
 Склад ноутбуков(тип ноутбука, количество, цена)
 Продажи(склад ноутбуков, дата продажи, количество)

 domain
 hw7.notes.domain.Notebook
 hw7.notes.domain.Vendor
 hw7.notes.domain.CPU
 hw7.notes.domain.Memory
 hw7.notes.domain.Store
 hw7.notes.domain.Sales
 */

@Entity
@Table(name = "SALES")
public class Sales {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALE_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "SALE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Store store;

    @Temporal(TemporalType.DATE)
    @Column (name = "SALE_DATE")
    private Date date;
    private Integer amount;

    public Sales() {
    }

    public Sales(Store store, Date date, Integer amount) {
        this.store = store;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sale{id=" + id
                + ", store=" + store
                + ", amount=" + amount
                + "}";
    }
}
