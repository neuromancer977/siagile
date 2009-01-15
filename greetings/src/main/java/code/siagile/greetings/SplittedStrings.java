package code.siagile.greetings;

import java.util.*;

public class SplittedStrings implements Iterable<String> {
	private List<String> splittedStrings = new LinkedList<String>();

	public SplittedStrings(String strings) {
		Scanner scanner = new Scanner(strings).useDelimiter("\n");

		while (scanner.hasNext())
			splittedStrings.add(scanner.next());
	}

	public Iterator<String> iterator() {
		return splittedStrings.iterator();
	}
}
