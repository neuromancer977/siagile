package code.siagile.scalacommandargs7


import java.text.MessageFormat._
import scala.collection.mutable.LinkedHashMap

class CommandPart(pattern: String, value: String) {
  private var parts: List[CommandPart] = List()

  def isEmpty(parts: List[CommandPart]) = false

  def prefix(buildingString: StringBuilder): Unit = {
     if(isEmpty(parts)) return
     buildingString append format(pattern, value)
  }

  def proceed(buildingString: StringBuilder, parts: List[CommandPart]) = {
     parts.reverse.foreach(part => buildingString append part)
  }
  
  override def toString(): String = {
    val buildingString = new StringBuilder
    prefix(buildingString)
    proceed(buildingString, parts)
    buildingString toString
  }

  def ::(part: CommandPart) = {
    parts = part :: parts
    this
  }
}

class Option(value: String) extends CommandPart(" -{0}", value)
class Source(value: String) extends CommandPart(" {0}", value)
class Program(value: String) extends CommandPart("{0}", value)
class Path(value: String) extends CommandPart(" {0}", value)
class Paths(name: String) extends CommandPart(" -{0}", name) {
  override def isEmpty(parts: List[CommandPart]) = parts.isEmpty
}
class Sources(name: String) extends CommandPart(" -{0}", name) {
  override def prefix(buildingString: StringBuilder) = buildingString append ""
}
class Options(name: String) extends CommandPart(" -{0}", name) {
  override def prefix(buildingString: StringBuilder) = buildingString append ""
}

class ScalaCommand {

  var parts: LinkedHashMap[String, CommandPart] = new LinkedHashMap[String, CommandPart]()

  parts += "program" -> new Program("scalac")
  parts += "options" -> new Options("options")
  parts += "classpaths" -> new Paths("classpath")
  parts += "bootpaths" -> new Paths("bootpath")
  parts += "sources" -> new Sources("sources")

  private def option(option: String) = new Option(option) :: parts("options")
  private def paths(name: String, path: String) = new Path(path) :: parts(name)

  def version = option("version")
  def verbose = option("verbose")
  def source(name: String) = new Source(name) :: parts("sources")
  def classpath(path: String) = paths("classpaths", path)
  def bootpath(path: String) = paths("bootpaths", path)

  def build = {
    val buildingString = new StringBuilder()
    parts.values.foreach(path => buildingString append path)
    buildingString.toString()
  }
}
