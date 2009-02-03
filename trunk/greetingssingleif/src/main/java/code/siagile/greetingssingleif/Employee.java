package code.siagile.greetingssingleif;


public class Employee {

	private StringBuilder stringBuider = new StringBuilder();

	public Employee(String firstName, String lastName, String birthDay, String email) {
		append(firstName).append(",");
		append(lastName).append(",");
		append(birthDay).append(",");
		append(email);
	}

	private Employee append(String string) {
		stringBuider.append(string);
		return this;
	}

	@Override
	public String toString() {
		return stringBuider.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return stringBuider.toString().equals(obj.toString());
	}

}
