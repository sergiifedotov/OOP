package hw7.notes;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanya on 17.02.2015.
 */
@Entity
public class Vendor {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_VENDOR_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vendor",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    public Vendor(){

    }

    public Vendor(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
