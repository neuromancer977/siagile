package code.lucamarrocco.scala.command


import java.io.InputStream

class ScalaRunner(buildingCommand: ScalaCommand) {
  
  def output = {
    var command = buildingCommand build
    
    try {
        val runtime = Runtime.getRuntime()
	    val p = runtime.exec(command)
	    val exitStatus = p.waitFor()
	    p.getErrorStream()
    }
    catch {
      case e: Exception => throw new RuntimeException("unable to run " + command, e)
    }
  }
  
}
