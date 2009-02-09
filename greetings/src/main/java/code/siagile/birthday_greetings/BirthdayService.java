package code.siagile.birthday_greetings;

import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;


public class BirthdayService {

	public void sendGreetings(String fileName, OurDate ourDate,
			String host, int port)  {
		
		List<Employee> employees = repository(fileName)
									.findAll(bornOn(ourDate));
		new SmtpSender(host, port).send(employees);
	}

	private FileEmployeeRepository repository(String fileName) {
		return new FileEmployeeRepository(fileName);
	}

	private BornOn bornOn(OurDate ourDate) {
		return new BornOn(ourDate);
	}
	
	private class BornOn extends BaseMatcher<Employee>{

		OurDate ourDate;
		public BornOn(OurDate ourDate) {
			this.ourDate = ourDate;
		}

		public boolean matches(Object e) {
			return ((Employee)e).isBirthday(ourDate);
		}

		public void describeTo(Description description) {
			description.appendText("She's not born in ").appendText(ourDate.toString());
		}
	}


	public static void main(String[] args) {
		BirthdayService service = new BirthdayService();
		try {
			service.sendGreetings("employee_data.txt",
					new OurDate("2008/10/08"), "localhost", 25);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
