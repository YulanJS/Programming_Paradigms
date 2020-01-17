object practice2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(215); 
  
  //tri(n) = 0 + 1 + ... + n
  //tail recursion
  def tri(n: Int) =
  {
  	def helper(count: Int, result: Int): Int =
  	{
  		if(count > n) result else helper(count + 1, result + count)
  	}
  	helper(0, 0)
  };System.out.println("""tri: (n: Int)Int""");$skip(12); val res$0 = 
  
  tri(5);System.out.println("""res0: Int = """ + $show(res$0));$skip(165); 
  
  //exp2(n) = 2 ^ n; use iteration instead of recursion
  def exp2(n: Int) =
  {
  	var result = 1
  	for(n <- 0 until n)
  	{
  		result *= 2
  	}
  	result
  };System.out.println("""exp2: (n: Int)Int""");$skip(10); val res$1 = 
  exp2(3);System.out.println("""res1: Int = """ + $show(res$1));$skip(10); val res$2 = 
  exp2(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(64); 
  
  def compose[S, T, R](f: T=>R, g: S=>T) = (s: S) => f(g(s));System.out.println("""compose: [S, T, R](f: T => R, g: S => T)S => R""");$skip(220); 
  
  def listCompose[T](funs: List[T=>T]): T=>T =
  {
  	//reduce or tail recursion
  	//List[f1, f2, ..., fn]
  	def helper(result: T => T, unseen: ) =
  	{
  		//f1(f2(f3(...fn())))
  		//tail recursion
  			
  	}
  };System.out.println("""listCompose: [T](funs: List[T => T])T => T""");$skip(39); 
  	
  	def myself[T](input: T) = input;System.out.println("""myself: [T](input: T)T""");$skip(484); 
  	
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
  };System.out.println("""listCompose: [T](funs: List[T => T])T => T""");$skip(29); 
  
  def inc(x: Int) = x + 1;System.out.println("""inc: (x: Int)Int""");$skip(32); 
  
  def square(x: Int) = x * x;System.out.println("""square: (x: Int)Int""");$skip(32); 
  
  def triple(x: Int) = 3 * x;System.out.println("""triple: (x: Int)Int""");$skip(61); 
  	
  def foo = listCompose(List(square _, inc _, triple _));System.out.println("""foo: => <error>""");$skip(12); val res$3 = 
  
  foo(2);System.out.println("""res3: <error> = """ + $show(res$3));$skip(53); 
  
  def boo = listCompose(List[String => String]());System.out.println("""boo: => <error>""");$skip(18); val res$4 = 
  
  boo("Hello");System.out.println("""res4: <error> = """ + $show(res$4))}
  
  }
  
}
