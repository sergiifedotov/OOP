package hw7.notes.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(
            cascade = CascadeType.ALL)
//    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebooks = new HashSet<>();

    public Vendor() {
    }
    public Vendor(String name) {
        this.name = name;

    }
    public Vendor(String name, Set<Notebook> notebooks) {
        this.name = name;
        this.notebooks = notebooks;
    }

    public void addNotebooks(Notebook notebook) {
        this.notebooks.add(notebook);
        notebook.setVendor(this);
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

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", notebooks=" + notebooks +
                '}';
    }
}