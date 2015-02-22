package hw7.notes;

import javax.persistence.*;

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
 Notebook
 Vendor
 CPU
 Memory
 Store
 Sales
 */

@Entity
@Table(name = "STORE")
public class Store {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORE_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "STORE_ID")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Notebook notebook;
    private Integer amount;
    private Double price;

    public Store() {
    }

    public Store(Notebook notebook, Integer amount, Double price) {
        this.notebook = notebook;
        this.amount = amount;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Store{id=" + id
                + ", notebook=" + notebook
                + ", amount=" + amount
                + ", price=" + price
                + "}";
    }
}
