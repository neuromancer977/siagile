package code.lucamarrocco.scala.command

import org.junit._
import org.junit.Assert._
import org.hamcrest.Matchers._

class ScalaCommandTest {

    var buildingCommand = new ScalaCommand
    
    @Before
    def setUp = {
        
      buildingCommand = new ScalaCommand
      
    }
    
	@Test
	def scalac = {

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac")))
	}

	@Test
	def source = {

      buildingCommand source "Foo.scala"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac Foo.scala")))
	}

	@Test
	def sources = {

      buildingCommand source "Foo.scala"
      buildingCommand source "Bar.scala"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac Foo.scala Bar.scala")))
	}

	@Test
	def nowarn = {

      buildingCommand noWarnings

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -nowarn")))
	}

	@Test
	def verbose = {

      buildingCommand verbose

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -verbose")))
	}

	@Test
	def deprecated = {

      buildingCommand deprecated

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -deprecated")))
	}

	@Test
	def unchecked = {

      buildingCommand unchecked

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -unchecked")))
	}


	@Test
	def print = {

      buildingCommand print

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -print")))
	}

	@Test
	def optimize = {

      buildingCommand optimize

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -optimize")))
	}

	@Test
	def explaintypes = {

      buildingCommand explaintypes

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -explaintypes")))
	}

	@Test
	def uniqid = {

      buildingCommand uniqid

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -uniqid")))
	}

	@Test
	def version = {

      buildingCommand version

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -version")))
	}

	@Test
	def help = {

      buildingCommand help

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -help")))
	}

	@Test
	def X = {

      buildingCommand X

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -X")))
	}

	@Test
	def debugging$none = {

      buildingCommand debugging "none"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -g:none")))
	}

	@Test
	def debugging$source = {

      buildingCommand debugging "source"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -g:source")))
	}

	@Test
	def debugging$line = {

      buildingCommand debugging "line"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -g:line")))
	}

	@Test
	def debugging$vars = {

      buildingCommand debugging "vars"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -g:vars")))
	}

	@Test
	def debugging$notailcalls = {

      buildingCommand debugging "notailcalls"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -g:notailcalls")))
	}

	@Test
	def target$jvm15 = {

      buildingCommand target "jvm-1.5"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -target:jvm-1.5")))
	}

	@Test
	def target$jvm14 = {

      buildingCommand target "jvm-1.4"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -target:jvm-1.4")))
	}

	@Test
	def target$msil = {

      buildingCommand target "msil"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -target:msil")))
	}

	@Test
	def encoding = {

      buildingCommand encoding "UTF-8"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -encoding UTF-8")))
	}

	@Test
	def directory = {

      buildingCommand directory "target"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -directory target")))
	}

	@Test
	def classpath = {

      buildingCommand classpath "cp1"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -classpath cp1")))
	}

	@Test
	def classpaths = {

      buildingCommand classpath "cp1"
      buildingCommand classpath "cp2"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -classpath cp1:cp2")))
	}

	@Test
	def bootpath = {

      buildingCommand bootpath "bp1"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -bootpath bp1")))
	}

	@Test
	def bootpaths = {

      buildingCommand bootpath "bp1"
      buildingCommand bootpath "bp2"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -bootpath bp1:bp2")))
	}

	@Test
	def sourcepath = {

      buildingCommand sourcepath "sp1"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -sourcepath sp1")))
	}

	@Test
	def sourcepaths = {

      buildingCommand sourcepath "sp1"
      buildingCommand sourcepath "sp2"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -sourcepath sp1:sp2")))
	}

	@Test
	def extdir = {

      buildingCommand extdir "ed1"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -extdirs ed1")))
	}

	@Test
	def extdirs = {

      buildingCommand extdir "ed1"
      buildingCommand extdir "ed2"

      val command = buildingCommand build

      assertThat(command, is(equalTo("scalac -extdirs ed1:ed2")))
        }

	@Test
	def home = {

      buildingCommand home "/opt/scala-2.7.5.final"

      val command = buildingCommand build

      assertThat(command, is(equalTo("/opt/scala-2.7.5.final/bin/scalac")))
	}
}