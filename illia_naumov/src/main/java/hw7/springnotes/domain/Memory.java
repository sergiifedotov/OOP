package hw7.springnotes.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by illia_naumov on 20.02.2015.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {
    @Id
    @SequenceGenerator(name = "memoryGenerator", sequenceName = "GENERATOR_ID", initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memoryGenerator")
    @Column(name = "MEMORY_ID")
    private long id;

    //@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    //@JoinColumn
    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MEMORY_SIZE")
    private int size;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memory",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    public Memory(){}

    public Memory(String vendor, int size) {
        this.size = size;
        this.vendor = vendor;
    }

    //<editor-fold desc="getters">
    public String getVendor() {
        return vendor;
    }

    public long getId() {
        return id;
    }

    public int getSize() {
        return size;
    }
    //</editor-fold>

    //<editor-fold desc="setters">
    public void setSize(int size) {
        this.size = size;
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
        return "Memory vendor: " + vendor + " and size is " + size;
    }
}
