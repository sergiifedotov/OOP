package Weekend_5_2;

import javax.persistence.*;

/**
 * Created by sanya on 07.02.2015.
 */
@Entity
@Table(name="REGIONS")
public class Region {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID",
            allocationSize = 5, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="REGION_ID")
    private Long id;

    @Column(name="REGION_NAME")
    private String region;

    public Region(){

    }

    public Region(String region){

        this.region = region;
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return region;
    }

    public void setId(Long id){

        this.id = id;
    }
}
