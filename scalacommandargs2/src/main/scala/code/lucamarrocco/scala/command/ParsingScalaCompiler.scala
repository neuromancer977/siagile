package code.lucamarrocco.scala.command


import java.io.InputStream
import java.util.Scanner
import java.text.MessageFormat._

class ParsingScalaCompiler(stream: InputStream) {
    
    var errors: List[ScalaCompilerError] = List()
    
    private var error: ScalaCompilerError = new ScalaCompilerError
    
    private val scanning = new Scanner(stream).useDelimiter("\n");
    
	proceed(scanning)
    
    private def proceed(scanning: Scanner): Unit = {
    
      if(scanning hasNext) {
        var string = scanning next

        if(string contains ": error:") {
          adding(newError)
          parseMessage(string)
        }
        
        if(string contains "^") {
          parseStart(string)
        }

        proceed(scanning)
      }
    }
    
    private def adding(error: ScalaCompilerError) = errors = errors ::: List[ScalaCompilerError](error)

    private def newError = {
      error = new ScalaCompilerError
      error
    }
    
    private def parseMessage(string: String) = {
      error.pathname = string.replaceAll(":.*$", "").trim
      error.message = string.replaceAll("^.*error:", "").trim
      error.line = string.replaceAll("^[^:]*:", "").replaceAll(":.*$", "").trim
    }

    private def parseStart(string: String) = {
      error.start = string indexOf "^"
    }
}