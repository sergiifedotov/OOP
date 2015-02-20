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
@Table(name="CPU")
public class CPU {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_CPU_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="CPU_ID")
    private Long id;

    @Column(name="MODEL")
    private String model;

    @ManyToOne
    //@Column(name="VENDOR")
    //@JoinColumn(name="VENDOR")
    //@JoinTable(name = "VENDOR", joinColumns = @JoinColumn(name = "ID_BOOK"), inverseJoinColumns = @JoinColumn(name = "ID_STUDENT"))
    private Vendor vendor;

    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
                    fetch = FetchType.EAGER, // подргужать все сразу
                    mappedBy = "cpu", // включить двунаправленность
                    cascade = CascadeType.ALL // каскадирование
            )
    private List<Notebook> notebooks = new LinkedList<>();

    public CPU() {
    }

    public CPU(String model) {
        this.model = model;
    }

    public void addNotebooks (Notebook notebook) {
        notebook.setCpu(this);
        notebooks.add(notebook);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }


    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
