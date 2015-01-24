package OOP.homework4;

import java.util.ArrayList;
import java.util.Calendar;

/**
Написать класс фирма (hw2.Firm), содержащий имя, адрес, зарплатный счет (сумма), 
сотрудников.
У каждого сотрудника (hw2.Employee) есть имя, фамилия, ставка зарплаты (сумма), 
его личный карточный счет (сумма), год поступления на работу, 
месяц поступления на работу, пол, отдел.
Класс фирма должен выполнять следующие функции:
- Вывести всех сотрудников фирмы на экран (метод void printAllEmployees())
- Вывести на экран всех сорудников, отсортированных по зарплате (шейкерным методом)
- Выдать всем сотрудникам зарплату (перевести на карточный счет каждого сотрудника, 
сумму равную зарплате сотрудника, с главного счета фирмы) (метод void giveSalaryForAll())
- Пересчитать всем сотрудникам дни отпуска (всем кто проработал больше 6 месяцев, 
по 2 дня за каждый отработанный месяц) (метод void calcVocations()) 
**/

public class Firm {
	private String name;
	private String address;
	private long account;
	private ArrayList <Employee> employees;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getAccount() {
		return account;
	}
	
	public void setAccount(long account) {
		this.account = account;
	}
	
	public ArrayList <Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(ArrayList <Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployees(Employee employee) {
		this.employees.add(employee);
	}
	
	public void printAllEmployees() {
		this.ouptutEmployees(this.employees);
	}

	public void printAllEmployeesSorted() {
		ArrayList <Employee> employeesToSort = new ArrayList <Employee> (this.employees);
		this.shakerSort(employeesToSort);
		this.ouptutEmployees(employeesToSort);
	}
	
	private void ouptutEmployees (ArrayList<Employee> employees) {
		for (Employee currentEmployee: employees) {
			System.out.println("Фамилия: " + currentEmployee.getFamilyName());
			System.out.println("Имя: " + currentEmployee.getName());
			System.out.println("Ставка зарплаты: " + currentEmployee.getSalary());
			System.out.println("Счет: " + currentEmployee.getAccount());
			System.out.println("Год поступления: " + currentEmployee.getJoinYear());
			System.out.println("Месяц поступления: " + currentEmployee.getJoinMonth());
			System.out.println("Отпуск: " + currentEmployee.getVacation());
			System.out.println("Пол: " + currentEmployee.isGender());
			System.out.println("Отдел: " + currentEmployee.getDepartment());
			System.out.println();
		}
	}
	
	private void shakerSort(ArrayList<Employee> employeesToSort) {
		boolean sortNeeded = true;
		while (sortNeeded) {
			sortNeeded = false;
			for (int i = 0; i < employeesToSort.size() - 1; i++) {
				if (employeesToSort.get(i).getSalary() < employeesToSort.get(
						i + 1).getSalary()) {
					Employee temp = employeesToSort.get(i);
					employeesToSort.set(i, employeesToSort.get(i + 1));
					employeesToSort.set(i + 1, temp);
					sortNeeded = true;
				}
			}
			if (sortNeeded) {
				for (int i = employeesToSort.size() - 2; i >= 0; i--) {
					if (employeesToSort.get(i).getSalary() < employeesToSort
							.get(i + 1).getSalary()) {
						Employee temp = employeesToSort.get(i);
						employeesToSort.set(i, employeesToSort.get(i + 1));
						employeesToSort.set(i + 1, temp);
					}
				}
			}
		}
	}

	public void giveSalaryForAll() {
		for (Employee currentEmployee: this.employees) {
			account -= currentEmployee.giveSalary();
		}
	}
	
	public void calcVocations() {
		Calendar currentDate = Calendar.getInstance();
		for (Employee currentEmployee: this.employees) {
			int experienceMonths = 
					(currentDate.get(Calendar.YEAR) - currentEmployee.getJoinYear()) * 12 +
					 currentDate.get(Calendar.MONTH) - currentEmployee.getJoinMonth();
			if (experienceMonths > 6) {
				currentEmployee.setVacation(experienceMonths * 2);
			}
		}
	}
}

class Employee {
	private String name;
	private String familyName;
	private long salary;
	private long account;
	private int joinYear;
	private int joinMonth;
	private int vacation;
	private boolean gender;

	private String department;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public long getSalary() {
		return salary;
	}
	
	public long giveSalary() {
		account += salary;
		return salary;
	}

	public void setSalary(long salary) {
		if (salary >= 0) {
			this.salary = salary;
		}
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		if (account >= 0) {
			this.account = account;
		}
	}

	public int getJoinYear() {
		return joinYear;
	}

	public void setJoinYear(int joinYear) {
		this.joinYear = joinYear;
	}

	public int getJoinMonth() {
		return joinMonth;
	}

	public void setJoinMonth(int joinMonth) {
		this.joinMonth = joinMonth;
	}

	public int getVacation() {
		return vacation;
	}

	public void setVacation(int vacation) {
		this.vacation = vacation;
	}
	
	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
