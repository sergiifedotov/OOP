package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 20.02.2015.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Notebooks_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @OneToOne
    @JoinColumn(name="VENDOR", nullable=false)
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @OneToOne
    @JoinColumn(name="CPU", nullable=false)
    private CPU cpu;

    @OneToOne
    @JoinColumn(name="MEMORY", nullable=false)
    private Memory memory;

    public Notebook(){}

    public Notebook(Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory){
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    //<editor-fold desc="getters">
    public Memory getMemory() {
        return memory;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public String getModel() {
        return model;
    }

    public Vendor getVendor() {
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
