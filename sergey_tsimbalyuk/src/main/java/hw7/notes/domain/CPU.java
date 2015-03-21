package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Entity
@Table(name ="CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PERSON_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "FREQUENCY")
    private int frequency;

    @Column(name = "MODEL")
    private String model;

    public CPU(){}

    public CPU(Vendor vendor, String model, int frequency){
        this.vendor = vendor;
        this.model = model;
        this.frequency = frequency;
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Vendor = " + vendor + ", model =" + model + ", frequency " + frequency + ".";
    }
}
