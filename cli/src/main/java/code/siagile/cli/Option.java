package code.siagile.cli;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Option {

	private final String option;

	public Option(String option) {
		this.option = option;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().
	       append(option).
	       toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		   if (obj == this) { return true; }
		   if (obj.getClass() != getClass()) {
		     return false;
		   }
		   Option rhs = (Option) obj;
		   return new EqualsBuilder()
		   					.append(option, rhs.option)
		   					.isEquals();

	}
	
}
