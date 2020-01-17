

object Acorn extends App {
  abstract class Expression { def execute: Double }
  
  class Sum(private val operand1: Expression, private val operand2: Expression) extends Expression 
  { 
    def execute = operand1.execute + operand2.execute 
    override def toString = "(+ " + operand1 + " " + operand2 + ")" 
  }
  
  object Sum { 
    def apply(operand1: Expression, operand2: Expression) = new Sum(operand1, operand2) }
  
   class Product(private val operand1: Expression, private val operand2: Expression) extends Expression 
  { 
    def execute = operand1.execute * operand2.execute 
    override def toString = "(* " + operand1 + " " + operand2 + ")" 
  }
  
  object Product { def apply(operand1: Expression, operand2: Expression) = new Product(operand1, operand2)}
  
  class Number(private val value: Double) extends Expression 
  { 
    def execute = value 
    override def toString = value.toString
  }
  
  object Number { 
    def apply(num: Double) = new Number(num) }

  
  var exp: Expression = Sum(Number(42), Product(Number(3.14), Number(2.71)))
  println("the value of " + exp + " = " + exp.execute) 
  exp = Product(Number(2), Product(Number(3), Number(5))) 
  println("the value of " + exp + " = " + exp.execute)
  
  /*
  the value of (+ 42.0 (* 3.14 2.71)) = 50.5094
	the value of (* 2.0 (* 3.0 5.0)) = 30.0 
   */
 
}