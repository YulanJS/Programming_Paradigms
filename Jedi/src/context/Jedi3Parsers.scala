package context

import scala.util.parsing.combinator._
import expression._
import value._

class Jedi3Parsers extends Jedi2Parsers {
  
  // assignment ::= identifier ~ "=" ~ expression
  def assignment: Parser[Assignment] = identifier ~ "=" ~ expression ^^{
    case  id ~ equal ~ exp => Assignment(id,exp)
  }
  
  // iteration ::= "while" ~ "(" ~ expression ~ ")" ~ expression
  def iteration: Parser[Iteration] = "while" ~ "(" ~ expression ~ ")" ~ expression ^^{
    case  w  ~ lp ~ exp1 ~ rp ~ exp2 => Iteration(exp1, exp2)
  }
  
  // dereference ::= "[" ~ expression ~ "]"
  def dereference: Parser[Expression]= "[" ~ expression ~ "]" ^^{
    case "[" ~ exp ~ "]" =>  FunCall(Identifier("dereference"), exp::Nil)
  }
  
  // SWITCH ::= "switch" ~ EXPRESSION ~ "{" ~ EXPRESSION ~ rep(";" ~ EXPRESSION) ~ "}"
  /*
  def switch: Parser[Switch] = "switch" ~ expression ~ "{" ~ expression ~ rep(";" ~> expression) ~ "}" ^^ = 
  {
    case "switch" ~ expr1 ~ "{" ~ expr2 ~ Nil ~ "}" => Switch(expr1, )
    case "switch" ~ expr1 ~ "{" ~ expr2 ~ more ~ "}" => Switch(expr1)
  }
  */
  
  override def expression: Parser[Expression] = declaration | conditional | iteration | disjunction | failure("Invalid expression")
  override def term: Parser[Expression]  = lambda | funCall | block | assignment | dereference | literal | "("~>expression<~")"
}