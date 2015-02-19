package hw7.notes.domain;


import javax.persistence.*;


@Entity
@Table(name = "VENDOR")

public class Vendor {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_VENDOR_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "VENDOR_ID")
    private Long id;

    @Column (name = "VENDOR_NAME")
    private String name;

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Vendor {id=" + id
                + ", name='" + name
                + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}