package code.siagile.birthday_greetings;

import java.util.List;

public interface EmployeeRepository {

	List<Employee> findAllBornOn(OurDate ourDate);

}
