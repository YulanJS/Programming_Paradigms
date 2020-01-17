import scala.math._
import scala.util._
class NegativeArgumentException extends Exception
object math {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //problem 1
  def solve(a: Double, b: Double, c: Double)=
  {
  	val delta = pow(b, 2) - 4 * a * c
  	if(delta < 0) None
  	else
  	{
  		val root1 = (- b - sqrt(delta)) / (2 * a)
  		val root2 = (- b + sqrt(delta)) / (2 * a)
  		Some(root1, root2)
  	}
  }                                               //> solve: (a: Double, b: Double, c: Double)Option[(Double, Double)]
  
  solve(1, 2, 1)                                  //> res0: Option[(Double, Double)] = Some((-1.0,-1.0))
  solve(1, 1, 1)                                  //> res1: Option[(Double, Double)] = None
  solve(1, -4, 3)                                 //> res2: Option[(Double, Double)] = Some((1.0,3.0))
  solve(2, -2, -4)                                //> res3: Option[(Double, Double)] = Some((-1.0,2.0))
  solve(1, 0, 1)                                  //> res4: Option[(Double, Double)] = None
  solve(1, 0, -1)                                 //> res5: Option[(Double, Double)] = Some((-1.0,1.0))
  
  //??? For complex roots imaginary i in Scala
  
  //problem 2
  def dist(point1: (Double, Double), point2: (Double, Double))=
  {
  	val (x1, y1) = point1
  	val (x2, y2) = point2
  	println("The type of dist is dist: (point1:(Double, Double), point2:(Double, Double))Double")
  	sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2))
  	
  }                                               //> dist: (point1: (Double, Double), point2: (Double, Double))Double
  
  
  dist((1, 1), (0, 0))                            //> The type of dist is dist: (point1:(Double, Double), point2:(Double, Double))
                                                  //| Double
                                                  //| res6: Double = 1.4142135623730951
  dist((3, 0), (0, 0))                            //> The type of dist is dist: (point1:(Double, Double), point2:(Double, Double))
                                                  //| Double
                                                  //| res7: Double = 3.0
  //???change to n dimensional
  //???Copy all outputs as comments? Do I need to?
  
  
  //problem 3
  def dot(point1: (Double, Double, Double), point2: (Double, Double, Double)) =
  {
  	val (x1, y1, z1) = point1
  	val (x2, y2, z2) = point2
  	x1 * x2 + y1 * y2 + z1 * z2
  }                                               //> dot: (point1: (Double, Double, Double), point2: (Double, Double, Double))Do
                                                  //| uble
  dot((2.0, 3, 4), (2, 2.0, 2))                   //> res8: Double = 18.0
  
  //problem 6
  def isPrime(num: Int) =
  {
  	var result = num > 1
  	var divisor = 2
  	//???do I need else under if for the while loop if already throws an exception,
  	//should not influence what is below...
  	if(num < 0) throw new NegativeArgumentException
  	while(result && (divisor <= num/2))
  	{
  		if(num % divisor == 0) result = false
  		divisor += 1
  	}
  	result
  }                                               //> isPrime: (num: Int)Boolean
  isPrime(0)                                      //> res9: Boolean = false
  isPrime(1)                                      //> res10: Boolean = false
  isPrime(2)                                      //> res11: Boolean = true
  isPrime(9)                                      //> res12: Boolean = false
  isPrime(11)                                     //> res13: Boolean = true
  isPrime(21)                                     //> res14: Boolean = false
  isPrime(17)                                     //> res15: Boolean = true
  
  try{
  	isPrime(-1)
  }
  catch{
  	case e: NegativeArgumentException => println("Argument cannot be negative")
  }                                               //> Argument cannot be negative
                                                  //| res16: AnyVal = ()
  def isTwinPrime(twin: (Int, Int)) =
  {
  	var result = twin._1 > 1 && twin._2 > 1
  	if(twin._1 < 0 || twin._2 < 0) throw new NegativeArgumentException
  	isPrime(twin._1) && isPrime(twin._2)
  }                                               //> isTwinPrime: (twin: (Int, Int))Boolean
  
  isTwinPrime((11, 13))                           //> res17: Boolean = true
  isTwinPrime((2, 4))                             //> res18: Boolean = false
  isTwinPrime((12, 19))                           //> res19: Boolean = false
  isTwinPrime((15, 27))                           //> res20: Boolean = false
  try{
  	isTwinPrime((-1, 0))
  }
  catch{
  	case e: NegativeArgumentException => println("Argument cannot be negative")
  }                                               //> Argument cannot be negative
                                                  //| res21: AnyVal = ()
  //problem 7
  def gcd(num1: Int, num2: Int): Int =
  {
  	if(num1 < num2) gcd(num2, num1)
  	else if(num2 == 0) num1
  	else gcd(num2, num1 % num2)
  }                                               //> gcd: (num1: Int, num2: Int)Int
  
  gcd(10, 24)                                     //> res22: Int = 2
  gcd(15, 12)                                     //> res23: Int = 3
  gcd(9, 0)                                       //> res24: Int = 9
  gcd(12, 18)                                     //> res25: Int = 6
  
  def phi(n: Int) =
  {
  	var counter = 0
  	for(k <- 1 to n if gcd(n, k) == 1) counter += 1
  	counter
  }                                               //> phi: (n: Int)Int
  
  phi(9)                                          //> res26: Int = 6
  phi(10)                                         //> res27: Int = 4
  
  //problem 8
  //let cases use the same random number generator
  val random = new Random(System.currentTimeMillis)
                                                  //> random  : scala.util.Random = scala.util.Random@6537cf78
  def rollDice() =
  {
  	(random.nextInt(6) + 1, random.nextInt(6) + 1)
  }                                               //> rollDice: ()(Int, Int)
  rollDice()                                      //> res28: (Int, Int) = (4,4)
  rollDice()                                      //> res29: (Int, Int) = (2,1)
  rollDice()                                      //> res30: (Int, Int) = (2,4)
  rollDice()                                      //> res31: (Int, Int) = (1,1)
}
	