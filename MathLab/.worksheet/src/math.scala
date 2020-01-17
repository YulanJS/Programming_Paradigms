import scala.math._
import scala.util._
class NegativeArgumentException extends Exception
object math {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(147); 
  println("Welcome to the Scala worksheet");$skip(263); 
  
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
  };System.out.println("""solve: (a: Double, b: Double, c: Double)Option[(Double, Double)]""");$skip(20); val res$0 = 
  
  solve(1, 2, 1);System.out.println("""res0: Option[(Double, Double)] = """ + $show(res$0));$skip(17); val res$1 = 
  solve(1, 1, 1);System.out.println("""res1: Option[(Double, Double)] = """ + $show(res$1));$skip(18); val res$2 = 
  solve(1, -4, 3);System.out.println("""res2: Option[(Double, Double)] = """ + $show(res$2));$skip(19); val res$3 = 
  solve(2, -2, -4);System.out.println("""res3: Option[(Double, Double)] = """ + $show(res$3));$skip(17); val res$4 = 
  solve(1, 0, 1);System.out.println("""res4: Option[(Double, Double)] = """ + $show(res$4));$skip(18); val res$5 = 
  solve(1, 0, -1);System.out.println("""res5: Option[(Double, Double)] = """ + $show(res$5));$skip(333); 
  
  //??? For complex roots imaginary i in Scala
  
  //problem 2
  def dist(point1: (Double, Double), point2: (Double, Double))=
  {
  	val (x1, y1) = point1
  	val (x2, y2) = point2
  	println("The type of dist is dist: (point1:(Double, Double), point2:(Double, Double))Double")
  	sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2))
  	
  };System.out.println("""dist: (point1: (Double, Double), point2: (Double, Double))Double""");$skip(29); val res$6 = 
  
  
  dist((1, 1), (0, 0));System.out.println("""res6: Double = """ + $show(res$6));$skip(23); val res$7 = 
  dist((3, 0), (0, 0));System.out.println("""res7: Double = """ + $show(res$7));$skip(279); 
  //???change to n dimensional
  //???Copy all outputs as comments? Do I need to?
  
  
  //problem 3
  def dot(point1: (Double, Double, Double), point2: (Double, Double, Double)) =
  {
  	val (x1, y1, z1) = point1
  	val (x2, y2, z2) = point2
  	x1 * x2 + y1 * y2 + z1 * z2
  };System.out.println("""dot: (point1: (Double, Double, Double), point2: (Double, Double, Double))Double""");$skip(32); val res$8 = 
  dot((2.0, 3, 4), (2, 2.0, 2));System.out.println("""res8: Double = """ + $show(res$8));$skip(389); 
  
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
  };System.out.println("""isPrime: (num: Int)Boolean""");$skip(13); val res$9 = 
  isPrime(0);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(13); val res$10 = 
  isPrime(1);System.out.println("""res10: Boolean = """ + $show(res$10));$skip(13); val res$11 = 
  isPrime(2);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(13); val res$12 = 
  isPrime(9);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(14); val res$13 = 
  isPrime(11);System.out.println("""res13: Boolean = """ + $show(res$13));$skip(14); val res$14 = 
  isPrime(21);System.out.println("""res14: Boolean = """ + $show(res$14));$skip(14); val res$15 = 
  isPrime(17);System.out.println("""res15: Boolean = """ + $show(res$15));$skip(121); val res$16 = 
  
  try{
  	isPrime(-1)
  }
  catch{
  	case e: NegativeArgumentException => println("Argument cannot be negative")
  };System.out.println("""res16: AnyVal = """ + $show(res$16));$skip(199); 
  def isTwinPrime(twin: (Int, Int)) =
  {
  	var result = twin._1 > 1 && twin._2 > 1
  	if(twin._1 < 0 || twin._2 < 0) throw new NegativeArgumentException
  	isPrime(twin._1) && isPrime(twin._2)
  };System.out.println("""isTwinPrime: (twin: (Int, Int))Boolean""");$skip(27); val res$17 = 
  
  isTwinPrime((11, 13));System.out.println("""res17: Boolean = """ + $show(res$17));$skip(22); val res$18 = 
  isTwinPrime((2, 4));System.out.println("""res18: Boolean = """ + $show(res$18));$skip(24); val res$19 = 
  isTwinPrime((12, 19));System.out.println("""res19: Boolean = """ + $show(res$19));$skip(24); val res$20 = 
  isTwinPrime((15, 27));System.out.println("""res20: Boolean = """ + $show(res$20));$skip(127); val res$21 = 
  try{
  	isTwinPrime((-1, 0))
  }
  catch{
  	case e: NegativeArgumentException => println("Argument cannot be negative")
  };System.out.println("""res21: AnyVal = """ + $show(res$21));$skip(154); 
  //problem 7
  def gcd(num1: Int, num2: Int): Int =
  {
  	if(num1 < num2) gcd(num2, num1)
  	else if(num2 == 0) num1
  	else gcd(num2, num1 % num2)
  };System.out.println("""gcd: (num1: Int, num2: Int)Int""");$skip(17); val res$22 = 
  
  gcd(10, 24);System.out.println("""res22: Int = """ + $show(res$22));$skip(14); val res$23 = 
  gcd(15, 12);System.out.println("""res23: Int = """ + $show(res$23));$skip(12); val res$24 = 
  gcd(9, 0);System.out.println("""res24: Int = """ + $show(res$24));$skip(14); val res$25 = 
  gcd(12, 18);System.out.println("""res25: Int = """ + $show(res$25));$skip(112); 
  
  def phi(n: Int) =
  {
  	var counter = 0
  	for(k <- 1 to n if gcd(n, k) == 1) counter += 1
  	counter
  };System.out.println("""phi: (n: Int)Int""");$skip(12); val res$26 = 
  
  phi(9);System.out.println("""res26: Int = """ + $show(res$26));$skip(10); val res$27 = 
  phi(10);System.out.println("""res27: Int = """ + $show(res$27));$skip(120); 
  
  //problem 8
  //let cases use the same random number generator
  val random = new Random(System.currentTimeMillis);System.out.println("""random  : scala.util.Random = """ + $show(random ));$skip(77); 
  def rollDice() =
  {
  	(random.nextInt(6) + 1, random.nextInt(6) + 1)
  };System.out.println("""rollDice: ()(Int, Int)""");$skip(13); val res$28 = 
  rollDice();System.out.println("""res28: (Int, Int) = """ + $show(res$28));$skip(13); val res$29 = 
  rollDice();System.out.println("""res29: (Int, Int) = """ + $show(res$29));$skip(13); val res$30 = 
  rollDice();System.out.println("""res30: (Int, Int) = """ + $show(res$30));$skip(13); val res$31 = 
  rollDice();System.out.println("""res31: (Int, Int) = """ + $show(res$31))}
}
	