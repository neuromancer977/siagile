package code.siagile.cli;

public class CommandBuilder {

	private final String command;
	private final Options options = new Options();;

	public CommandBuilder(String command) {
		this.command = command.trim();
	}

	public Command build() {
		Command cmd = new Command(command);
		cmd.options(options);
		return cmd;
	}

	public CommandBuilder option(String option) {
		options.add(option.trim());
		return this;
	}

}
