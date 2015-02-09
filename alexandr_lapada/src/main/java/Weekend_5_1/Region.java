package Weekend_5_1;

import org.h2.engine.Session;

import javax.persistence.*;

/**
 * Created by sanya on 07.02.2015.
 */
@Entity
@Table(name="REGIONS")
public class Region {

    public Region(String australiaaaaa){

    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS_ID",
            allocationSize = 5, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="REGION_ID")
    private Long id;

    @Column(name="REGION_NAME")
    private String region = "Australiaaaaa";


}
