package code.siagile.greetings;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.junit.matchers.IsCollectionContaining.*;

import org.junit.*;

public class SplittedStringsTest {

	@Test
	public void testSplitEployees() {
		String EMPLOYESS = "Doe, John, 1982/10/08, jonh.doe@foobar.com\nDoe, Alice, 1976/10/08, alice.doe@foobar.com";

		Iterable<String> splittedStrings = new SplittedStrings(EMPLOYESS);

		assertThat(splittedStrings, hasItem("Doe, John, 1982/10/08, jonh.doe@foobar.com"));
		assertThat(splittedStrings, hasItem("Doe, Alice, 1976/10/08, alice.doe@foobar.com"));
	}

	@Test
	public void testStringSplitByEndLine() {
		assertThat(new SplittedStrings("a\nb"), hasItems("a", "b"));
	}

	@Test
	public void testStringSplitSingleLineReturnLineItSelf() {
		assertThat(new SplittedStrings("").iterator().hasNext(), is(false));
		assertThat(new SplittedStrings("\n").iterator().hasNext(), is(false));
	}
}