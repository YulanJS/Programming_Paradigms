object beta {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  trait Expression
  
	case class Number(val value: Int) extends Expression
	
	case class Sum(val operand1: Expression, val operand2: Expression) extends Expression
	
	case class Product(val operand1: Expression, val operand2: Expression) extends Expression
	case class Identifier(val name: String) extends Expression

  class Environment extends collection.mutable.HashMap[String, Int]
  
  def execute(exp: Expression, env: Environment): Int =
  //use match with unapply()
  //use recursion to execute sub expressions
  	exp match{
  		case Sum(op1, op2) => execute(op1, env) + execute(op2, env)
  		case Product(op1, op2) => execute(op1, env) * execute(op2, env)
  		case Identifier(name) => env(name)
  		case Number(v) => v
  		case _ => throw new Exception("unrecognized expression")
  	}                                         //> execute: (exp: beta.Expression, env: beta.Environment)Int
  
  
  
  val globalEnv = new Environment                 //> globalEnv  : beta.Environment = Map()
  globalEnv("x") = 22
  globalEnv("y") = 33

   val id1 = Identifier("x")                      //> id1  : beta.Identifier = Identifier(x)

   val id2 = Identifier("y")                      //> id2  : beta.Identifier = Identifier(y)



   val sum1 = Sum(id1, Number(10))                //> sum1  : beta.Sum = Sum(Identifier(x),Number(10))

   execute(sum1, globalEnv)                       //> res0: Int = 32

   val prod1 = Product(sum1, id2)                 //> prod1  : beta.Product = Product(Sum(Identifier(x),Number(10)),Identifier(y)
                                                  //| )
   execute(prod1, globalEnv)                      //> res1: Int = 1056
}