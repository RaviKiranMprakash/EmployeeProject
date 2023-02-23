package customSorting;

import java.util.Comparator;

import Employee.Employee;

public class SortEmployeeBySalary implements Comparator<Employee>{
	public int compare(Employee e1,Employee e2) {
		Double x=e1.getSalary();
		Double y=e2.getSalary();
		return x.compareTo(y);
		
		
	}

}
