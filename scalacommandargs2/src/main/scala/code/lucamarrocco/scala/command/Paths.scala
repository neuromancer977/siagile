package code.lucamarrocco.scala.command


import java.text.MessageFormat._

class Paths(name: String) extends CommandPart(" -{0}", name) {

  var paths: List[CommandPart] = List()

  override def toString(): String = {
    if(paths.isEmpty) return ""

    val buildingString = new StringBuilder
    buildingString append super.toString()
    buildingString append " "
    paths.foreach(path => buildingString append path)

    buildingString.toString().replaceAll("\\s+", " ").replaceAll(":$", "")
  }

  def append(path: String): Unit = {
    var part = new CommandPart("{0}:", path)
    paths = paths ::: List[CommandPart](part)
  }

}