package code.siagile.scalacommandargs7

import org.junit._
import org.junit.Assert._
import org.hamcrest.Matchers._

import java.text.MessageFormat._
import scala.collection.mutable.HashMap

class ScalaCommandTest {
  @Test
  def scalac() {

    val buildingCommand = new ScalaCommand()

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac")))
  }

  @Test
  def scalacVersion() {

    val buildingCommand = new ScalaCommand()

    buildingCommand version;

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -version")))
  }

  @Test
  def scalacVerbose() {

    val buildingCommand = new ScalaCommand()

    buildingCommand verbose;

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -verbose")))
  }


  @Test
  def scalacVersionVerbose() {

    val buildingCommand = new ScalaCommand()

    buildingCommand version;
    buildingCommand verbose;

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -version -verbose")))
  }


  @Test
  def scalacSource() {

    val buildingCommand = new ScalaCommand()

    buildingCommand source "Foo.scala"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac Foo.scala")))
  }


  @Test
  def scalacClasspath() {

    val buildingCommand = new ScalaCommand()

    buildingCommand classpath "cp1"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -classpath cp1")))
  }

  @Test
  def scalacBootpath() {

    val buildingCommand = new ScalaCommand()

    buildingCommand bootpath "bp1"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -bootpath bp1")))
  }

}