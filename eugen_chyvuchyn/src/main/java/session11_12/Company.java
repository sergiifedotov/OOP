package session11_12;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Chuvychin on 14.02.2015.
 */
@Entity
@Table (name = "COMPANY")
public class Company {



    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "work", cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private Set<Employee> employers;

    private String name;

    public Set<Employee> getEmployers() {
        return employers;
    }


    public Double charterCapital;

    public void setEmployers(Set<Employee> employers) {
        this.employers = employers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getCharterCapital() {
        return charterCapital;
    }

    public void setCharterCapital(double charterCapital) {
        this.charterCapital = charterCapital;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", employers=" + employers +
                ", name='" + name + '\'' +
                ", charterCapital=" + charterCapital +
                '}';
    }
//    @Override
//    public String toString(){
//        return id+" / "+ name + " / "+charterCapital;
//    }
}
