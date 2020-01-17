import scala.math._
class InvalidIncomeException extends Exception
object control {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
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
  	}                                         //> tax: (income: Double)AnyVal
  
  try{
  	tax(-100.1)
  }
  catch{
  	case e: InvalidIncomeException => println("Income cannot be negative")
  }                                               //> Income cannot be negative
                                                  //| res0: AnyVal = ()
  tax(19999)                                      //> res1: AnyVal = 0
  tax(20000)                                      //> res2: AnyVal = 1000.0
  tax(39999)                                      //> res3: AnyVal = 4399.89
  tax(40001)                                      //> res4: AnyVal = 9200.23
  tax(99999)                                      //> res5: AnyVal = 31999.68
  tax(100000)                                     //> res6: AnyVal = 50000.0
  
  //problem 2: a procedure
  var result = ""                                 //> result  : String = ""
  def drawRectangle(row: Int, col: Int)
  {
  	for(i <- 0 until row)
  	{
  		for(j <- 0 until col) result += "*"
  		result += "\n"
  	}
  }                                               //> drawRectangle: (row: Int, col: Int)Unit
  
  drawRectangle(3, 4)
  println(result)                                 //> ****
                                                  //| ****
                                                  //| ****
                                                  //| 
  //problem 3: a procedure
  def printSums(n: Int, m: Int)
  {
  	for(i <- 1 until n; j <- 1 until m) println(i + "+" + j + "=" + (i + j))
  	//(i + j) must have parenthesis, otherwise, it becomes 11 12 concatenate
  }                                               //> printSums: (n: Int, m: Int)Unit
  
  printSums(4, 3)                                 //> 1+1=2
                                                  //| 1+2=3
                                                  //| 2+1=3
                                                  //| 2+2=4
                                                  //| 3+1=4
                                                  //| 3+2=5
                                                  
  //problem 4
  def mystery()=
  {
  	for(i <- 0 until 10 if(i % 3 != 0)) println("i =" + i)
  	println("done")
  }                                               //> mystery: ()Unit
  mystery()                                       //> i =1
                                                  //| i =2
                                                  //| i =4
                                                  //| i =5
                                                  //| i =7
                                                  //| i =8
                                                  //| done
  
  //problem 5
  //give below:
  def root(x: Double) = if(x < 0) None else Some(sqrt(x))
                                                  //> root: (x: Double)Option[Double]
 
  def below10(x: Double) = if(x < 10) Some(x) else None
                                                  //> below10: (x: Double)Option[Double]
  
  //use them to implement
  def pureRoot(x: Option[Double]) =
  	x match{
  		case Some(y) => root(y)
  		case _ => None
  	}                                         //> pureRoot: (x: Option[Double])Option[Double]
  
  def pureBelow10(x: Option[Double]) =
  	x match{
  		case Some(y) => below10(y)
  		case _ => None
  	}                                         //> pureBelow10: (x: Option[Double])Option[Double]
  
  //use those to define: //don't use match here, combine two already defined methods
  def below10root(x: Option[Double]) = pureRoot(pureBelow10(x))
                                                  //> below10root: (x: Option[Double])Option[Double]
  	
  pureRoot(None)                                  //> res7: Option[Double] = None
  pureRoot(Some(-1.1))                            //> res8: Option[Double] = None
  pureRoot(Some(4.0))                             //> res9: Option[Double] = Some(2.0)
  pureBelow10(None)                               //> res10: Option[Double] = None
  pureBelow10(Some(9.99))                         //> res11: Option[Double] = Some(9.99)
  pureBelow10(Some(10.01))                        //> res12: Option[Double] = None
  below10root(Some(9.02))                         //> res13: Option[Double] = Some(3.003331483536241)
  below10root(Some(10.1))                         //> res14: Option[Double] = None
  below10root(None)                               //> res15: Option[Double] = None
}