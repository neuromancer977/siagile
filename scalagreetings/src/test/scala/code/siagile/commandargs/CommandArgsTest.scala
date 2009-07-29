package code.siagile.commandargs

import org.junit._
import org.junit.Assert._
import org.hamcrest.Matchers._

class CommandArgsTest {
	
    @Test
    def scalac = {
      
        val commandBuilder = new CommandBuilder
      
        val command = commandBuilder buildCommand
      
        assertThat(command, is(equalTo("scalac")))
    }
	
    @Test
    def source = {
      
        val commandBuilder = new CommandBuilder
        
        commandBuilder source "Foo.scala"
      
        val command = commandBuilder buildCommand
      
        assertThat(command, is(equalTo("scalac Foo.scala")))
    }
	
    @Test
    def nowarn = {
      
        val commandBuilder = new CommandBuilder
        
        commandBuilder noWarnings
      
        val command = commandBuilder buildCommand
      
        assertThat(command, is(equalTo("scalac -nowarn")))
    }
	
    @Test
    def verbose = {
      
        val commandBuilder = new CommandBuilder
        
        commandBuilder beVerbose
      
        val command = commandBuilder buildCommand
      
        assertThat(command, is(equalTo("scalac -verbose")))
    }
}
