package session13.DAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsv on 14.02.15.
 */
@Entity
@Table
public class CompanyTwoDao {

    @Id
    @Column
    private Long id;

    @Override
    public String toString() {
        return "Company{" +
                ", name='" + name + '\'' +
                ", employeeList=" + employeeTwoDaoList +
                '}';
    }

    @Column
    private String name;

    public CompanyTwoDao(String name) {
        this.name = name;
    }

    public CompanyTwoDao() {
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

    public void setEmployee(EmployeeTwoDao employeeTwoDao){
        employeeTwoDaoList.add(employeeTwoDao);
    }


    @OneToMany
    private List<EmployeeTwoDao> employeeTwoDaoList = new ArrayList<>();

    public void setEmployeeTwoDaoList(List<EmployeeTwoDao> employeeTwoDaoList) {
        this.employeeTwoDaoList = employeeTwoDaoList;
    }

    public List<EmployeeTwoDao> getEmployeeTwoDaoList() {
        return employeeTwoDaoList;
    }
}
