package Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomExceptiopn.EmployeeNotFoundException;
import CustomExceptiopn.InvaliedChoiseException;
import customSorting.SortEmployeeByAge;
import customSorting.SortEmployeeById;
import customSorting.SortEmployeeBySalary;
import customSorting.SortEmpoyeeByName;

public class EmployeeDataBasaManagemantSystemIMP implements EmployeeDataBasaManagemantSystem {
	Map<String, Employee> db = new LinkedHashMap<String, Employee>();
	Scanner r = new Scanner(System.in);

	@Override
	public void addEmployee() {
		System.out.println("enter the age of employee");
		int age = r.nextInt();
		System.out.println("enter the name of employee");
		String name = r.next();
		System.out.println("enter the salary of employee");
		double salary = r.nextDouble();
		Employee e = new Employee(age, name, salary);
		db.put(e.getId(), e);
		System.out.println("employee id: " + e.getId());

	}

	@Override
	public void displayEmployee() {
		System.out.println("enter the id of employee");
		String id = r.next().toUpperCase();
		if (db.containsKey(id)) {
			System.out.println(db.get(id));
		} else {
			try {
				String message = "employee details for id" + id + "not found";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayAllEmployee() {
		if (db.size() != 0) {
			Set<String> keys = db.keySet();
			for (String key : keys) {
				System.out.println(db.get(key));
			}

		} else {
			try {
				String message = "students database is empty,nothing to display";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeEmployee() {
		System.out.println("enter the id of employee");
		String id = r.next().toUpperCase();
		if (db.containsKey(id)) {
			db.remove(id);
			System.out.println("employee record deleted succesfully");
		} else {
			try {
				String message = "employee details for id" + id + "not found";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllEmployee() {
		if (db.size() != 0) {
			db.clear();
			System.out.println("employee records deleted succesfully");

		} else {
			try {
				String message = "employee details for are not found";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void updateEmployee() {
		System.out.println("enter the employee id");
		String id = r.next().toUpperCase();
		if (db.containsKey(id)) {
			Employee s = db.get(id);
			System.out.println("enter\n 1: update age\n 2 :update name\n 3:update salary");
			int choice = r.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the age to be updated");
				int age = r.nextInt();
				s.setAge(age);
				System.out.println("update succesfull");
				break;
			case 2:
				System.out.println("enter the name to be updated");
				String name = r.next();
				s.setName(name);
				System.out.println("update succesfull");
				break;
			case 3:
				System.out.println("enter the salary to be updated");
				int salary = r.nextInt();
				s.setAge(salary);
				System.out.println("update succesfull");
				break;
			default:
				try {
					throw new InvaliedChoiseException("invalied choice broooo....");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		} else {
			try {
				String message = "employee with ths id " + id + "not found";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void countEmployee() {
		System.out.println("total employee count :" + db.size());

	}

	@Override
	public void sortEmployee() {
		if (db.size() > 1) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for (String key : keys) {
				list.add(db.get(key));// adding student object into list
			}

			System.out.println("enter \n 1:sort by id\n 2:sort by name\n 3:sort by marks \n 4:sort by age");
			int choice = r.nextInt();
			switch (choice) {
			case 1:
				Collections.sort(list, new SortEmployeeById());
				display(list);
				break;
			case 2:
				Collections.sort(list, new SortEmpoyeeByName());
				display(list);

				break;
			case 3:
				Collections.sort(list, new SortEmployeeBySalary());
				display(list);

				break;
			case 4:
				Collections.sort(list, new SortEmployeeByAge());
				display(list);
				break;

			}
		} else {
			try {
				String message = "students database doesnot contain sufficient data to sort ";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private static void display(List<Employee> list) {
		for (Employee s : list) {
			System.out.println(s);
		}
	}

	@Override
	public void getEmployeeWithHighestSalary() {
		if (db.size() > 1) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for (String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(db.size() - 1));
		}

	}

	@Override
	public void getEmployeeWithLowestSalary() {
		if (db.size() > 1) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for (String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(0));
		}


	}

}
