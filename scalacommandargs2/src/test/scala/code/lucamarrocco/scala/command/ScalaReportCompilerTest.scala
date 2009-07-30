package code.lucamarrocco.scala.command

import org.junit._
import org.junit.Assert._
import org.hamcrest.Matchers._
import java.io._

class ScalaReportCompilerTest {

  class PrintlnScalaCompilerReporter extends ScalaCompilerReporter{
    override def report(error: ScalaCompilerError) = println(error)
  }
  
  @Test
  def runningScalaVersion() {
    val command = new ScalaCommand

    command home "/opt/scala-2.7.5.final"
    command version

    val reporter = new PrintlnScalaCompilerReporter
    
    new ScalaReportCompiler(command, reporter)
  }

}