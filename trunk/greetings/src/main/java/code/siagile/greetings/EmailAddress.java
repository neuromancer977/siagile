package code.siagile.greetings;

public class EmailAddress {

	private String email = "";

	public void email(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		EmailAddress anotherEmailAddress = (EmailAddress) obj;
		return email.equals(anotherEmailAddress.email);
	}

	@Override
	public String toString() {
		return email;
	}

}
