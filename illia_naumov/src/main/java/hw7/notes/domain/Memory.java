package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by illia_naumov on 20.02.2015.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {
    @Id
    @SequenceGenerator(name = "memoryGenerator", sequenceName = "GENERATOR_ID", initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memoryGenerator")
    private long id;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "SIZE")
    private int size;

    public Memory(){}

    public Memory(int size, String vendor) {
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
