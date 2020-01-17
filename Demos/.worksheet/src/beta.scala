object beta {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet")
  
  trait Expression
  
	case class Number(val value: Int) extends Expression
	
	case class Sum(val operand1: Expression, val operand2: Expression) extends Expression
	
	case class Product(val operand1: Expression, val operand2: Expression) extends Expression
	case class Identifier(val name: String) extends Expression

  class Environment extends collection.mutable.HashMap[String, Int];$skip(798); 
  
  def execute(exp: Expression, env: Environment): Int =
  //use match with unapply()
  //use recursion to execute sub expressions
  	exp match{
  		case Sum(op1, op2) => execute(op1, env) + execute(op2, env)
  		case Product(op1, op2) => execute(op1, env) * execute(op2, env)
  		case Identifier(name) => env(name)
  		case Number(v) => v
  		case _ => throw new Exception("unrecognized expression")
  	};System.out.println("""execute: (exp: beta.Expression, env: beta.Environment)Int""");$skip(43); 
  
  
  
  val globalEnv = new Environment;System.out.println("""globalEnv  : beta.Environment = """ + $show(globalEnv ));$skip(22); 
  globalEnv("x") = 22;$skip(22); 
  globalEnv("y") = 33;$skip(30); 

   val id1 = Identifier("x");System.out.println("""id1  : beta.Identifier = """ + $show(id1 ));$skip(30); 

   val id2 = Identifier("y");System.out.println("""id2  : beta.Identifier = """ + $show(id2 ));$skip(38); 



   val sum1 = Sum(id1, Number(10));System.out.println("""sum1  : beta.Sum = """ + $show(sum1 ));$skip(29); val res$0 = 

   execute(sum1, globalEnv);System.out.println("""res0: Int = """ + $show(res$0));$skip(35); 

   val prod1 = Product(sum1, id2);System.out.println("""prod1  : beta.Product = """ + $show(prod1 ));$skip(29); val res$1 = 
   execute(prod1, globalEnv);System.out.println("""res1: Int = """ + $show(res$1))}
}
