package code.lucamarrocco.scala.command

import java.io._
import org.junit._
import org.junit.Assert._
import org.hamcrest.Matchers._

class ParsingScalaCompilerTest {

  @Test
  def failure1() = {
    val output = """src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala:9: error: not found: value assertThat
                     |                        assertThat(command, is equalTo "")
                     |                        ^
                     |one error found""".stripMargin;

    val compilerError = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors(0)
      
    assertThat(compilerError pathname, is(equalTo("src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala")))
    assertThat(compilerError line, is(equalTo("9")))
    assertThat(compilerError message, is(equalTo("not found: value assertThat")))
    assertThat(compilerError start, is(equalTo(24)))
  }

  @Test
  def failure2() = {
    val output = """src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala:10: error: package command is not a value
                    |			assertThat(command, is equalTo "")
                    |                      ^
                    |one error found""".stripMargin;

    val compilerError = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors(0)
      
    assertThat(compilerError pathname, is(equalTo("src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala")))
    assertThat(compilerError line, is(equalTo("10")))
    assertThat(compilerError message, is(equalTo("package command is not a value")))
    assertThat(compilerError start, is(equalTo(22)))
  }

  @Test
  def failure3() = {
    val output = """src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala:14: error: ambiguous reference to overloaded definition,
                    |both method is in object Matchers of type (java.lang.Class[_])org.hamcrest.Matcher[java.lang.Object]
                    |and  method is in object Matchers of type [T](org.hamcrest.Matcher[T])org.hamcrest.Matcher[T]
                    |match expected type ?
                    |                        assertThat(command, is equalTo "")
                    |                                            ^
                    |one error found""".stripMargin;

    val compilerError = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors(0)
      
    assertThat(compilerError pathname, is(equalTo("src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala")))
    assertThat(compilerError line, is(equalTo("14")))
    assertThat(compilerError message, is(equalTo("ambiguous reference to overloaded definition,")))
    assertThat(compilerError start, is(equalTo(44)))
  }

  @Test
  def failure4() = {
    val output = """src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala:14: error: ')' expected but string literal found.
                   |			assertThat(command, is(equalTo ""))
                   |                                                       ^
                   |src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala:15: error: ')' expected but '}' found.
                   |	}
                   |        ^
                   |two errors found""".stripMargin;

  
    val compilerErrors = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors
      
    assertThat(compilerErrors(0) pathname, is(equalTo("src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala")))
    assertThat(compilerErrors(0) line, is(equalTo("14")))
    assertThat(compilerErrors(0) message, is(equalTo("')' expected but string literal found.")))
    assertThat(compilerErrors(0) start, is(equalTo(55)))
      
    assertThat(compilerErrors(1) pathname, is(equalTo("src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala")))
    assertThat(compilerErrors(1) line, is(equalTo("15")))
    assertThat(compilerErrors(1) message, is(equalTo("')' expected but '}' found.")))
    assertThat(compilerErrors(1) start, is(equalTo(8)))
  }
  
  @Test
  def failure5() = {
    val output = """src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala:4: error: expected start of definition
                   |  override toString(): String = ""
                   |           ^
                   |one error found""".stripMargin

    val compilerError = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors(0)
      
    assertThat(compilerError pathname, is(equalTo("src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala")))
    assertThat(compilerError line, is(equalTo("4")))
    assertThat(compilerError message, is(equalTo("expected start of definition")))
    assertThat(compilerError start, is(equalTo(11)))
  }
  
  @Test
  def failure6() = {
    val output = """src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala:24: error: value source is not a member of code.lucamarrocco.scala.command.ScalaCommand
                   |      buildingCommand source "Foo.scala"
                   |                      ^
                   |one error found""".stripMargin

    val compilerError = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors(0)
      
    assertThat(compilerError pathname, is(equalTo("src/test/scala/code/lucamarrocco/scala/command/ScalaCommandTest.scala")))
    assertThat(compilerError line, is(equalTo("24")))
    assertThat(compilerError message, is(equalTo("value source is not a member of code.lucamarrocco.scala.command.ScalaCommand")))
    assertThat(compilerError start, is(equalTo(22)))
  }
  
  @Test
  def failure7() = {
    val output = """src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala:5: error: class List is abstract; cannot be instantiated
                   |  val sources: List[String] = new List()
                   |                              ^
                   |src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala:7: error: value :: is not a member of String
                   |  def source(name: String) = sources :: name
                   |                                     ^
                   |src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala:10: error: object String is not a value
                   |    String = "scalac"
                   |    ^
                   |three errors found""".stripMargin

  
    val compilerErrors = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors
      
    assertThat(compilerErrors(0) pathname, is(equalTo("src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala")))
    assertThat(compilerErrors(0) line, is(equalTo("5")))
    assertThat(compilerErrors(0) message, is(equalTo("class List is abstract; cannot be instantiated")))
    assertThat(compilerErrors(0) start, is(equalTo(30)))
      
    assertThat(compilerErrors(1) pathname, is(equalTo("src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala")))
    assertThat(compilerErrors(1) line, is(equalTo("7")))
    assertThat(compilerErrors(1) message, is(equalTo("value :: is not a member of String")))
    assertThat(compilerErrors(1) start, is(equalTo(37)))
      
    assertThat(compilerErrors(2) pathname, is(equalTo("src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala")))
    assertThat(compilerErrors(2) line, is(equalTo("10")))
    assertThat(compilerErrors(2) message, is(equalTo("object String is not a value")))
    assertThat(compilerErrors(2) start, is(equalTo(4)))
  }
  
  @Test
  def failure8() = {
    val output = """src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala:18: error: missing arguments for method clean in class ScalaCommand;
                   |follow this method with `_' if you want to treat it as a partially applied function
                   |    clean buildingCommand toString
                   |    ^
                   |one error found""".stripMargin

    val compilerError = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors(0)
      
    assertThat(compilerError pathname, is(equalTo("src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala")))
    assertThat(compilerError line, is(equalTo("18")))
    assertThat(compilerError message, is(equalTo("missing arguments for method clean in class ScalaCommand;")))
    assertThat(compilerError start, is(equalTo(4)))
  }
  
  @Test
  def failure9() = {
    val output = """src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala:18: error: not found: value buildingCommant
                   |    var result: String = buildingCommant toString
                   |                         ^
                   |src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala:20: error: type mismatch;
                   | found   : Unit
                   | required: String
                   |    result = result.replaceAll("\\s+", " ")
                   |           ^
                   |two errors found""".stripMargin

    val compilerError = new ParsingScalaCompiler(new ByteArrayInputStream(output.getBytes())) errors(0)
      
    assertThat(compilerError pathname, is(equalTo("src/main/scala/code/lucamarrocco/scala/command/ScalaCommand.scala")))
    assertThat(compilerError line, is(equalTo("18")))
    assertThat(compilerError message, is(equalTo("not found: value buildingCommant")))
    assertThat(compilerError start, is(equalTo(25)))
  }
  
}