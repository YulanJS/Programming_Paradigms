object DDSworksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 
  println("Welcome to the Scala worksheet");$skip(211); 
  def controlLoop[S](state: S, cycle: Int, halt: (S, Int)=> Boolean, update: (S, Int)=>S): S =
  	if(halt(state, cycle)) state
  	else controlLoop(update(state, cycle), cycle + 1, halt, update);System.out.println("""controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S)S""");$skip(121);  //tail recursion
  	//halt and update are functional parameters
  	//no variables
  
  //environmental example
  val br = 0.2;System.out.println("""br  : Double = """ + $show(br ));$skip(27);  //birthrate
  val dr = 0.1;System.out.println("""dr  : Double = """ + $show(dr ));$skip(154);  //deathrate
  def updatePop(currentPop:Int, numYears: Int) = {
  	println("currentPop = " + currentPop)
  	(currentPop + br * currentPop - dr * currentPop).toInt
  };System.out.println("""updatePop: (currentPop: Int, numYears: Int)Int""");$skip(69); 
  
  def stopDemo(currentPop: Int, numYears: Int) = (numYears == 10);System.out.println("""stopDemo: (currentPop: Int, numYears: Int)Boolean""");$skip(45); val res$0 = 
  
  controlLoop(20, 0, stopDemo, updatePop);System.out.println("""res0: Int = """ + $show(res$0));$skip(766); 
                                                  
  //guess and check
  //f(x) = 0 => x Newton
  //guess = guess - f(guess) / f'(guess)
  // |f(guess)| < epsilon
  
  def solve(f: Double => Double): Double =
  {
  	//solve any function
  	val delta = 1e-5
  	def goodEnough(guess: Double, numGuesses: Int) =
  		math.abs(f(guess)) <= delta //because we are looking for f(guess) = 0
  		
  	def improve(guess: Double, numGuesses: Int) =
  		guess - (f(guess) /df(guess))
  		
  	def df(x: Double) = (f(x + delta) - f(x))/delta // f'(x) = lim (f(x + delta) - f(x)) / delta
  		controlLoop(1.0, 0, goodEnough, improve)
  	//to approximate sqrt(n)
  	//we find a function f(sqrt(n)) = 0, with f and solve, we can get an approximation of sqrt(n)
  	//f(x) = x^2 - n
  };System.out.println("""solve: (f: Double => Double)Double""");$skip(57); 
  	def sqrt(n: Double) = solve((x: Double) => x * x - n);System.out.println("""sqrt: (n: Double)Double""")}
  	
}
