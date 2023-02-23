package customSorting;

import java.util.Comparator;

import Employee.Employee;

public class SortEmpoyeeByName implements Comparator<Employee> {
	public int compare(Employee e1, Employee e2) {
		String x = e1.getName();
		String y = e2.getName();
		return x.compareTo(y);

	}

}
