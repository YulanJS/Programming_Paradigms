package sec2
//worksheet: control.sc

object control {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 
  println("Welcome to the Scala worksheet");$skip(350); 
  // problem 1
  
  def tax(income: Double) =
  	//match is a single expression, don't need curly braces around the function
  	income match{
  		case income if income < 100 => .1 * income //don't use return in this class
  		case income if income < 1000 => .2 * income
  		case income if income < 10000 => .3 * income
  		case _ => .1 * income
  	};System.out.println("""tax: (income: Double)Double""");$skip(13); val res$0 = 
  
  tax(99);System.out.println("""res0: Double = """ + $show(res$0));$skip(11); val res$1 = 
  tax(101);System.out.println("""res1: Double = """ + $show(res$1));$skip(16); val res$2 = 
  tax(10000000);System.out.println("""res2: Double = """ + $show(res$2))}
  //save the file, then have all the green comments
}
