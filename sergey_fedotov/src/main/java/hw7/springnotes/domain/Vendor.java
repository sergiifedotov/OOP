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
@Table(name="VENDOR")
public class Vendor {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_VENDOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="VENDOR_ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
                    fetch = FetchType.EAGER, // подргужать все сразу
                    mappedBy = "vendor", // включить двунаправленность
                    cascade = CascadeType.ALL // каскадирование
            )
    private List<Notebook> notebooks = new LinkedList<>();

    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
                    fetch = FetchType.EAGER, // подргужать все сразу
                    mappedBy = "vendor", // включить двунаправленность
                    cascade = CascadeType.ALL // каскадирование
            )
    private List<CPU> cpus = new LinkedList<>();

    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
                    fetch = FetchType.EAGER, // подргужать все сразу
                    mappedBy = "vendor", // включить двунаправленность
                    cascade = CascadeType.ALL // каскадирование
            )
    private List<Memory> memories = new LinkedList<>();

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    public void addNotebooks (Notebook notebook) {
        notebook.setVendor(this);
        notebooks.add(notebook);
    }

    public void addCPU (CPU cpu) {
        cpu.setVendor(this);
        cpus.add(cpu);
    }

    public void addMemory (Memory memory) {
        memory.setVendor(this);
        memories.add(memory);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
