object alpha {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //expression ::= Int
  //Why must have val?
  case class Exp(val arg1: Int, val op: Char, val arg2: Int)
  
  //companion object apply() calls the constructor
  val exp1 = Exp(3, '+', 4)                       //> exp1  : alpha.Exp = Exp(3,+,4)
  val exp2 = Exp(9, '*', 9)                       //> exp2  : alpha.Exp = Exp(9,*,9)
  
  //unapply()
  def execute(exp: Exp) =
  	exp match{
  		case Exp(a1, '+', a2) => a1 + a2
  		case Exp(a1, '*', a2) => a1 * a2
  		case _=> throw new Exception("Unrecognized operator")
  	}                                         //> execute: (exp: alpha.Exp)Int
  	
  execute(exp1)                                   //> res0: Int = 7
  execute(exp2)                                   //> res1: Int = 81
  
}