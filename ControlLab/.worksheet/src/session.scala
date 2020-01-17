import scala.math._
class InvalidIncomeException extends Exception
object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(127); 
  println("Welcome to the Scala worksheet");$skip(401); 
  
  //problem 1:
  def tax(income: Double) =
  	income match{
  		case income if income < .0 => throw new InvalidIncomeException
  		case income if income < 20000 => 0
  		case income if income < 30000 => .05 * income
  		case income if income < 40000 => .11 * income
  		case income if income < 60000 => .23 * income
  		case income if income < 100000 => .32 * income
  		case _ => .5 * income
  	};System.out.println("""tax: (income: Double)AnyVal""");$skip(117); val res$0 = 
  
  try{
  	tax(-100.1)
  }
  catch{
  	case e: InvalidIncomeException => println("Income cannot be negative")
  };System.out.println("""res0: AnyVal = """ + $show(res$0));$skip(13); val res$1 = 
  tax(19999);System.out.println("""res1: AnyVal = """ + $show(res$1));$skip(13); val res$2 = 
  tax(20000);System.out.println("""res2: AnyVal = """ + $show(res$2));$skip(13); val res$3 = 
  tax(39999);System.out.println("""res3: AnyVal = """ + $show(res$3));$skip(13); val res$4 = 
  tax(40001);System.out.println("""res4: AnyVal = """ + $show(res$4));$skip(13); val res$5 = 
  tax(99999);System.out.println("""res5: AnyVal = """ + $show(res$5));$skip(14); val res$6 = 
  tax(100000);System.out.println("""res6: AnyVal = """ + $show(res$6));$skip(48); 
  
  //problem 2: a procedure
  var result = "";System.out.println("""result  : String = """ + $show(result ));$skip(142); 
  def drawRectangle(row: Int, col: Int)
  {
  	for(i <- 0 until row)
  	{
  		for(j <- 0 until col) result += "*"
  		result += "\n"
  	}
  };System.out.println("""drawRectangle: (row: Int, col: Int)Unit""");$skip(25); 
  
  drawRectangle(3, 4);$skip(18); 
  println(result);$skip(219); 
  //problem 3: a procedure
  def printSums(n: Int, m: Int)
  {
  	for(i <- 1 until n; j <- 1 until m) println(i + "+" + j + "=" + (i + j))
  	//(i + j) must have parenthesis, otherwise, it becomes 11 12 concatenate
  };System.out.println("""printSums: (n: Int, m: Int)Unit""");$skip(21); 
  
  printSums(4, 3);$skip(168); 
                                                  
  //problem 4
  def mystery()=
  {
  	for(i <- 0 until 10 if(i % 3 != 0)) println("i =" + i)
  	println("done")
  };System.out.println("""mystery: ()Unit""");$skip(12); 
  mystery();$skip(91); 
  
  //problem 5
  //give below:
  def root(x: Double) = if(x < 0) None else Some(sqrt(x));System.out.println("""root: (x: Double)Option[Double]""");$skip(58); 
 
  def below10(x: Double) = if(x < 10) Some(x) else None;System.out.println("""below10: (x: Double)Option[Double]""");$skip(129); 
  
  //use them to implement
  def pureRoot(x: Option[Double]) =
  	x match{
  		case Some(y) => root(y)
  		case _ => None
  	};System.out.println("""pureRoot: (x: Option[Double])Option[Double]""");$skip(109); 
  
  def pureBelow10(x: Option[Double]) =
  	x match{
  		case Some(y) => below10(y)
  		case _ => None
  	};System.out.println("""pureBelow10: (x: Option[Double])Option[Double]""");$skip(141); 
  
  //use those to define:
  def below10root(x: Option[Double]) =
  	x match{
  		case Some(y) if y < 10 => root(y)
  		case _ => None
  	};System.out.println("""below10root: (x: Option[Double])Option[Double]""");$skip(21); val res$7 = 
  	
  pureRoot(None);System.out.println("""res7: Option[Double] = """ + $show(res$7));$skip(23); val res$8 = 
  pureRoot(Some(-1.1));System.out.println("""res8: Option[Double] = """ + $show(res$8));$skip(22); val res$9 = 
  pureRoot(Some(4.0));System.out.println("""res9: Option[Double] = """ + $show(res$9));$skip(20); val res$10 = 
  pureBelow10(None);System.out.println("""res10: Option[Double] = """ + $show(res$10));$skip(26); val res$11 = 
  pureBelow10(Some(9.99));System.out.println("""res11: Option[Double] = """ + $show(res$11));$skip(27); val res$12 = 
  pureBelow10(Some(10.01));System.out.println("""res12: Option[Double] = """ + $show(res$12));$skip(26); val res$13 = 
  below10root(Some(9.02));System.out.println("""res13: Option[Double] = """ + $show(res$13));$skip(26); val res$14 = 
  below10root(Some(10.1));System.out.println("""res14: Option[Double] = """ + $show(res$14));$skip(20); val res$15 = 
  below10root(None);System.out.println("""res15: Option[Double] = """ + $show(res$15))}
}
