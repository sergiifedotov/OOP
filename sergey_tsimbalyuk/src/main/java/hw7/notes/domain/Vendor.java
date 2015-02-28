package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_PERSON_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NAME")
    private String name;

    public Vendor(){
    }

    public Vendor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
