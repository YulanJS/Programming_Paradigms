package context

import scala.util.parsing.combinator._
import expression._
import value._

/*
 * Notes:
 * disjunction reduces to conjunction reduces to equality ... reduces to term
 * if A reduces to B, then B will have higher precedence than A
 * Example: sum reduces to product, so a + b * c = a + (b * c)
 * Had to make some big corrections to numeral regex
 * This could probably have been a singleton
 */

class Jedi1Parsers extends RegexParsers {
   
   def expression: Parser[Expression] = declaration | conditional | disjunction | failure("Invalid expression")
 
   def declaration: Parser[Declaration] = "def" ~ identifier ~ "=" ~ expression ^^ {
     case "def"~id~"="~exp => Declaration(id, exp)
   }
   
   def conditional: Parser[Conditional] = "if" ~ "(" ~ expression ~ ")" ~ expression ~ opt("else" ~ expression) ^^ {
     //two steps: tree to expression
     case "if"~"("~cond~")"~cons~None => Conditional(cond, cons)
     case "if"~"("~cond~")"~cons~Some("else"~alt) => Conditional(cond, cons, alt)
   }
   
   //disjunction contains conjunction, so String => Expression instead of String => Disjunction
   // ~> check the type to fit the format, but make sure it is not included in the tree
   // String => tree =>(by transformer: case...) expression
   def disjunction: Parser[Expression] = conjunction ~ rep("||" ~> conjunction) ^^ {
     case con ~ Nil => con
     case con ~ more => Disjunction(con::more)
   }
   
   // conjunction ::= equality ~ ("&&" ~ equality)*
   def conjunction: Parser[Expression] = equality ~ rep("&&" ~> equality) ^^ {
     case equ ~ Nil => equ
     case equ ~ more => Conjunction(equ::more)
   }
   
   // equality ::= inequality ~ ("==" ~ inequality)*
   def equality: Parser[Expression] = inequality ~ rep("==" ~> inequality) ^^ {
     case inEqu ~ Nil => inEqu
     //I guess the function of '~>': ignore "==" and make a List[inequality]
     case inEqu ~ more => FunCall(Identifier("equals"),inEqu::more)
   }
   
   // inequality ::= sum ~ (("<" | ">" | "!=") ~ sum)?
   def inequality: Parser[Expression] = sum ~ opt(("<" | ">" | "!=") ~ sum) ^^ {
     case sum ~ None => sum
     //sum::more doesn't work, more is not tail because it is not a List
     //List(sum, more) two elements
     case sum ~ Some("<" ~ more) => FunCall(Identifier("less"),List(sum,more))
     case sum ~ Some(">" ~ more) => FunCall(Identifier("more"),List(sum,more))
     case sum ~ Some("!=" ~ more) => FunCall(Identifier("unequals"),List(sum,more))
   }
   // 

   
  // negate(exp) = 0 - exp
  private def negate(exp: Expression): Expression = {
    val sub = Identifier("sub")
    val zero = Integer(0)
    FunCall(sub, List(zero, exp))
  }
    
  // 2 + 3 parses to add(2, 3)
  // sum ::= product ~ ("+" | "-") ~ product)*  
  // part inside rep has different situations
  def sum: Parser[Expression] = product ~ rep(("+"|"-") ~ product ^^ {
    //it acts on the part inside rep( this part )
    //change -a to +(0 - a) to satisfy associativity
    case "+"~s=>s
    case "-"~s=> negate(s)
    //part can be subtraction
    })^^{
    case p~Nil=> p
    case p~rest=>FunCall(Identifier("add"), p::rest)
    //but the whole thing is addition of parts, do this to facilitate associativity
    }
    
 // product ::= term ~ (("*" | "/") ~ term)*
  def product: Parser[Expression] = term ~ rep(("*"|"/") ~ term) ^^ {
     case (t ~ blah) => parseProduct(t, blah)
     //blah: a List[Str~Exp]
  }
  
  // generates left-to-right calls to mul and div: //recursively
  private  def parseProduct(t: Expression, terms: List[~[String,Expression]]): Expression = {
     terms match {
       case Nil => t
       //~[Str,Exp] equivalent to Str~Exp //anything inside rep becomes List[anything]
       //List equiv to head::tail
       //recursive
       //calculate t * t1 by funcall, and deal with remaining items
       case ~("*", t1)::more => parseProduct(FunCall(Identifier("mul"), List(t, t1)), more)
       case ~("/", t1)::more => parseProduct(FunCall(Identifier("div"), List(t, t1)), more)
     }
 }
      
 //"("~>expression<~")": ignore parenthesis to focus on inside: ex: 3 * (2 + 3)
 //"( )" parse later, higher precedence
 def term: Parser[Expression]  = funCall | literal | "("~>expression<~")"
   
 def literal = boole | real | integer | chars | identifier
   

 // chars ::= any characters bracketed by quotes
 //matches regex, return string, deal with " " around quotes
 //""" """.r regex objects 
 // "\\+" equivalent to """\+""": the system cannot recognize \+
 def chars: Parser[Chars] = """\"[^"]+\"""".r ^^ {
     //" " erase front and back quotes
     case characters => Chars(characters.substring(1, characters.length - 1))
 }
 
 // integer ::= 0|(\+|-)?[1-9][0-9]*
 def integer: Parser[Integer] = """0|(\+|-)?[1-9][0-9]*""".r ^^ {
   case num => Integer(num.toInt)
   //toInt or not...
 }
 
 // real ::= (\+|-)?[0-9]+\.[0-9]+
 def real: Parser[Real] = """(\+|-)?[0-9]+\.[0-9]+""".r ^^
 {
   case num => Real(num.toDouble)
 }
 // boole ::= true | false
 // !!Be careful of the form here
 def boole: Parser[Boole] = ("true" | "false") ^^
 {
   case "true" => Boole(true)
   case "false" => Boole(false)
 }

 // identifier ::= [a-zA-Z][a-zA-Z0-9]*
 def identifier: Parser[Identifier] = """[a-zA-Z][a-zA-Z0-9]*""".r ^^{
   case i => Identifier(i)
 }
 
 // funCall ::= identifier ~ operands
 def funCall: Parser[FunCall] = identifier ~ operands ^^{
   case id~op => FunCall(id, op)
 }

 // operands ::= "(" ~ (expression ~ ("," ~ expression)*)? ~ ")"
 def operands: Parser[List[Expression]] = "(" ~ opt(expression ~ rep("," ~> expression)) ~ ")" ^^{
   case "(" ~ None ~ ")" => Nil
   case "(" ~ Some(exp ~ Nil) ~ ")" => List(exp)
   case "(" ~ Some(exp ~ more) ~ ")" => exp::more
 }
}
