package hw7.springnotes.domain;

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
 hw7.springnotes.domain.Notebook
 hw7.springnotes.domain.Vendor
 hw7.springnotes.domain.CPU
 hw7.springnotes.domain.Memory
 hw7.springnotes.domain.Store
 hw7.springnotes.domain.Sales
 */
@Entity
@Table(name="MEMORY")
public class Memory {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_MEMORY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="MEMORY_ID")
    private Long id;

    @Column(name="AMOUNT")
    private Double amount;

    @ManyToOne
    //@JoinColumn(name="VENDOR_ID")
    private Vendor vendor;


    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
                    fetch = FetchType.EAGER, // подргужать все сразу
                    mappedBy = "memory", // включить двунаправленность
                    cascade = CascadeType.ALL // каскадирование
            )
    private List<Notebook> notebooks = new LinkedList<>();

    public Memory() {
    }

    public Memory(Double amount) {
        this.amount = amount;
    }

    public void addNotebooks (Notebook notebook) {
        notebook.setMemory(this);
        notebooks.add(notebook);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", amount=" + amount +
                ", vendor=" + vendor +
               // ", notebooks=" + notebooks +
                '}';
    }

}
