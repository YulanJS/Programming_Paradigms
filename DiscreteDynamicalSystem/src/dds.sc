object dds {
	//HW3 Yulan Jin
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  import scala.math. _
  //Problem 1
  def controlLoop[S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S): S =
  	if(halt(state, cycle)) state
  	else controlLoop(update(state, cycle), cycle + 1, halt, update) //tail recursive version
                                                  //> controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S
                                                  //| , Int) => S)S

  //Problem 2 //cycle: every week
  	controlLoop(1, 0, (s: Int, c: Int) => s > 100000, (s: Int, c: Int) => 2 * s)
                                                  //> res0: Int = 131072
  	
  //Problem 3
  def solve(f: Double => Double) = //solve f(x) = 0
  {
  	val delta = 1e-5
  	def df(x: Double, delta: Double) = (f(x + delta) - f(x))/delta
  	def goodEnough(x: Double, numGuesses: Int) = abs(f(x)) <= delta //halt _
  	def improve(guess: Double, numGuesses: Int) = guess - f(guess) / df(guess, delta) //update _
  	controlLoop(1.0, 0, goodEnough _, improve _)
  }                                               //> solve: (f: Double => Double)Double
  
  //Problem 4
  def squareRoot(x: Double) = solve((y: Double) => y * y - x)
                                                  //> squareRoot: (x: Double)Double
  squareRoot(9.0)                                 //> res1: Double = 3.0000000015508212
  squareRoot(16.0)                                //> res2: Double = 4.000000639575587
  
  //Problem 5
  def cubeRoot(x: Double) =  solve((y: Double) => y * y * y - x)
                                                  //> cubeRoot: (x: Double)Double
  cubeRoot(27)                                    //> res3: Double = 3.0000000000019176
  cubeRoot(125)                                   //> res4: Double = 5.000000000364238
  
  //Problem 6
  def nthRoot(x: Double, n: Int) = solve((y: Double) => pow(y, n) - x)
                                                  //> nthRoot: (x: Double, n: Int)Double
  nthRoot(81, 4)                                  //> res5: Double = 3.000000000001341
  nthRoot(32, 5)                                  //> res6: Double = 2.000000000001636
  
  
}