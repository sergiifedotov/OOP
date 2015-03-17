package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Chuvychin on 19.02.2015.
 */
@Entity
@Table (name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "CPU_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    private String frequency; //частота
    private String model;

    public CPU(){

    }

    public CPU(Vendor vendor, String frequency, String model) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    @Override
    public String toString(){
        return vendor+"/"+frequency+"/"+model;
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

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
