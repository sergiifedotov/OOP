package session9;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name="REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_REGIONS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="REGION_ID")
    private Long id;

    @Column(name="REGION_NAME")
    private String regionName;

    public Region() {
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Region(Long id, String regionName) {
        this.regionName = regionName;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName +
                '}';
    }
}
