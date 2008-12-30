package code.siagile.dojo.cases;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hamcrest.*;
import org.junit.*;

/** @author Luca Marrocco */
public class CamelCaseTest {
	public static void assertThatAsCamelCase(String string, Matcher<String> match) {
		String resultFromBad = BadCamelCase.asCamelCase(string);
		String resultFromGood = GoodCamelCase.asCamelCase(string);
		assertThat(resultFromBad, is(equalTo(resultFromGood)));
		assertThat(resultFromBad, match);
		assertThat(resultFromGood, match);
	}

	@Test
	public void testConvertSomeStringsToCamelCase() {
		assertThatAsCamelCase("word", is(equalTo("word")));
        assertThatAsCamelCase("word word", is(equalTo("wordWord")));
        assertThatAsCamelCase("word word 1", is(equalTo("wordWord1")));
        assertThatAsCamelCase("word word +!@#$%^1&*()))(*&^%$#}{|\"", is(equalTo("wordWord1")));
	}
}
