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
public class CPU {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPU_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;

    @Column
    private String vendor;

    @Column
    private Double frequency;

    @Column
    private String model;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cpu",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    public CPU(){

    }

    public CPU(String vendor, Double frequency, String model){
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    public void setVendor(String vendor){
        this.vendor = vendor;
    }
        public String getVendor() {
            return vendor;
        }

    public void setFrequency(Double frequency){
        this.frequency = frequency;
    }
        public Double getFrequency(){
            return frequency;
        }

    public void setModel(String model){
        this.model = model;
    }
        public String getModel(){
            return model;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Notebook notebook) {
        notebooks.add(notebook);
    }

}
