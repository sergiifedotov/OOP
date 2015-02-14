package session11.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by @CAT_Caterpiller on 14.02.2015.
 */

/*
task1 - создать класс компания, в которой работает класс сотрудник. один сотрудник может работать в одной компании.
        создать 2 компании и 5 сотрудников. трудоустроить сотрудников равномерно в компании
*/

public class MainCompany {
    public static void main(String[] args) {
        Company comp1 = new Company("Sony");
        Company comp2 = new Company("Toshiba");
        Set<Employee> compSet1 = new HashSet<Employee>();
        compSet1.add(new Employee("Vasya", comp1));
        compSet1.add(new Employee("Tolya", comp1));
        compSet1.add(new Employee("Kolya", comp1));
        Set<Employee> compSet2 = new HashSet<Employee>();
        compSet2.add(new Employee("Grisha", comp2));
        compSet2.add(new Employee("Misha", comp2));
        comp1.setEmployeeSet(compSet1);
        comp2.setEmployeeSet(compSet2);
    }
}
