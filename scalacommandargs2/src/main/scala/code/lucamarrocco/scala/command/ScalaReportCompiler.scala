package code.lucamarrocco.scala.command


import java.io.InputStream

class ScalaReportCompiler(command: ScalaCommand, reporter: ScalaCompilerReporter) {
  
  private def output(command: ScalaCommand) = new ScalaRunner(command).output

  private def errorsIn(output: InputStream): List[ScalaCompilerError] = new ParsingScalaCompiler(output).errors
  
  errorsIn(output(command)).foreach(error => reporter report error)
}
    
