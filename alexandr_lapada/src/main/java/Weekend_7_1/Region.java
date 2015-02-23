package Weekend_7_1;

import javax.persistence.*;

/**
 * Created by sanya on 07.02.2015.
 */
@Entity
@Table(name="REGIONS")
public class Region {

    public Region(){

    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="REGION_ID")
    private Integer id;

    @Column(name="REGION_NAME")
    private String region;

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", region='" + region + '\'' +
                '}';
    }
}
