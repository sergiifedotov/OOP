package hw7.notes.domain;


import javax.persistence.*;

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

    public Memory() {

    }
    public Memory(String manufacturer, String value) {
        this.manufacturer = manufacturer;
        this.value = value;
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

    @Override
    public String toString() {
        return "Memory {id=" + id
                + ", manufacturer='" + manufacturer
                + ", value='" + value
                + "}";
    }
}

