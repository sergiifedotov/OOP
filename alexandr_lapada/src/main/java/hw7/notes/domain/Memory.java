package hw7.notes.domain;

import hw7.notes.domain.Notebook;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanya on 17.02.2015.
 */
@Entity
public class Memory {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORY_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    private Long id;

    @Column
    private String vendor;

    @Column
    private Integer memorySize;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memory",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    public Memory(){

    }

    public Memory(String vendor, Integer size){
        this.vendor = vendor;
        this.memorySize = size;
    }

    public void setVendor(String vendor){
        this.vendor = vendor;
    }
        public String getVendor(){
            return vendor;
        }

    public void setSize(Integer size){
        this.memorySize = size;
    }
        public Integer getSize(){
            return memorySize;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
