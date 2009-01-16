package code.siagile.greetings.fixture;

import code.siagile.greetings.*;
import fit.*;

public class MailBoxFixture extends ColumnFixture {
	public static final MailBox mailBox = new MailBox();

	public String email;

	public boolean hasReceived() {
		return mailBoxContains(email);
	}

	public boolean mailBoxContains(String string) {
		for (Mail email : mailBox)
			if (email.toString().equals(string)) return true;
		return false;
	}

}
