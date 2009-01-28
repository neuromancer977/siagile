package code.siagile.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeRepository implements EmployeeRepository {

	private String fileName;

	public FileEmployeeRepository(String fileName) {
		this.fileName = fileName;
	}

	public List<Employee> findAllBornOn(OurDate ourDate) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			BufferedReader in = readBuffer(); 
			String line = in.readLine();
			while ((line = in.readLine()) != null) {
				Employee employee = readEmployee(line);
				if (employee.isBirthday(ourDate)) {
					employees.add(employee);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return employees;
	}

	private BufferedReader readBuffer() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return in;
	}
	private Employee readEmployee(String str){
		String[] employeeData = str.split(", ");
		Employee employee = new Employee(employeeData[1], employeeData[0],
				employeeData[2], employeeData[3]);
		return employee;
	}

}
