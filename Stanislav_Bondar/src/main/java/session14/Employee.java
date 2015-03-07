package session14;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by stan on 21.02.2015.
 */
@Entity
@Component
@Table(name = "EMPLOYEES")
public class Employee {



    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column (name = "EMPLOYEE_ID")
    @Value("id")
    private Long id;




    @Column (name = "FIRST_NAME")
    @Value("name")
    private String name;

    @Column (name = "JOB_ID")
    @Value("prof")
    private String prof;

    @Column (name = "SALARY")
    @Value("age")
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
