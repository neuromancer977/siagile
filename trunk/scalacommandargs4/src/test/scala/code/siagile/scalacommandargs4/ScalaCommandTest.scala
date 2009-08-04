package code.siagile.scalacommandargs4


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

        var buildingCommand = new ScalaCommand

        buildingCommand version

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -version")))
    }

    @Test
    def nowarn = {

        var buildingCommand = new ScalaCommand

        buildingCommand nowarn

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -nowarn")))
    }

    @Test
    def verbose = {

        var buildingCommand = new ScalaCommand

        buildingCommand verbose

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -verbose")))
    }

    @Test
    def source = {

        var buildingCommand = new ScalaCommand

        buildingCommand source "Foo.scala"

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac Foo.scala")))
    }

    @Test
    def sources = {

        var buildingCommand = new ScalaCommand

        buildingCommand source "Foo.scala"

        buildingCommand source "Bar.scala"

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac Foo.scala Bar.scala")))
    }

    @Test
    def classpath = {

        var buildingCommand = new ScalaCommand

        buildingCommand classpath "cp1"

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -classpath cp1")))
    }

    @Test
    def classpaths = {

        var buildingCommand = new ScalaCommand

        buildingCommand classpath "cp1"

        buildingCommand classpath "cp2"

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -classpath cp1:cp2")))
    }

    @Test
    def bootpath = {

        var buildingCommand = new ScalaCommand

        buildingCommand bootpath "bp1"

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -bootpath bp1")))
    }

    @Test
    def bootpaths = {

        var buildingCommand = new ScalaCommand

        buildingCommand bootpath "bp1"

        buildingCommand bootpath "bp2"

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -bootpath bp1:bp2")))
    }

   @Test
    def sourcepath = {

        var buildingCommand = new ScalaCommand

        buildingCommand sourcepath "sp1"

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -sourcepath sp1")))
    }

    @Test
    def sourcepaths = {

        var buildingCommand = new ScalaCommand

        buildingCommand sourcepath "sp1"

        buildingCommand sourcepath "sp2"

        val command = buildingCommand build

        assertThat(command, is(equalTo("scalac -sourcepath sp1:sp2")))
    }
}
