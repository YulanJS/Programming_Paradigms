package sec2

object control2 extends App {
  //problem1
  def tax(income: Double) =
  	//match is a single expression, don't need curly braces around the function
  	income match{
      case income if income < 100 => .1 * income //don't use return in this class
  		case income if income < 1000 => .2 * income
  		case income if income < 10000 => .3 * income
  		case _ => .1 * income
  	}   
  
  println(tax(99)) 
  println(tax(101))
  
  /* output
   * 9.9
   * 20.200000000000003
   */
}