package code.siagile.cli;

import org.junit.Test;

import code.siagile.cli.Command;
import code.siagile.cli.CommandBuilder;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;


public class CLITest {
	@Test
	public void testSimpleCommand() {
		Command cmd = new CommandBuilder("scalac").build();
		
		assertThat(cmd, is(equalTo(new Command("scalac"))));
	}
	
	@Test
	public void testSimpleCommandWithAOption() {
		Command cmd = new CommandBuilder("scalac").option("-verbose").build();
		
		assertThat(cmd.options().hasOption("-verbose"), is(true));
	}
	
	@Test
	public void testSimpleCommandWith2Option() {
		Command cmd = new CommandBuilder("scalac").option("-verbose").option("-version").build();
		
		assertThat(cmd.options().hasOption("-verbose"), is(true));
		assertThat(cmd.options().hasOption("-version"), is(true));
		assertThat(cmd.options().size(), is(equalTo(2)));
	}
	
	public void testSimpleCommandAddingNewOption() {
		Command cmd = new CommandBuilder("scalac").option("-verbose").option("-version").build();
		
		cmd.options().add("-anotheroptions"); // add a new option
		
		assertThat(cmd.options().hasOption("-verbose"), is(true));
		assertThat(cmd.options().hasOption("-version"), is(true));
		assertThat(cmd.options().hasOption("-anotheroptions"), is(true));
		assertThat(cmd.options().size(), is(equalTo(3)));
	}
	
	@Test
	public void testSimpleCommandDuplicateOption() {
		Command cmd = new CommandBuilder("scalac").option("-verbose").option("-verbose").build();
		
		assertThat(cmd.options().hasOption("-verbose"), is(true));
		assertThat(cmd.options().size(), is(equalTo(1)));
	}
	
	@Test
	public void testCompareSimpleCommandWithOption() {
		Command cmd = new CommandBuilder("scalac").option("-verbose").option("-version").build();
		Command cmd2 = new CommandBuilder("scalac").option("-verbose").option("-version").build();
		
		assertThat(cmd, is(equalTo(cmd2)));
	}
}
