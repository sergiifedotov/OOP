package hw7.notes.domain;

import hw7.springnotes.domain.Notebook;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by illia_naumov on 20.02.2015.
 */

@Entity
@Table(name = "VENDORS")
public class Vendor {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "Vendors_id_generator", initialValue = 1, allocationSize = 10)
    @Column(name = "VENDOR_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vendor",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "vendor",cascade = CascadeType.PERSIST)
    //private Set<CPU> cpus = new HashSet<CPU>();

    public Vendor(){}

    public Vendor(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vandor" + name;
    }
}
