package Weekend_5_1;

import org.h2.engine.Session;

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
            allocationSize = 5, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="REGION_ID")
    private Integer id =  6;

    @Column(name="REGION_NAME")
    private String region = "XXXX";


}
