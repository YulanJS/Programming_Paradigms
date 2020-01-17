object feb26 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(232); 
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
  };System.out.println("""makeIter: (baseVal: Int, combine: (Int, Int) => Int)Int => Int""");$skip(67); 
  
  val fact = makeIter(1, _ * _);System.out.println("""fact  : Int => Int = """ + $show(fact ));$skip(10); val res$0 =  //short hand for multiplication
  fact(5);System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  fact(4);System.out.println("""res1: Int = """ + $show(res$1));$skip(54); 
  
  val tri = makeIter(0, (n: Int, m: Int) => n + m);System.out.println("""tri  : Int => Int = """ + $show(tri ));$skip(9); val res$2 = 
  tri(5);System.out.println("""res2: Int = """ + $show(res$2));$skip(9); val res$3 = 
  tri(4);System.out.println("""res3: Int = """ + $show(res$3));$skip(165); 
  
  //a function does tail recursive using combinator: May appear in the midterm
  
  def sqrt(x: Double): Option[Double] = if(x < 0) None else Some(math. sqrt(x));System.out.println("""sqrt: (x: Double)Option[Double]""");$skip(12); val res$4 = 
  sqrt(100);System.out.println("""res4: Option[Double] = """ + $show(res$4));$skip(13); val res$5 = 
  sqrt(-100);System.out.println("""res5: Option[Double] = """ + $show(res$5));$skip(236); 
  
  
  //converts Option return function to Exception thrown function
  //wrapper funciton
  def sqrt2(x: Double): Double = {
  	sqrt(x) match{
  		case None => throw new Exception("bad input")
  		case Some(result) => result
  	}
  };System.out.println("""sqrt2: (x: Double)Double""");$skip(173); 
  
  try{
  	println(sqrt2(100)) // use println to get both results, otherwise, only show exception
  	println(sqrt2(-100))
  }catch{
  	case e: Exception => println(e)
  };$skip(351); 
        
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
	};System.out.println("""optionize: [U, V](f: U => V)U => Option[V]""");$skip(29); 
	val f1 = optionize(sqrt2 _);System.out.println("""f1  : Double => Option[Double] = """ + $show(f1 ));$skip(7); val res$6 = 
	f1(9);System.out.println("""res6: Option[Double] = """ + $show(res$6));$skip(8); val res$7 = 
	f1(-1);System.out.println("""res7: Option[Double] = """ + $show(res$7));$skip(431); 
	
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
	};System.out.println("""tailRecur: [U](initialVal: U, updateF: (Int, U) => U)Int => U""");$skip(73); 
	
	val factorial = tailRecur(1, (count: Int, prev: Int) => count * prev);System.out.println("""factorial  : Int => Int = """ + $show(factorial ));$skip(14); val res$8 = 
	factorial(5);System.out.println("""res8: Int = """ + $show(res$8));$skip(296); 
	//use recursion to do countPass
	//???
	//tail recursive version
	def countPass[T](array: Array[T], test: T => Boolean) =
  {
  	//Change it: How to use recursion to do this? Using loops will be deducted points.
		var count = 0
  	for(element <- array if(test(element))) count += 1
  	count
  };System.out.println("""countPass: [T](array: Array[T], test: T => Boolean)Int""");$skip(79); val res$9 = 
	
	countPass(Array("mom", "dad", "dog"), (str: String) => str == str.reverse);System.out.println("""res9: Int = """ + $show(res$9));$skip(57); val res$10 = 
	countPass(Array(1, 2, 3, 4, 5), (x: Int) => x % 2 != 0);System.out.println("""res10: Int = """ + $show(res$10))}
                                                  
                                                  
}
