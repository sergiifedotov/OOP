package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Entity
@Table(name = "TYPE")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PERSON_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Column (name = "DATE")
    private String date;

    @Column (name = "PROCESSORS")
    private CPU cpu;

    @Column (name = "MEMORY")
    private Memory memory;

    public Notebook(){

    }

    public Notebook(Vendor vendor, String model, String date, CPU cpu, Memory memory){
        this.vendor = vendor;
        this.model = model;
        this.date = date;
        this.cpu = cpu;
        this.memory = memory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public CPU getCPU() {
        return cpu;
    }

    public void setCPU(CPU cpu) {
        this.cpu = cpu;
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

    @Override
    public String toString() {
        return "Vendor = " + vendor + ", model = " + model + ", date = " + date + ", CPU = " + cpu + ", memory = " + memory + ".";
    }
}

