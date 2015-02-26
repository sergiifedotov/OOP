package hw7.notes.domain;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "MEMORY")
public class Memory {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORY_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "MEMORY_ID")
    private Long id;

    @Column(name = "MANUFACTURE")
    private String manufacturer;

    @Column(name = "VALUE")
    private String value;

    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebooks = new HashSet<>();

    public Memory() {

    }
    public Memory(String manufacturer, String value) {
        this.manufacturer = manufacturer;
        this.value = value;
    }

    public Memory(String manufacturer, String value, Set<Notebook> notebooks) {
        this.manufacturer = manufacturer;
        this.value = value;
        this.notebooks = notebooks;
    }

    public void addNotebooks(Notebook notebook) {
        this.notebooks.add(notebook);
        notebook.setMemory(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", value='" + value + '\'' +
                ", notebooks=" + notebooks +
                '}';
    }
}

