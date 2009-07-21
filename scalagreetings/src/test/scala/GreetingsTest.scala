import org.junit._
import org.junit.Assert._
import org.hamcrest.Matchers._

class GreetingsTest {

    @Test
		def testString() = {
        var s = ""
				assertThat(s, is(equalTo("")))
		}
	
}
