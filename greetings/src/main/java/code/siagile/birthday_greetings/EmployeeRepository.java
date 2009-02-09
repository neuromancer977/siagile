package code.siagile.birthday_greetings;

import java.util.List;

import org.hamcrest.Matcher;

public interface EmployeeRepository {

	List<Employee> findAll(Matcher<Employee> bornOn);

}
