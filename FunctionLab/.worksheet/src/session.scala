object session {
	import scala.math._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
	//Yulan Jin
  println("Welcome to the Scala worksheet");$skip(101); 
  //Problem 1
  def compose[S, T, U](f: T => U, g: S => T) =
  {
  	def r(x: S) = f(g(x))
  	r _
  };System.out.println("""compose: [S, T, U](f: T => U, g: S => T)S => U""");$skip(107); 
  val composedFunction = compose((x: Double) => sqrt(x), (x: Int) => pow(x, 4));System.out.println("""composedFunction  : Int => Double = """ + $show(composedFunction ));$skip(22); val res$0 =  //must have parameter type
  composedFunction(3);System.out.println("""res0: Double = """ + $show(res$0));$skip(42); 
  
  
  //Problem 2
  def id[T](x: T) = x;System.out.println("""id: [T](x: T)T""");$skip(153); 
  def selfIter[T](f: T => T, n: Int): T => T =
  {
  	if(n == 0) id _ //difference between id and id _ ???
  	else compose(f, selfIter[T](f, n - 1))
  };System.out.println("""selfIter: [T](f: T => T, n: Int)T => T""");$skip(29); 
  def inc(x: Double) = x + 1;System.out.println("""inc: (x: Double)Double""");$skip(32); 
  def double(x: Double) = 2 * x;System.out.println("""double: (x: Double)Double""");$skip(24); val res$1 = 
  selfIter(inc _, 5)(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(27); val res$2 = 
  selfIter(double _, 3)(3);System.out.println("""res2: Double = """ + $show(res$2));$skip(24); val res$3 = 
  selfIter(inc _, 0)(1);System.out.println("""res3: Double = """ + $show(res$3));$skip(27); val res$4 = 
  selfIter(double _, 0)(5);System.out.println("""res4: Double = """ + $show(res$4));$skip(310); 
  
  //Problem 3: tail recursion version
  def countPass[T](array: Array[T], test: T => Boolean) =
	{
		def helper(count: Int, result: Int): Int =
		{
			if(count == array.size) result
			else{
				val update = if(test(array(count))) 1 else 0
			 	helper(count + 1, result + update)
			}
		}
		helper(0, 0)
	};System.out.println("""countPass: [T](array: Array[T], test: T => Boolean)Int""");$skip(35); 
  val array = Array(1, 2, 3, 4, 5);System.out.println("""array  : Array[Int] = """ + $show(array ));$skip(27); 
  def test(x: Int) = x > 5;System.out.println("""test: (x: Int)Boolean""");$skip(25); val res$5 = 
  countPass(array, test);System.out.println("""res5: Int = """ + $show(res$5));$skip(59); val res$6 = 
  countPass(Array(1, 3, 6, 7, 10), (x: Int) => x % 3 == 0);System.out.println("""res6: Int = """ + $show(res$6));$skip(77); val res$7 = 
  countPass(Array("mom", "dad", "dog"), (str: String) => str == str.reverse);System.out.println("""res7: Int = """ + $show(res$7));$skip(57); val res$8 = 
	countPass(Array(1, 2, 3, 4, 5), (x: Int) => x % 2 != 0);System.out.println("""res8: Int = """ + $show(res$8));$skip(257); 
  //Problem 4
  def recur(baseVal: Int, combiner: (Int, Int) => Int) =
  {
  	//returns a recursive function
  	def recursion(n: Int): Int =
  	{
  		if(n == 0) baseVal
  		else combiner(n, recursion(n - 1)) // combiner(n, f(n - 1))
  	}
  	recursion _
  };System.out.println("""recur: (baseVal: Int, combiner: (Int, Int) => Int)Int => Int""");$skip(61); 
  //for factorial function
  val factorial = recur(1, _ * _);System.out.println("""factorial  : Int => Int = """ + $show(factorial ));$skip(15); val res$9 = 
  factorial(5);System.out.println("""res9: Int = """ + $show(res$9));$skip(15); val res$10 = 
  factorial(4);System.out.println("""res10: Int = """ + $show(res$10));$skip(319); 
  
  //Problem 5
  //Converts Option to exception throwing
  def deOptionize[U, V](f: U => Option[V]) =
  {
  	//return type: U => T (don't need to put exception in the return type)
  	def r(x: U) =
  		f(x) match{
  			case None => throw new Exception("f throws an exception")
  			case Some(y) => y
  		}
  	r _
  };System.out.println("""deOptionize: [U, V](f: U => Option[V])U => V""");$skip(110); 
  
  def parseDigits(digits: String): Option[Int] = if(digits.matches("[0-9]*")) Some(digits.toInt) else None;System.out.println("""parseDigits: (digits: String)Option[Int]""");$skip(73); 
  //parse as parameters: function _
  val f = deOptionize(parseDigits _);System.out.println("""f  : String => Int = """ + $show(f ));$skip(14); val res$11 = 
  f("123569");System.out.println("""res11: Int = """ + $show(res$11));$skip(81); val res$12 = 
  try
  {
  	f("1503t94")
  }
  catch
  {
  	case e: Exception => println(e)
  };System.out.println("""res12: AnyVal = """ + $show(res$12))}
}
