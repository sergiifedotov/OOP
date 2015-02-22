package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by illia_naumov on 20.02.2015.
 */

@Entity
@Table(name = "VENDORS")
public class Vendor {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "Vendors_id_generator", initialValue = 1, allocationSize = 10)
    private long id;

    @Column(name = "Name")
    private String name;

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
