package code.siagile.greetings3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.hamcrest.Matcher;

public class EmployeesReader {

	public String read(InputStream employeesStream) {
		StringBuilder out = new StringBuilder();
		try {
			byte[] b = new byte[4096];
			for (int n; (n = employeesStream.read(b)) != -1;) {
				out.append(new String(b, 0, n));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}

	public void scan(String readedEmployees, Employeer employeer) {
		Scanner scanner = new Scanner(readedEmployees).useDelimiter("\n");

		while (scanner.hasNext()) {
			employeer.employ(scanner.next());
		}
	}

}
