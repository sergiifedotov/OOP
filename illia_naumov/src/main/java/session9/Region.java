package session9;

import javax.persistence.*;

/**
 * Created by user on 07.02.2015.
 */
@Entity
@Table(name = "REGIONS")
public class Region{

    @Id
    @SequenceGenerator(name = "REGION_SEQ", sequenceName = "REGION_SEQ",
            allocationSize = 5, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGION_SEQ")

    @Column(name = "Region_id")
    private Long region_id;

    //private String region_id;

    @Column(name = "region_name")
    private String region_name;



    public Region(){

    }
    public Region(String region_name){
        this.region_name = region_name;
    }

    //region getters and setters
    public Long getId() {
        return region_id;
    }

    public void setId(Long id) {
        this.region_id = id;
    }
    public String getRegion_name(){
        return region_name;
    }
    //endregion



}
