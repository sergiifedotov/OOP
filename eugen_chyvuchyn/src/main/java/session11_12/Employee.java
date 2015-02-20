package session11_12;

import javax.persistence.*;

/**
 * Created by Chuvychin on 14.02.2015.
 */
@Entity
@Table (name = "EMPLOYEE")
public class Employee {



    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;



    @OneToOne
    private Company work;

    private String name;
    private String prof;

    private Integer age;

    public Company getWork() {
        return work;
    }

    public void setWork(Company work) {
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return name+" / "+prof+" / "+work.getName();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
