package code.siagile.scalacommandargs5;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class ScalaCommandTest {
	@Test
	public void testScalac() {

		final ScalaCommand buildingCommand = new ScalaCommand();

		final String command = buildingCommand.build();

		assertThat(command, is(equalTo("scalac")));
	}

	@Test
	public void testScalacVersion() {

		final ScalaCommand buildingCommand = new ScalaCommand();

		buildingCommand.version();

		final String command = buildingCommand.build();

		assertThat(command, is(equalTo("scalac -version")));
	}

	@Test
	public void testScalacVerbose() {

		final ScalaCommand buildingCommand = new ScalaCommand();

		buildingCommand.verbose();

		final String command = buildingCommand.build();

		assertThat(command, is(equalTo("scalac -verbose")));
	}


	@Test
	public void testScalacSource() {

		final ScalaCommand buildingCommand = new ScalaCommand();

		buildingCommand.source("Foo.scala");

		final String command = buildingCommand.build();

		assertThat(command, is(equalTo("scalac Foo.scala")));
	}
}
