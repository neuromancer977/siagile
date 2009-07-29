package code.siagile.commandargs


class CommandBuilder {
   var tokens: List[Option] = List()
   
   var pOption = new String
   
   var pSource = new String
  
   def buildCommand = {
       val buildingCommand = new StringBuilder
       
       buildingCommand append "scalac"
       tokens.foreach(token => buildingCommand append token)
       buildingCommand append " "
       buildingCommand append pSource

       var command = buildingCommand toString

       command = command trim
       
       command replaceAll("\\s+", " ")
   }
   
   def source(name: String) = pSource = name
   
   def noWarnings = option("nowarn")
   def beVerbose = option("verbose")
   
   def option(name: String) = {
       val option = new Option(name)
       tokens = tokens ::: List[Option](option)
   }
}