package hw7.springnotes.domain;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by sanya on 17.02.2015.
 */
@Entity
public class Notebook {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID",
            allocationSize = 2, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;

    @ManyToOne
    private Vendor vendor = null;

    @Column
    private String model = null;

    @Column
    private Date manufactureDate= null;

    @ManyToOne
    private CPU cpu = null;

    @ManyToOne
    private Memory memory = null;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "notebooks",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Store> stores = null;

    public Notebook(){

    }

    public Notebook(Vendor vendor, String model, Date date, CPU cpu, Memory memory){
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = date;
        this.cpu = cpu;
        this.memory = memory;
    }



    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate() {
        return manufactureDate;
    }

    public void setDate(Date date) {
        this.manufactureDate = date;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStore(Store store){
        stores.add(store);
    }

    public Set<Store> getStores(){
        return stores;
    }
}
