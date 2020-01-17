object session {
	import scala.math._
	//Yulan Jin
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //Problem 1
  def compose[S, T, U](f: T => U, g: S => T) =
  {
  	def r(x: S) = f(g(x))
  	r _
  }                                               //> compose: [S, T, U](f: T => U, g: S => T)S => U
  val composedFunction = compose((x: Double) => sqrt(x), (x: Int) => pow(x, 4)) //must have parameter type
                                                  //> composedFunction  : Int => Double = session$$$Lambda$10/1809787067@7c30a502
                                                  //| 
  composedFunction(3)                             //> res0: Double = 9.0
  
  
  //Problem 2
  def id[T](x: T) = x                             //> id: [T](x: T)T
  def selfIter[T](f: T => T, n: Int): T => T =
  {
  	if(n == 0) id _ //difference between id and id _ ???
  	else compose(f, selfIter[T](f, n - 1))
  }                                               //> selfIter: [T](f: T => T, n: Int)T => T
  def inc(x: Double) = x + 1                      //> inc: (x: Double)Double
  def double(x: Double) = 2 * x                   //> double: (x: Double)Double
  selfIter(inc _, 5)(4)                           //> res1: Double = 9.0
  selfIter(double _, 3)(3)                        //> res2: Double = 24.0
  selfIter(inc _, 0)(1)                           //> res3: Double = 1.0
  selfIter(double _, 0)(5)                        //> res4: Double = 5.0
  
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
	}                                         //> countPass: [T](array: Array[T], test: T => Boolean)Int
  val array = Array(1, 2, 3, 4, 5)                //> array  : Array[Int] = Array(1, 2, 3, 4, 5)
  def test(x: Int) = x > 5                        //> test: (x: Int)Boolean
  countPass(array, test)                          //> res5: Int = 0
  countPass(Array(1, 3, 6, 7, 10), (x: Int) => x % 3 == 0)
                                                  //> res6: Int = 2
  countPass(Array("mom", "dad", "dog"), (str: String) => str == str.reverse)
                                                  //> res7: Int = 2
	countPass(Array(1, 2, 3, 4, 5), (x: Int) => x % 2 != 0)
                                                  //> res8: Int = 3
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
  }                                               //> recur: (baseVal: Int, combiner: (Int, Int) => Int)Int => Int
  //for factorial function
  val factorial = recur(1, _ * _)                 //> factorial  : Int => Int = session$$$Lambda$25/1632392469@6be46e8f
  factorial(5)                                    //> res9: Int = 120
  factorial(4)                                    //> res10: Int = 24
  
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
  }                                               //> deOptionize: [U, V](f: U => Option[V])U => V
  
  def parseDigits(digits: String): Option[Int] = if(digits.matches("[0-9]*")) Some(digits.toInt) else None
                                                  //> parseDigits: (digits: String)Option[Int]
  //parse as parameters: function _
  val f = deOptionize(parseDigits _)              //> f  : String => Int = session$$$Lambda$27/846492085@4157f54e
  f("123569")                                     //> res11: Int = 123569
  try
  {
  	f("1503t94")
  }
  catch
  {
  	case e: Exception => println(e)
  }                                               //> java.lang.Exception: f throws an exception
                                                  //| res12: AnyVal = ()
}