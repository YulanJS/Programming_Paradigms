object rec2{
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  /*
  def exp2(n: Int): Int = if(n == 0) 1 else 2 * exp2(n - 1) //assume exp2(n - 1)just works and has a result
  
  exp2(4)
  exp2(5)
  exp2(10)
  */
 
 /*
  def exp2(n: Int) = {
  	var result = 1
  	for(count <- 1 to n) result = 2 * result
  	result
  }
 */
  
  /*
  def exp2(n: Int) = {
  	//@tailrec
  	def helper(count: Int, result: Int) : Int =
  		if(n < count) result else helper(count + 1, 2 * result)
  	helper(1, 1)
  }
  */
  
  /*
  def exp2(n: Int) = 2 << (n - 1)
  
  exp2(4)
  exp2(5)
  exp2(10)
  */
  
  /*
  def isPrime(n: Int) = {
     var result = n > 1
     for(m <- 2 until n / 2 if result)
     //for if similar to while, when if is not satisfied, stop the loop
     {
     	println(m)
     	result = n % m != 0
     }
     result
  }
  isPrime(9)
  */
  
 
  
   


}