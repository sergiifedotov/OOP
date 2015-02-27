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


    @ManyToOne(cascade = CascadeType.ALL)
    private Vendor vendor;

    @ManyToOne(cascade = CascadeType.ALL)
    private CPU cpu;

    @ManyToOne (cascade = CascadeType.ALL)
    private Memory memory;

    @Column(name = "MODEL")
    private String model;

    @Temporal(TemporalType.DATE)
    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;


    @OneToOne(cascade = CascadeType.ALL)
    private Store store;

    public Notebook() {
    }
    public Notebook(String model, Date manufactureDate) {
        this.model = model;
        this.manufactureDate = manufactureDate;

    }
    public Notebook(String model) {
        this.model = model;
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

