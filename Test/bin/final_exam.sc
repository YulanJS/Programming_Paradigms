object final_exam {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //tri(n) = 0 + 1 + ... + n
  //tail recursion
  def tri(n: Int) =
  {
  	def helper(count: Int, result: Int): Int =
  	{
  		if(count > n) result else helper(count + 1, result + count)
  	}
  	helper(0, 0)
  }                                               //> tri: (n: Int)Int
  tri(3)                                          //> res0: Int = 6
  
  
  //exp2(n) = 2^n
  //use iteration
  def exp2(n: Int) =
  {
  	
  }                                               //> exp2: (n: Int)Unit
  
  //def unitTest[S, T](inputs: List[S], outputs: List[T], f: S => T): Int =
  //{
  	//map, filter, reduce, use List.zip
  	//List((1,1), (4,4), (9,8))
  	//map a tuple use case(a, b)
  	//(inputs.map((s: S) => f(s)) zip outputs).map({case(t1: T, t2: T) => t1 - t2}).filter((t: T) => t != 0).size
  //}
}