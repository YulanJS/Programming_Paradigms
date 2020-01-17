package SOP_Parser2_0
import scala.util.parsing.combinator._

class SOPParsers2 extends RegexParsers 
{ 
  def expression: Parser[Expression] = sum | product | number 
  
  def sum: Parser[Sum] = product ~ opt("+" ~ sum) ^^ {
    case p ~ None => Sum(p) 
    case p ~ Some("+" ~ s) => Sum(p, s) 
  } 
  
  def product: Parser[Product] = term ~ rep("*" ~> term) ^^ { 
    case t ~ Nil => Product(t, Nil) 
    case t ~ terms => Product(t, terms) 
  } 
  
  def term: Parser[Expression] = number | "(" ~> expression <~ ")" 
  
  def number: Parser[Number] = """0|[1-9][0-9]*(\.[0-9]+)?""".r ^^ { 
    case num => Number(num.toDouble) 
  } 
}