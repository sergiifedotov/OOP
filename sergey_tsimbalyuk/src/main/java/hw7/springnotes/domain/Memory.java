package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Entity
@Table(name = "MEMORY")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PERSON_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "SIZE")
    private int size;

    public Memory(){}

    public Memory(Vendor vendor, int size){
        this.size = size;
        this.vendor = vendor;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public Vendor getVendor(){
        return vendor;
    }

    public void setVendor(Vendor vendor){
        this.vendor = vendor;
    }

    public String toString(){
        return "Vendor = " + vendor + ", size = " + size +".";
    }
}
