package OOP.homework8;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
//import java.util.GregorianCalendar;

/**
 * На фирме должны работать следующие сотрудники:
 Классы Firm, Employee, Manager, SalesManager 
 - Обычный сотрудник
 - Фамилия
 - Имя
 - Отчество
 - Пол
 - Дата рождения
 - Ставка зарплаты
 - Зарплатный счет
 - Стаж
 - Дни отпуска
 - Дата последнего отпуска
 - Отдел
 - получение размера зарплаты, метод double getSalary()
 Менеджер (отдел, подчиненные, зп + по 50 за подчененного),
 Продавец (продажи, зп + 30% от продаж)

 Фирма:
 - сотрудники
 - счет
 - вывести всех сотрудников на экран, метод void printAllEmployees()
 - вывести всех сотрудников, отсортированных по зп, 
 метод void printAllEmployeesSortedBySalary()
 - вывести всех сотрудников, отсортированных по фамилии, 
 метод void printAllEmployeesSortedBySName()
 - всем продавцам продать на сумму 10000, метод void sellFor10()
 - выдать всем зарплату (если не хватает, выдать сколько есть, 
 метод void giveSalaryForAll())
 - пересчитать всем отпуска (после 6 мес, по 2 дня в месяц, метод void calcVocations())
 - поднять жалование на 10% всем сотрудникам со стажем > 5 лет, метод void riseSalary()
 -* выдать праздничный бонус 20% (если сегодня 8 марта - женщинам,
 если 23 февраля мужчинам)
 -* сокращение - уволить всех со стажем < 6 мес и нечетной
 датой рождения, зарплату увольняемого разделить между
 всеми коллегами по отделу
 -* нанять сотрудника, снять с зарплаты сотрудников отдела зарплату для новичка
 -* после любой изменяющей операции сохранять фирму в файл

 */

public class Firm {
	
	public static void main (String[] args) {
		Firm firm = new Firm();
		
		firm.addEmployees(new Employee("Петр", "Петрович", "Петров", 1));
		firm.addEmployees(new Employee("Иван", "Иваныч", "Иванов", 1));
		firm.addEmployees(new Employee("Сидор", "Сидорович", "Сидоров", 1));
//		firm.employees.get(0).setBirthDate(Calendar.getInstance());
		
		
//		firm.employees.get(0).setHireDate(Calendar.getInstance());
		
		firm.employees.get(0).setSalary(10); 
		firm.employees.get(1).setSalary(20); 
		firm.employees.get(2).setSalary(15);
		
		firm.printAllEmployees();
		firm.printAllEmployeesSortedBySalary();
		firm.printAllEmployeesSortedBySName();
	}
	
	private String name;
	private String address;
	private int account;
	public ArrayList <Employee> employees = new ArrayList <Employee>();
	
	public Firm () {
	
	}
	
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
	
	public void setAccount(int account) {
		this.account = account;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployees(Employee employee) {
		this.employees.add(employee);
	}
	
	public void printAllEmployees() {
		outputEmployees(this.employees);
	}

	public void printAllEmployeesSortedBySalary() {
		ArrayList<Employee> employeesToSort = 
				new ArrayList<Employee>(this.employees);
		Collections.sort(employeesToSort);
		outputEmployees(employeesToSort);
	}

	public void printAllEmployeesSortedBySName() {
		
		// ***************************************
		// здесь можно использовать компаратор! 
		//
		// ***************************************
		
		class EmployeeToSortByName extends Employee {
			public EmployeeToSortByName (Employee employee) {
				super();
				this.setName(employee.getName());
				this.setSecondName(employee.getSecondName());
				this.setFamilyName(employee.getFamilyName());
				this.setGender(employee.getGender());
				this.setBirthDate(employee.getBirthDate());
				this.setSalary(employee.getSalary());
				this.setSalaryAccount(employee.getSalaryAccount());
				this.setHireDate(employee.getHireDate());
				this.setVacationDays(employee.getVacationDays());
				this.setLastVacationDate(employee.getLastVacationDate());
				this.setDepartment(employee.getDepartment());
			}
			
			@Override
			public int compareTo(Employee employee) {
				return this.getFamilyName().compareTo(employee.getFamilyName());
			}
		}
		
		ArrayList<Employee> employeesToSortByName = new ArrayList<Employee>();
		
		for (Employee employee: this.employees) {
			employeesToSortByName.add(new EmployeeToSortByName(employee));
		}
		
		Collections.sort(employeesToSortByName);
		outputEmployees(employeesToSortByName);

	}
	
	private void outputEmployees(ArrayList<Employee> employees) {
		for (Employee employee : employees) {
			employee.print();
		}
		System.out.println();
	}

	public void giveSalaryForAll() {
		for (Employee employee: this.employees) {
			account -= employee.giveSalary();
			if (account <= 0) {
				break;
			}
		}
	}
	
	public void sellFor10() {
		for (Employee employee: this.employees) {
			if(employee instanceof SalesManager) {
				((SalesManager) employee).sell(10000);
			}
		}
	}
	
	public void calcVocations() {
		Calendar currentDate = Calendar.getInstance();
		for (Employee currentEmployee: this.employees) {
			int experienceMonths = 
					(currentDate.get(Calendar.YEAR) 
					- currentEmployee.getHireDate().get(Calendar.YEAR)) * 12 
					+ currentDate.get(Calendar.MONTH) 
					- currentEmployee.getHireDate().get(Calendar.MONTH);
			
			if (experienceMonths > 6) {
				currentEmployee.setVacationDays(experienceMonths * 2);
			}
		}
	}
	
	public void riseSalary() {
		Calendar currentDate = Calendar.getInstance();
		for (Employee currentEmployee: this.employees) {
			int experienceYears = 
					(currentDate.get(Calendar.YEAR) 
					- currentEmployee.getHireDate().get(Calendar.YEAR));
			
			if (experienceYears > 5) {
				currentEmployee.setSalary((int)(currentEmployee.getSalary() * 1.1));
			}
		}

	}

}

class Manager extends Employee {
	private ArrayList <Employee> employees = new ArrayList <Employee> ();
	private int managementFee;
	
	public Manager() {
		super();
	}
	
	public Manager(String name, String secondName, String familyName,
			int gender, String department) {
		super(name, secondName, familyName, gender);
		employees = new ArrayList <Employee> ();
		setDepartment(department);
	}
	
	@Override
	public double giveSalary() {
		return giveSalary(getSalary());
	}
	
	@Override
	public double giveSalary(double salary) {
		double managerSalary = salary + managementFee * employees.size();
		setSalaryAccount(getSalaryAccount() + managerSalary);
		return managerSalary;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print(String.format("Has %d employees: ", employees.size()));
		for(Employee employee: employees) {
			System.out.print(employee.getFamilyName() + " ");
		}
		System.out.print("\n");
	}

	public int getManagementFee() {
		return managementFee;
	}

	public void setManagementFee(int managementFee) {
		if(managementFee >= 0) {
			this.managementFee = managementFee;
		}
	}

}

class SalesManager extends Employee {
	private double salesFee;
	private double sales; 
	
	@Override
	public double giveSalary() {
		return giveSalary(getSalary());
	}
	
	@Override
	public double giveSalary(double salary) {
		double salesSalary = salary + (salesFee * sales);
		setSalaryAccount(getSalaryAccount() + salesSalary);
		sales = 0;
		return salesSalary;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print(String.format("Gets %d percent from sales. \n", 
				(int)(salesFee * 100)));
	}
	
	public int sell(int sum) {
		sales += sum;
		return sum;
	}
	
	public double getSalesFee() {
		return salesFee;
	}

	public void setSalesFee(double salesFee) {
		if (salesFee <= 0.0) {
			this.salesFee = 0.0;
		} else if (salesFee >= 1) {	
			this.salesFee = 1;
		} else {
			this.salesFee = salesFee;
		}
	}

	public double getSales() {
		return sales;
	}

	public void setSales(int sales) {
		if (sales >= 0) {
			this.sales = sales;
		}
	}
	
}

class Employee implements Comparable <Employee>{
	private String name;
	private String secondName;
	private String familyName;
	private int gender; // 0: female, 1: male
	private Calendar birthDate;
	private double salary;
	private double salaryAccount;
	private Calendar hireDate;
	private int vacationDays;
	private Calendar lastVacationDate;
	private String department;
	
	public Employee() {
		
	}
	
	public Employee(String name, String secondName, String familyName,
			int gender) {
		this();
		setName(name);
		setSecondName(secondName);
		setFamilyName(familyName);
		setGender(gender);
	}
		
	public int compareTo(Employee employee) {
		return (int)(this.getSalary() - employee.getSalary());
	}
	
	public void print() {
		System.out.print(String.format(
				"%s %s %s, %s, born on %tF, hired on %tF, earns %.2f, works in %s\n", 
				getFamilyName(), 
				getName(), 
				getSecondName(), 
				getGender() == 0 ? "female" : "male",
				getBirthDate(),
				getHireDate(),
				getSalary(), 
				getDepartment()
				));
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary >= 0) {
			this.salary = salary;
		}
	}
	
	public double giveSalary() {
		return giveSalary(getSalary());
	}
	
	public double giveSalary(double salary) {
		setSalaryAccount(getSalaryAccount() + salary);
		return salary;
	}

	public double getSalaryAccount() {
		return salaryAccount;
	}

	public void setSalaryAccount(double salaryAccount) {
		if (salaryAccount >= 0) {
			this.salaryAccount = salaryAccount;
		}
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	public Calendar getLastVacationDate() {
		return lastVacationDate;
	}

	public void setLastVacationDate(Calendar lastVacationDate) {
		this.lastVacationDate = lastVacationDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}