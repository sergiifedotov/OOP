package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Chuvychin on 19.02.2015.
 */
@Entity //defoult
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "NOTEBOOK_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;
    private String model;

    @Temporal(TemporalType.DATE)
    @Column (name = "MANUFACTURE_DATE")
    private Date date;

    @ManyToOne
    private CPU cpu;

    @ManyToOne
    private Memory memory;

    public Notebook(){

    }

    public Notebook(Vendor vendor, String model, Date date, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.date = date;
        this.cpu = cpu;
        this.memory = memory;
    }

    @Override
    public String toString(){
        return "id: "+ id + "/ Vendor: " +vendor + "/ Model: " + model + "/ Manufacture Date: "+ getDate().toString()+ "/ CPU: " + cpu + "/ Memory: " + memory;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
