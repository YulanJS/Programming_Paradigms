object dds {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
	//HW3 Yulan Jin
  println("Welcome to the Scala worksheet")
  import scala.math. _;$skip(259); 
  //Problem 1
  def controlLoop[S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S): S =
  	if(halt(state, cycle)) state
  	else controlLoop(update(state, cycle), cycle + 1, halt, update);System.out.println("""controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S)S""");$skip(115); val res$0 =  //tail recursive version

  //Problem 2 //cycle: every week
  	controlLoop(1, 0, (s: Int, c: Int) => s > 100000, (s: Int, c: Int) => 2 * s);System.out.println("""res0: Int = """ + $show(res$0));$skip(384); 
  	
  //Problem 3
  def solve(f: Double => Double) = //solve f(x) = 0
  {
  	val delta = 1e-5
  	def df(x: Double, delta: Double) = (f(x + delta) - f(x))/delta
  	def goodEnough(x: Double, numGuesses: Int) = abs(f(x)) <= delta //halt _
  	def improve(guess: Double, numGuesses: Int) = guess - f(guess) / df(guess, delta) //update _
  	controlLoop(1.0, 0, goodEnough _, improve _)
  };System.out.println("""solve: (f: Double => Double)Double""");$skip(80); 
  
  //Problem 4
  def squareRoot(x: Double) = solve((y: Double) => y * y - x);System.out.println("""squareRoot: (x: Double)Double""");$skip(18); val res$1 = 
  squareRoot(9.0);System.out.println("""res1: Double = """ + $show(res$1));$skip(19); val res$2 = 
  squareRoot(16.0);System.out.println("""res2: Double = """ + $show(res$2));$skip(83); 
  
  //Problem 5
  def cubeRoot(x: Double) =  solve((y: Double) => y * y * y - x);System.out.println("""cubeRoot: (x: Double)Double""");$skip(15); val res$3 = 
  cubeRoot(27);System.out.println("""res3: Double = """ + $show(res$3));$skip(16); val res$4 = 
  cubeRoot(125);System.out.println("""res4: Double = """ + $show(res$4));$skip(89); 
  
  //Problem 6
  def nthRoot(x: Double, n: Int) = solve((y: Double) => pow(y, n) - x);System.out.println("""nthRoot: (x: Double, n: Int)Double""");$skip(17); val res$5 = 
  nthRoot(81, 4);System.out.println("""res5: Double = """ + $show(res$5));$skip(17); val res$6 = 
  nthRoot(32, 5);System.out.println("""res6: Double = """ + $show(res$6))}
  
  
}
