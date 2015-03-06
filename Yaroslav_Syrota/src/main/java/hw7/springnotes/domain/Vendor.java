package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Chuvychin on 27.02.2015.
 */
@Entity
@Table(name = "VENDORS")
public class Vendor {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "VENDOR_ID")
    private Long id;

    private String name;

    public  Vendor(){

    }

    public Vendor(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
