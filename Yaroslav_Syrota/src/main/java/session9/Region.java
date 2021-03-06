package session9;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
@Entity
@Table(name = "REGIONS")
public class Region {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 5, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column(name = "REGION_ID")
    private Long id;
    @Column(name = "REGION_NAME")
    private String name;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Region{id=" + id + ", name='" + name + "\'}";
    }
}
