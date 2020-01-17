object alpha {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet")
  
  //expression ::= Int
  //Why must have val?
  case class Exp(val arg1: Int, val op: Char, val arg2: Int);$skip(192); 
  
  //companion object apply() calls the constructor
  val exp1 = Exp(3, '+', 4);System.out.println("""exp1  : alpha.Exp = """ + $show(exp1 ));$skip(28); 
  val exp2 = Exp(9, '*', 9);System.out.println("""exp2  : alpha.Exp = """ + $show(exp2 ));$skip(194); 
  
  //unapply()
  def execute(exp: Exp) =
  	exp match{
  		case Exp(a1, '+', a2) => a1 + a2
  		case Exp(a1, '*', a2) => a1 * a2
  		case _=> throw new Exception("Unrecognized operator")
  	};System.out.println("""execute: (exp: alpha.Exp)Int""");$skip(20); val res$0 = 
  	
  execute(exp1);System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
  execute(exp2);System.out.println("""res1: Int = """ + $show(res$1))}
  
}
