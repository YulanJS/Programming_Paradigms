object practice {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //write in scala
  def tri(n: Int): Int =
  {
  	def helper(result: Int, count: Int): Int =
  	{
  		if(count > n)result
  		else helper(result + count, count + 1)
  	}
  	helper(0, 0)
  }                                               //> tri: (n: Int)Int
  tri(5)                                          //> res0: Int = 15
  
  def exp2(n: Int): Int =
  {
  	//use Iteration
  	var result = 1
  	for(n <- 0 until n)
  	{
  		result = result * 2
  	}
  	result
  }                                               //> exp2: (n: Int)Int
  exp2(3)                                         //> res1: Int = 8
  exp2(4)                                         //> res2: Int = 16
  
  def compose[S, T, R](f: T => R, g: S => T): S => R =
  	//f(g(s)): S => R
  	(s: S) => f(g(s))                         //> compose: [S, T, R](f: T => R, g: S => T)S => R
  	
  def myself[T](input: T) = input                 //> myself: [T](input: T)T
  	
  def listCompose[T](funs: List[T => T]): T => T =
  {
  	//compose a list of functions
  	//1. use tail recursion: each one: T => T; composed together
  	/*
  	def helper(result: T => T, unseen: List[T => T]): T => T =
  	{
  		if(unseen == Nil) result
  		else helper(compose(unseen.head, result), unseen.tail)
  	}
  	helper(myself _, funs.reverse)
  	*/
  	//2. use reduce
  	if(funs == Nil) myself _
  	else funs.reverse.reduce( (f: T => T, g: T => T) => compose(g, f) )
  }                                               //> listCompose: [T](funs: List[T => T])T => T
  
  def inc(x: Int) = x + 1                         //> inc: (x: Int)Int
  
  def square(x: Int) = x * x                      //> square: (x: Int)Int
  
  def triple(x: Int) = 3 * x                      //> triple: (x: Int)Int
  	
  def foo = listCompose(List(square _, inc _, triple _))
                                                  //> foo: => Int => Int
  
  foo(2)                                          //> res3: Int = 49
  
  def boo = listCompose(List[String => String]()) //> boo: => String => String
  
  boo("Hello")                                    //> res4: String = Hello
  
}