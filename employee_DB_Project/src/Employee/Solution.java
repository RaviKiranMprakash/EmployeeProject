package Employee;

import java.util.Scanner;

import CustomExceptiopn.InvaliedChoiseException;



public class Solution {

	public static void main(String[] args) {
		System.out.println("welcome to employee database");
		Scanner r=new Scanner(System.in);
		EmployeeDataBasaManagemantSystem ems=new EmployeeDataBasaManagemantSystemIMP();
		
		while(true) {
			System.out.println(
					"1:add employee\n2:didplay employee\n3:display all employees\n4:remove employee\n5:remove all employees\n6:update employee\n7:count employee\n8:sort employee\n9:get employee with highest salary\n10:get employee by lowest salary\n11:exit");
			System.out.println("enter your choice");
			
			int choice = r.nextInt();
			switch (choice) {
			case 1:
				ems.addEmployee();
				break;
			case 2:
				ems.displayEmployee();
				break;
			case 3:
				ems.displayAllEmployee();
				break;
			case 4:
				ems.removeEmployee();
				break;
			case 5:
				ems.removeAllEmployee();
				break;
			case 6:
				ems.updateEmployee();
				break;
			case 7:
				ems.countEmployee();
				break;
			case 8:
				ems.sortEmployee();
				break;
			case 9:
				ems.getEmployeeWithHighestSalary();
				break;
			case 10:
				ems.getEmployeeWithLowestSalary();
				break;
			case 11:
				System.out.println("thank you...");
				System.exit(0);
				break;
			default:
				try {
					throw new InvaliedChoiseException("invalied choice broooo....");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}

}
