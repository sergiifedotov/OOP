package session13_14;

import javax.persistence.*;

/**
 * Created by Chuvychin on 21.02.2015.
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee {



    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "EMPLOYEE_ID")
    private Long id;




    @Column (name = "FIRST_NAME")
    private String name;

    @Column (name = "JOB_ID")
    private String prof;

    @Column (name = "SALARY")
    private Integer age;

    public Employee() {
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
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prof='" + prof + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
