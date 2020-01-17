object midRevew0 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(191); 
  
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
  };System.out.println("""loopWhile: [T](test: T => Boolean, update: T => T)T => T""");$skip(68); 
  
  
  
  val f = loopWhile((x: Int) => x < 7, (x: Int) => x + 2);System.out.println("""f  : Int => Int = """ + $show(f ));$skip(7); val res$0 = 
  f(1);System.out.println("""res0: Int = """ + $show(res$0));$skip(7); val res$1 = 
  f(2);System.out.println("""res1: Int = """ + $show(res$1));$skip(7); val res$2 = 
  f(3);System.out.println("""res2: Int = """ + $show(res$2));$skip(7); val res$3 = 
  f(4);System.out.println("""res3: Int = """ + $show(res$3));$skip(7); val res$4 = 
  f(5);System.out.println("""res4: Int = """ + $show(res$4));$skip(7); val res$5 = 
  f(6);System.out.println("""res5: Int = """ + $show(res$5));$skip(138); 
 
  
  def isPrime(n: Int) = {
		var result = if (n < 2) false else true
		for(m <- 2 to n/2 if result) result = (n % m != 0)
		result
	};System.out.println("""isPrime: (n: Int)Boolean""");$skip(88); 
  
  def nextPrime(n: Int): Int =
  {
  	loopWhile(isPrime _, (x: Int) => x + 1)(n)
  };System.out.println("""nextPrime: (n: Int)Int""");$skip(13); val res$6 = 
  isPrime(8);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(18); val res$7 = 
  
  nextPrime(8);System.out.println("""res7: Int = """ + $show(res$7));$skip(17); val res$8 = 
  nextPrime(122)
  
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
  object Mul {def apply(num1: Double, num2: Double) = new Mul(num1, num2)};System.out.println("""res8: Int = """ + $show(res$8));$skip(491); 
  def execute(program: List[Command]): List[Double] =
  {
  	program.map(_.oper)
  };System.out.println("""execute: (program: List[midRevew0.Command])List[Double]""");$skip(61); val res$9 = 
  execute(List(Add(2.0, 3.1), Mul(4.0, 5.0), Add(2.7, 9.0)));System.out.println("""res9: List[Double] = """ + $show(res$9));$skip(119); 
  def countRoots[T](f: T=>Double, inputs: List[T]): Int =
  {
  	inputs.map(f).filter((x: Double)=> x == 0.0).size
  };System.out.println("""countRoots: [T](f: T => Double, inputs: List[T])Int""");$skip(77); val res$10 = 
  countRoots((x: Double) => (x - 2.0) * (x - 3.0), List(1.0, 2.0, 3.0, 4.0));System.out.println("""res10: Int = """ + $show(res$10))}

}
