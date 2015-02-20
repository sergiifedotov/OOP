package hw7.notes.domain;

import javax.persistence.*;

@Entity
@Table(name= "CPU")
public class CPU {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPU_ID",
                       allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "CPU_ID")
    private Long id;

    @Column(name = "MANUFACTURE")
    private String manufacturer;

    @Column(name = "FREQUENCY")
    private String frequency;

    @Column(name = "MODEL")
    private String model;

    public CPU() {
    }

    public CPU(String frequency, String model, String manufacturer) {
        this.frequency = frequency;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "CPU {id=" + id
                + ", manufacturer='" + manufacturer
                + ", frequency='" + frequency
                + ", model='" + model
                + "}";
    }
}
