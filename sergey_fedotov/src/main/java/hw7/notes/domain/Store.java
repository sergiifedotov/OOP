package hw7.notes.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 *Создать сущности для базы данных "Магазин ноутбуков":
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
@Table(name="STORE")
public class Store {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_STORE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="ID")
    private Long id;

    @ManyToOne
    @Column(name="NOTEBOOK")
    private Notebook notebook;

    @Column(name="AMOUNT")
    private Integer amount;

    @Column(name="PRICE")
    private Double price;

    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
                    fetch = FetchType.EAGER, // подргужать все сразу
                    mappedBy = "store", // включить двунаправленность
                    cascade = CascadeType.ALL // каскадирование
            )
    private List<Sales> saleses = new LinkedList<>();

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

    public void addSales(Sales sales) {
        sales.setStore(this);
        saleses.add(sales);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", notebook=" + notebook +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

}
