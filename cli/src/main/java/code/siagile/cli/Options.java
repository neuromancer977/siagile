package code.siagile.cli;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Options {
	private final Set<Option> options = new HashSet<Option>();

	public void add(String option) {
		options.add(new Option(option));
	}

	public boolean hasOption(String option) {
		return options.contains(new Option(option.trim()));
	}

	public Integer size() {
		return options.size();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().
	       append(options).
	       toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		   if (obj == this) { return true; }
		   if (obj.getClass() != getClass()) {
		     return false;
		   }
		   Options rhs = (Options) obj;
		   return new EqualsBuilder()
		   					.append(options, rhs.options)
		   					.isEquals();

	}
}
