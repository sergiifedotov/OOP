package session9;

import javax.persistence.*;

/**
 * Created by Chuvychin on 07.02.2015.
 */

@Entity
@Table (name="REGIONS")
public class Region {



    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 5, initialValue = 5)
            @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name="REGION_ID")
    private Long id;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Column(name = "REGION_NAME")
    private String regionName;

    public Region(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
