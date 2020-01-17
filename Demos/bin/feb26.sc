object feb26 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def makeIter(baseVal: Int, combine: (Int, Int) => Int): Int => Int =
  {
  	def f(n: Int): Int =
  	{
  		var result = baseVal;
  		for(count <- 1 to n)
  		{
  			result = combine(count, result);
  		}
  		result
  	}
  	f _
  }                                               //> makeIter: (baseVal: Int, combine: (Int, Int) => Int)Int => Int
  
  val fact = makeIter(1, _ * _) //short hand for multiplication
                                                  //> fact  : Int => Int = feb26$$$Lambda$9/557041912@36d64342
  fact(5)                                         //> res0: Int = 120
  fact(4)                                         //> res1: Int = 24
  
  val tri = makeIter(0, (n: Int, m: Int) => n + m)//> tri  : Int => Int = feb26$$$Lambda$9/557041912@57829d67
  tri(5)                                          //> res2: Int = 15
  tri(4)                                          //> res3: Int = 10
  
  //a function does tail recursive using combinator: May appear in the midterm
  
  def sqrt(x: Double): Option[Double] = if(x < 0) None else Some(math. sqrt(x))
                                                  //> sqrt: (x: Double)Option[Double]
  sqrt(100)                                       //> res4: Option[Double] = Some(10.0)
  sqrt(-100)                                      //> res5: Option[Double] = None
  
  
  //converts Option return function to Exception thrown function
  //wrapper funciton
  def sqrt2(x: Double): Double = {
  	sqrt(x) match{
  		case None => throw new Exception("bad input")
  		case Some(result) => result
  	}
  }                                               //> sqrt2: (x: Double)Double
  
  try{
  	println(sqrt2(100)) // use println to get both results, otherwise, only show exception
  	println(sqrt2(-100))
  }catch{
  	case e: Exception => println(e)
  }                                               //> 10.0
                                                  //| java.lang.Exception: bad input
        
  //converts Option return function to Exception thrown function
  //general case: with combinator
	//change normal function with exception to Option function using combinator
	def optionize[U, V](f: U => V): U => Option[V] =
	{
		def r(x: U): Option[V] =
		{
			try{
				Some(f(x))
			}catch{
				case e: Exception => None
			}
		}
		r _
	}                                         //> optionize: [U, V](f: U => V)U => Option[V]
	val f1 = optionize(sqrt2 _)               //> f1  : Double => Option[Double] = feb26$$$Lambda$14/1627960023@1554909b
	f1(9)                                     //> res6: Option[Double] = Some(3.0)
	f1(-1)                                    //> res7: Option[Double] = None
	
	//design combinator to create tail recursive function
	def tailRecur[U](initialVal: U, updateF: (Int, U) => U): Int => U =
	{
		def r(n: Int): U =
		{
			def helper(count: Int, result: U): U =
			//don't use type helper[U], other wise, type mismatch,
			//from the outer function, U type is determined
			{
				if(count == n) result else helper(count + 1, updateF(count + 1, result))
			}
			helper(0, initialVal)
		}
		r _
	}                                         //> tailRecur: [U](initialVal: U, updateF: (Int, U) => U)Int => U
	
	val factorial = tailRecur(1, (count: Int, prev: Int) => count * prev)
                                                  //> factorial  : Int => Int = feb26$$$Lambda$16/114132791@22f71333
	factorial(5)                              //> res8: Int = 120
	//use recursion to do countPass
	//???
	//tail recursive version
	def countPass[T](array: Array[T], test: T => Boolean) =
  {
  	//Change it: How to use recursion to do this? Using loops will be deducted points.
		var count = 0
  	for(element <- array if(test(element))) count += 1
  	count
  }                                               //> countPass: [T](array: Array[T], test: T => Boolean)Int
	
	countPass(Array("mom", "dad", "dog"), (str: String) => str == str.reverse)
                                                  //> res9: Int = 2
	countPass(Array(1, 2, 3, 4, 5), (x: Int) => x % 2 != 0)
                                                  //> res10: Int = 3
                                                  
                                                  
}