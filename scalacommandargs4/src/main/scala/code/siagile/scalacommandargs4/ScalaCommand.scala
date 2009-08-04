package code.siagile.scalacommandargs4

import java.text.MessageFormat._
import scala.collection.mutable.HashMap
import scala.collection.mutable.LinkedHashMap


class CommandPart(pattern: String, value: String) {
    override def toString(): String = format(pattern, value)
}

class CommandParts(name: String, separator: String) {

    var parts: List[CommandPart] = List()

    def adding(part: CommandPart) = parts = part :: parts

    override def toString(): String = {
        if(empty(parts)) return ""

        val buildingString = new StringBuilder
        prefix(buildingString, name)
        proceed(buildingString, parts, separator)
        buildingString toString
    }

    def empty(parts: List[CommandPart]) = parts isEmpty
    def prefix(buildingString: StringBuilder, name: String) = buildingString append format(" -{0} ", name)
    def proceed(buildingString: StringBuilder, parts: List[CommandPart], separator: String) = {
        parts.reverse.foreach {
            part =>
            buildingString append part
            buildingString append separator
        }
    }
}

class Options extends CommandParts("options", " ") {
    override def prefix(buildingString: StringBuilder, name: String) = buildingString append format(" ", "")
}

class Name(name: String) extends CommandParts(name, " ") {
    override def empty(parts: List[CommandPart]) = false
    override def prefix(buildingString: StringBuilder, name: String) = buildingString append format("{0}", name)
}

class Paths(name: String) extends CommandParts(name, ":") {

}

class Sources(name: String) extends CommandParts(name, " ") {
    override def prefix(buildingString: StringBuilder, name: String) = buildingString append format(" ", "")
}

class ScalaCommand {

    var parts: LinkedHashMap[String, CommandParts] = new LinkedHashMap[String, CommandParts]()

    parts += "scalac" -> new Name("scalac");
    parts += "options" -> new Options()
    parts += "bootpath" -> new Paths("bootpath")
    parts += "classpath" -> new Paths("classpath")
    parts += "sourcepath" -> new Paths("sourcepath")
    parts += "sources" -> new Sources("sources")

    private def option(name: String) = parts("options").adding(new CommandPart("-{0} ", name))

    def source(name: String) = parts("sources").adding(new CommandPart("{0}", name))

    def nowarn() = option("nowarn")
    def verbose() = option("verbose")
    def version() = option("version")

    def classpath(name: String) = parts("classpath").adding(new CommandPart("{0}", name))
    def bootpath(name: String) = parts("bootpath").adding(new CommandPart("{0}", name))
    def sourcepath(name: String) = parts("sourcepath").adding(new CommandPart("{0}", name))

    def build = {

        val buildingString = new StringBuilder

        parts.values.foreach(part => buildingString append part)

        var result = buildingString toString

        result = result.replaceAll(":$", "")

        result trim
    }
}