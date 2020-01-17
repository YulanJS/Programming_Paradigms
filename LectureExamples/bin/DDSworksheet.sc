object DDSworksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def controlLoop[S](state: S, cycle: Int, halt: (S, Int)=> Boolean, update: (S, Int)=>S): S =
  	if(halt(state, cycle)) state
  	else controlLoop(update(state, cycle), cycle + 1, halt, update) //tail recursion
                                                  //> controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S
                                                  //| , Int) => S)S
  	//halt and update are functional parameters
  	//no variables
  
  //environmental example
  val br = 0.2 //birthrate                        //> br  : Double = 0.2
  val dr = 0.1 //deathrate                        //> dr  : Double = 0.1
  def updatePop(currentPop:Int, numYears: Int) = {
  	println("currentPop = " + currentPop)
  	(currentPop + br * currentPop - dr * currentPop).toInt
  }                                               //> updatePop: (currentPop: Int, numYears: Int)Int
  
  def stopDemo(currentPop: Int, numYears: Int) = (numYears == 10)
                                                  //> stopDemo: (currentPop: Int, numYears: Int)Boolean
  
  controlLoop(20, 0, stopDemo, updatePop)         //> currentPop = 20
                                                  //| currentPop = 22
                                                  //| currentPop = 24
                                                  //| currentPop = 26
                                                  //| currentPop = 28
                                                  //| currentPop = 30
                                                  //| currentPop = 33
                                                  //| currentPop = 36
                                                  //| currentPop = 39
                                                  //| currentPop = 42
                                                  //| res0: Int = 46
                                                  
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
  }                                               //> solve: (f: Double => Double)Double
  	def sqrt(n: Double) = solve((x: Double) => x * x - n)
                                                  //> sqrt: (n: Double)Double
  	
}