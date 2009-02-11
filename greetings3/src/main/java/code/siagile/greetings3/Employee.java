package code.siagile.greetings3;

public class Employee {

	private String birthDay;

	private final String firstName;

	private final String email;

	public Employee(String firstName, String lastName, String birthDay,
			String email) {

		this.firstName = firstName;
		this.email = email;
		this.birthDay = removeYearFrom(birthDay);
	}

	public Message happyBirthDay() {
		return new Message("Happy birthday " + firstName + "!", email);
	}

	private String removeYearFrom(String anotherDate) {
		return anotherDate.trim().replaceAll("\\d\\d\\d\\d$", "");
	}

	public boolean wasBorn(String anotherDate) {
		return removeYearFrom(anotherDate).equals(birthDay);
	}

}
