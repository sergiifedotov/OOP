package hw7.springnotes.domain;

import javax.persistence.*;


/**
 * Created by Chuvychin on 19.02.2015.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "MEMORY_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    private String size;

    public Memory() {
    }

    public Memory(Vendor vendor, String size) {
        this.vendor = vendor;
        this.size = size;
    }

    @Override
    public String toString(){
        return vendor+"/"+size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
