package code.siagile.scalacommandargs5;

public class ScalaCommand {

	private String option = "";

	private String option2 = "";

	public String build() {
		return "scalac" + option + option2;
	}

	public void version() {
		option = " -version";
	}

	public void verbose() {
		option2 = " -verbose";
	}

}
