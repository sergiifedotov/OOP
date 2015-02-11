package session9;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ZaR on 07.02.15.
 */
@Entity
@Table(name="REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "REGION",
            allocationSize = 5, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="REGION_ID")
    private Long id;

    @Column(name="REGION_NAME")
    private String name;

     public Region() {
    }

    public Region(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" +name+
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
