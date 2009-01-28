package code.siagile.birthday_greetings;

public class GreetingMessage implements IMessage {

	Employee employee;

	public GreetingMessage(Employee employee) {
		this.employee = employee;
	}
	public String getReceiver() {
		return this.employee.getEmail();
	}
	public String getBody() {
		return "Happy Birthday, dear %NAME%!".replace("%NAME%",this.employee.getFirstName());
	}
	public String getSubject() {
		return  "Happy Birthday!";
	}

}
