package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "NOTEBOOK")
public class Notebook {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "NOTEBOOK_ID")
    private Long id;

    @Column(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Temporal(TemporalType.DATE)
    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @Column(name = "CPU")
    private CPU cpu;

    @Column(name = "MEMORY")
    private Memory memory;

    public Notebook() {
    }

    public Notebook(Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Notebook {id=" + id
                + ", vendor='" + vendor
                + ", model='" + model
                + ", manufactureDate='" + manufactureDate
                + ", cpu='" + cpu
                + ", memory='" + memory
                + "}";
    }
}

