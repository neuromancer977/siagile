package code.siagile.birthday_greetings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.hamcrest.Matcher;

public class FileEmployeeRepository implements EmployeeRepository {

	private String fileName;

	public FileEmployeeRepository(String fileName) {
		this.fileName = fileName;
	}

	public List<Employee> findAll(Matcher<Employee> matcher) {
		List<Employee> employees = new LinkedList<Employee>();
		Scanner scanner = scanner();
		scanner.nextLine();
		while(scanner.hasNextLine()){
			Employee employee = readEmployee(scanner.nextLine());
			if (matcher.matches(employee)) {
				employees.add(employee);
			}
		}
		return employees;
	}

	private Scanner scanner()  {
		try {
			return new Scanner(new FileReader(fileName)).useDelimiter("\n");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private Employee readEmployee(String str){
		String[] employeeData = str.split(", ");
		Employee employee = new Employee(
				employeeData[1], employeeData[0],
				employeeData[2], employeeData[3]);
		return employee;
	}
}
