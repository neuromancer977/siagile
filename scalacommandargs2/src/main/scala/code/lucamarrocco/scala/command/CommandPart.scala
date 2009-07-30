package code.lucamarrocco.scala.command


import java.text.MessageFormat._

class CommandPart(pattern: String, value: String) {
  
  override def toString(): String = format(pattern, value)

}