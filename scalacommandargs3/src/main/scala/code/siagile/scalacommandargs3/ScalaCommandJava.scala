package code.siagile.scalacommandargs3


import java.text.MessageFormat._
import scala.collection.mutable.HashMap


class CommandPart(pattern: String, name: String) {
  var parts: List[CommandPart] = List()
  def add(part: CommandPart) = parts = parts ::: List(part)
  override def toString(): String = {
    if(empty(parts)) return ""

    val buildingString = new StringBuilder
    buildingString append format(pattern, name)
    parts.foreach(part => buildingString append part)

    var string = buildingString toString

    string = string replaceAll(separator() + "$", "")
    string
  }
  def empty(parts: List[CommandPart]) = false
  def separator(): String = ""
}

class Options() extends CommandPart("", "")
class Option(name: String) extends CommandPart(" -{0}", name)
class Source(name: String) extends CommandPart(" {0}", name)
class Path(name: String) extends CommandPart("{0}:", name)
class Paths(name: String) extends CommandPart(" -{0} ", name) {
  override def empty(parts: List[CommandPart]) = parts isEmpty
  override def separator(): String = ":"
}

class Classpath(name: String) extends CommandPart(" -classpath {0}", name)

class ScalaCommand {

  var options: List[CommandPart] = List()
  var parts: HashMap[String, CommandPart] = new HashMap[String, CommandPart]()

  parts += "options" -> new Options()
  parts += "classpath" -> new Paths("classpath")
  parts += "bootpath" -> new Paths("bootpath")
  parts += "sourcepath" -> new Paths("sourcepath")

  def build() = {

    var buildingCommand = new StringBuilder

    buildingCommand append "scalac"
    parts.foreach{ case(name, part) => buildingCommand append part}

    buildingCommand toString
  }

  private def adding(part: CommandPart) = options = options ::: List[CommandPart](part)

  def option(name: String) = {
    part("options").add(new Option(name))
    this
  }

  def nowarn() = option("nowarn")
  def verbose() = option("verbose")
  def deprecation() = option("deprecation")
  def unchecked() = option("unchecked")
  def print() = option("print")
  def optimise() = option("optimise")
  def explaintypes() = option("explaintypes")
  def uniqid() = option("uniqid")
  def version() = option("version")
  def help() = option("help")
  def X() = option("X")

  def source(name: String) = {
    part("options").add(new Source(name))
    this
  }

  private def part(name: String): CommandPart = parts(name)

  def classpath(name: String) = {
    part("classpath").add(new Path(name))
    this
  }

  def bootpath(name: String) = {
    part("bootpath").add(new Path(name))
    this
  }

  def sourcepath(name: String) = {
    part("sourcepath").add(new Path(name))
    this
  }

}
