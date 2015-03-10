package hw7.notes.domain;

import hw7.springnotes.notes.domain.*;
import hw7.springnotes.notes.domain.CPU;
import hw7.springnotes.notes.domain.Memory;
import hw7.springnotes.notes.domain.Vendor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by user on 20.02.2015.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Notebooks_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private long id;

    @ManyToOne
    private hw7.springnotes.notes.domain.Vendor vendor = null;


    @Column(name = "MODEL")
    private String model;

    @Temporal(TemporalType.DATE)
    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    //@ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "CPU")
    private hw7.springnotes.notes.domain.CPU cpu;

    //@ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "MEMORY")
    private hw7.springnotes.notes.domain.Memory memory;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "notebooks",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<hw7.springnotes.notes.domain.Store> stores = null;

    public Notebook(){}

    public Notebook(hw7.springnotes.notes.domain.Vendor vendor, String model, Date manufactureDate, hw7.springnotes.notes.domain.CPU cpu, hw7.springnotes.notes.domain.Memory memory){
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    //<editor-fold desc="getters">
    public hw7.springnotes.notes.domain.Memory getMemory() {
        return memory;
    }

    public hw7.springnotes.notes.domain.CPU getCpu() {
        return cpu;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public String getModel() {
        return model;
    }

    public hw7.springnotes.notes.domain.Vendor getVendor() {
        return vendor;
    }

    public long getId() {
        return id;
    }
    //</editor-fold>

    //<editor-fold desc="setters">

    public void setId(long id) {
        this.id = id;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "Notebook " + id + "model: " + model;
    }
}
