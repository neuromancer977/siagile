package code.siagile.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BirthdayService {

	public void sendGreetings(String fileName, OurDate ourDate,
			String smtpHost, int smtpPort) throws IOException, ParseException, AddressException, MessagingException {
		Sender sender = new SmtpSender(smtpHost, smtpPort);
		EmployeeRepository repository = new FileEmployeeRepository(fileName);
		List<Employee> employees = repository.findAllBornOn(ourDate);
		for (Employee employee : employees) {
			IMessage greetingsMessage = new GreetingMessage(employee);
			sender.send(greetingsMessage);
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
