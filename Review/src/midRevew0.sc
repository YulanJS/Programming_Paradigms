object midRevew0 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def loopWhile[T](test: T => Boolean, update: T => T): T=> T =
  {
  	def r(x: T): T =
  	{
  		var y = update(x)
  		while(!test(y))
  		{
  			y = update(y)
  		}
  		y
  	}
  	r _
  }                                               //> loopWhile: [T](test: T => Boolean, update: T => T)T => T
  
  
  
  val f = loopWhile((x: Int) => x < 7, (x: Int) => x + 2)
                                                  //> f  : Int => Int = midRevew0$$$Lambda$10/757108857@58ceff1
  f(1)                                            //> res0: Int = 3
  f(2)                                            //> res1: Int = 4
  f(3)                                            //> res2: Int = 5
  f(4)                                            //> res3: Int = 6
  f(5)                                            //> res4: Int = -2147483647
  f(6)                                            //> res5: Int = -2147483648
 
  
  def isPrime(n: Int) = {
		var result = if (n < 2) false else true
		for(m <- 2 to n/2 if result) result = (n % m != 0)
		result
	}                                         //> isPrime: (n: Int)Boolean
  
  def nextPrime(n: Int): Int =
  {
  	loopWhile(isPrime _, (x: Int) => x + 1)(n)
  }                                               //> nextPrime: (n: Int)Int
  isPrime(8)                                      //> res6: Boolean = false
  
  nextPrime(8)                                    //> res7: Int = 11
  nextPrime(122)                                  //> res8: Int = 127
  
  trait Command {def oper(): Double}
  class Add(operand1: Double, operand2: Double) extends Command
  {
  	def oper() = operand1 + operand2
  }
  object Add {def apply(num1: Double, num2: Double) = new Add(num1, num2)}
  class Mul(operand1: Double, operand2: Double) extends Command
  {
  	def oper() = operand1 * operand2
  }
  object Mul {def apply(num1: Double, num2: Double) = new Mul(num1, num2)}
  def execute(program: List[Command]): List[Double] =
  {
  	program.map(_.oper)
  }                                               //> execute: (program: List[midRevew0.Command])List[Double]
  execute(List(Add(2.0, 3.1), Mul(4.0, 5.0), Add(2.7, 9.0)))
                                                  //> res9: List[Double] = List(5.1, 20.0, 11.7)
  def countRoots[T](f: T=>Double, inputs: List[T]): Int =
  {
  	inputs.map(f).filter((x: Double)=> x == 0.0).size
  }                                               //> countRoots: [T](f: T => Double, inputs: List[T])Int
  countRoots((x: Double) => (x - 2.0) * (x - 3.0), List(1.0, 2.0, 3.0, 4.0))
                                                  //> res10: Int = 2

}