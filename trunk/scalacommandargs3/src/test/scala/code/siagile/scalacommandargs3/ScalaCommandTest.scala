package code.siagile.scalacommandargs3

import org.junit._
import org.junit.Assert._
import org.hamcrest.Matchers._

class ScalaCommandTest {

  @Test
  def scalac = {

    val buildingCommand = new ScalaCommand

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac")))
  }

  @Test
  def version = {

    val buildingCommand = new ScalaCommand

    buildingCommand version

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -version")))
  }

  @Test
  def nowarn = {

    val buildingCommand = new ScalaCommand

    buildingCommand nowarn

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -nowarn")))
  }

  @Test
  def versionAndNowarn = {

    val buildingCommand = new ScalaCommand

    buildingCommand version

    buildingCommand nowarn

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -version -nowarn")))
  }

  @Test
  def options = {

    assertThat(new ScalaCommand().nowarn().build(), is(equalTo("scalac -nowarn")))
    assertThat(new ScalaCommand().verbose().build(), is(equalTo("scalac -verbose")))
    assertThat(new ScalaCommand().deprecation().build(), is(equalTo("scalac -deprecation")))
    assertThat(new ScalaCommand().unchecked().build(), is(equalTo("scalac -unchecked")))
    assertThat(new ScalaCommand().print().build(), is(equalTo("scalac -print")))
    assertThat(new ScalaCommand().optimise().build(), is(equalTo("scalac -optimise")))
    assertThat(new ScalaCommand().explaintypes().build(), is(equalTo("scalac -explaintypes")))
    assertThat(new ScalaCommand().uniqid().build(), is(equalTo("scalac -uniqid")))
    assertThat(new ScalaCommand().version().build(), is(equalTo("scalac -version")))
    assertThat(new ScalaCommand().help().build(), is(equalTo("scalac -help")))
    assertThat(new ScalaCommand().X().build(), is(equalTo("scalac -X")))
  }

  @Test
  def source = {

    val buildingCommand = new ScalaCommand

    buildingCommand source "Foo.scala"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac Foo.scala")))
  }

  @Test
  def sources = {

    val buildingCommand = new ScalaCommand

    buildingCommand source "Foo.scala"

    buildingCommand source "Bar.scala"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac Foo.scala Bar.scala")))
  }

  @Test
  def classpath = {

    val buildingCommand = new ScalaCommand

    buildingCommand classpath "cp1"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -classpath cp1")))
  }

  @Test
  def classpaths = {

    val buildingCommand = new ScalaCommand

    buildingCommand classpath "cp1"

    buildingCommand classpath "cp2"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -classpath cp1:cp2")))
  }

  @Test
  def bootpath = {

    val buildingCommand = new ScalaCommand

    buildingCommand bootpath "bp1"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -bootpath bp1")))
  }

  @Test
  def bootpaths = {

    val buildingCommand = new ScalaCommand

    buildingCommand bootpath "bp1"

    buildingCommand bootpath "bp2"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -bootpath bp1:bp2")))
  }

  @Test
  def sourcepath = {

    val buildingCommand = new ScalaCommand

    buildingCommand sourcepath "sp1"

    val command = buildingCommand build

    assertThat(command, is(equalTo("scalac -sourcepath sp1")))
  }
}
