package code.siagile.cli;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Command {

	private final String cmd;
	private Options options = new Options();

	public Command(String cmd) {
		this.cmd = cmd;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().
	       append(cmd).
//	       append(options).
	       toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		   if (obj == this) { return true; }
		   if (obj.getClass() != getClass()) {
		     return false;
		   }
		   Command rhs = (Command) obj;
		   return new EqualsBuilder()
		                 	.append(cmd, rhs.cmd)
		   					.append(options, rhs.options)
		                 	.isEquals();

	}

	public Options options() {
		return options ;
	}

	public void options(Options options) {
		this.options = options;
	}

}
