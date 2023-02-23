package customSorting;

import java.util.Comparator;

import Employee.Employee;

public class SortEmployeeByAge implements Comparator<Employee> {
	public int compare(Employee e1,Employee e2) {
		Integer x=e1.getAge();
		Integer y=e2.getAge();
		return x.compareTo(y);
		
	}

}
