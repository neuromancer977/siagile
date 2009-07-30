package code.lucamarrocco.scala.command


import java.text.MessageFormat._

class ScalaCommand {

  var homeDir: CommandPart = new CommandPart("", "")

  var options: List[CommandPart] = List()
  var sources: List[CommandPart] = List()

  var classpaths: Paths = new Paths("classpath")
  var sourcepaths: Paths = new Paths("sourcepath")
  var bootpaths: Paths = new Paths("bootpath")

  var extdirs: Paths = new Paths("extdirs")
  
  def noWarnings = option("nowarn")
  def verbose = option("verbose")
  def deprecated = option("deprecated")
  def unchecked = option("unchecked")
  def print = option("print")
  def optimize = option("optimize")
  def explaintypes = option("explaintypes")
  def uniqid = option("uniqid")
  def version = option("version")
  def help = option("help")
  def X = option("X")

  def debugging(name: String) = option(" -g:{0}", name)
  def target(name: String) = option(" -target:{0}", name)
  def encoding(name: String) = option(" -encoding {0}", name)
  def directory(name: String) = option(" -directory {0}", name)

  def classpath(path: String) = classpaths.append(path)
  def sourcepath(path: String) = sourcepaths.append(path)
  def bootpath(path: String) = bootpaths.append(path)

  def home(dir: String) = homeDir = new CommandPart("{0}/bin/", dir);

  def program(name: String) = new CommandPart("{0}", name);
  
  def extdir(dir: String) = extdirs.append(dir)

  def source(name: String) = {
    var part = new CommandPart(" {0}", name)
    sources = sources ::: List[CommandPart](part)
    this
  }
  
  def option(name: String): ScalaCommand = {
    option(" -{0}", name)
  }
  
  def option(pattern: String, name: String): ScalaCommand = {
    var part = new CommandPart(pattern, name)
    options = options ::: List[CommandPart](part)
    this
  }

  def build(): String = {
    val buildingCommand = new StringBuilder

    buildingCommand append homeDir
    buildingCommand append program("scalac")

    options.foreach(option => buildingCommand append option)
    buildingCommand append classpaths
    buildingCommand append sourcepaths
    buildingCommand append bootpaths
    buildingCommand append extdirs
    sources.foreach(source => buildingCommand append source)

    buildingCommand.toString().replaceAll("\\s+", " ").trim()
  }

}