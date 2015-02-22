package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by illia_naumov on 20.02.2015.
 */
@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "cpuIdGenerator", sequenceName = "CPU_id", initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cpuIdGenerator")
    private long id;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "FREQUENCY")
    private float frequency;

    @Column(name = "MODEL")
    private String model;

    public CPU(){}

    public CPU(String vendor, float frequency, String model) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    //<editor-fold desc="getters">
    public String getVendor() {
        return vendor;
    }

    public float getFrequency() {
        return frequency;
    }

    public String getModel() {
        return model;
    }

    public long getId() {
        return id;
    }
    //</editor-fold>

    //<editor-fold desc="setters">
    public void setModel(String model) {
        this.model = model;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setId(long id) {
        this.id = id;
    }
    //</editor-fold>


    @Override
    public String toString() {
        return "CPU " + model;
    }
}
