package code.siagile.birthday_greetings;

public class GreetingMessage implements IMessage {

	Employee employee;

	public GreetingMessage(Employee employee) {
		this.employee = employee;
	}
	public String receiver() {
		return this.employee.getEmail();
	}
	public String body() {
		return "Happy Birthday, dear %NAME%!".replace("%NAME%",this.employee.getFirstName());
	}
	public String subject() {
		return  "Happy Birthday!";
	}

}
