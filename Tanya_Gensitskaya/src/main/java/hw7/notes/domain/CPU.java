package hw7.notes.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebooks = new HashSet<>();

    public CPU() {
    }

    public CPU(String manufacturer, String frequency, String model) {
        this.manufacturer = manufacturer;
        this.frequency = frequency;
        this.model = model;
    }

    public CPU(String manufacturer, String frequency, String model, Set<Notebook> notebooks) {
        this.manufacturer = manufacturer;
        this.frequency = frequency;
        this.model = model;
        this.notebooks = notebooks;
    }
    public void addNotebooks(Notebook notebook) {
        this.notebooks.add(notebook);
        notebook.setCpu(this);
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
    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }



    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", frequency='" + frequency + '\'' +
                ", model='" + model + '\'' +
                ", notebooks=" + notebooks +
                '}';
    }


}
