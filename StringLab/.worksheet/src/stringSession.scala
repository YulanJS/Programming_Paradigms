import scala.util.Random
object stringSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); 
  println("Welcome to the Scala worksheet");$skip(160); 
  
  //problem 1 only letters pal OK
  //asked Prof, it is case sensitive
  def isPal(str: String) = (str.trim) == (str.trim.reverse);System.out.println("""isPal: (str: String)Boolean""");$skip(358); val res$0 =  //reverse function in API
    /*
  	var myStr = str
  	//???After assigning, myStr is String type, immutable, how to edit on it
  	var i = 0
  	var result = true
  	myStr = myStr.trim //remove leading and trailing whitespace
    while(result && (i < myStr.size / 2))
    {
    	if(myStr(i) != myStr(myStr.size - i)) result = false
    	i += 1
    }
  	result
  	*/
  isPal("rotator");System.out.println("""res0: Boolean = """ + $show(res$0));$skip(15); val res$1 = 
  isPal("cat");System.out.println("""res1: Boolean = """ + $show(res$1));$skip(20); val res$2 = 
  isPal("1,2332,1");System.out.println("""res2: Boolean = """ + $show(res$2));$skip(25); val res$3 = 
  isPal("    a bcb a  ");System.out.println("""res3: Boolean = """ + $show(res$3));$skip(16); val res$4 = 
  isPal("Atta");System.out.println("""res4: Boolean = """ + $show(res$4));$skip(191); 
  
  //problem 2: ignore case, punctuation and white space
  def isPal2(str: String) =
  {
  	var myStr = str
  	myStr = myStr.filter(p => p.isLetterOrDigit)
  	isPal(myStr.toLowerCase)
  };System.out.println("""isPal2: (str: String)Boolean""");$skip(44); val res$5 = 
  isPal2("A man, a plan, a canal, Panama!");System.out.println("""res5: Boolean = """ + $show(res$5));$skip(21); val res$6 = 
  isPal2("A_bcdCba");System.out.println("""res6: Boolean = """ + $show(res$6));$skip(37); val res$7 = 
  isPal2("i t%une   , eiNU(((T---i");System.out.println("""res7: Boolean = """ + $show(res$7));$skip(112); 
  
  //problem 4: word generator (only lowercase letters)
  val randGen = new Random(System.currentTimeMillis);System.out.println("""randGen  : scala.util.Random = """ + $show(randGen ));$skip(202); 
  def mkWord(len: Int = 5)= //default argument
  {
  	var result = ""
  	for(i <- 1 to len) result +=(randGen.nextInt(26) + 'a').toChar
  	//one random letter //num + 'a': auto conversion
  	result
  };System.out.println("""mkWord: (len: Int)String""");$skip(20); 
  val a1 = mkWord();System.out.println("""a1  : String = """ + $show(a1 ));$skip(20); 
  val a2 = mkWord();System.out.println("""a2  : String = """ + $show(a2 ));$skip(20); 
  val a3 = mkWord();System.out.println("""a3  : String = """ + $show(a3 ));$skip(22); 
  val a4 = mkWord(20);System.out.println("""a4  : String = """ + $show(a4 ));$skip(203); 
  
  //problem 5: randome sentence generator
  def mkSentence(words: Int = 10) =
  {
  	var str = ""
  	str += mkWord().capitalize
  	for(i <- 2 to words) str += " " + mkWord()
  	str += "."
  	str
  };System.out.println("""mkSentence: (words: Int)String""");$skip(18); val res$8 = 
  
  mkSentence();System.out.println("""res8: String = """ + $show(res$8));$skip(15); val res$9 = 
  mkSentence();System.out.println("""res9: String = """ + $show(res$9));$skip(16); val res$10 = 
  mkSentence(8);System.out.println("""res10: String = """ + $show(res$10));$skip(238); 
  
  //problem 8: need to write exception ; negative number; addition only
  // ???Think about how to use Array to do it later, after finishing hw
  def isNumeric(c: Char) = c.isDigit || c == '.' || c == '-';System.out.println("""isNumeric: (c: Char)Boolean""");$skip(37);  //it can be negative numbers
  def isOperator(c: Char) = c == '+';System.out.println("""isOperator: (c: Char)Boolean""");$skip(60); 
  def isSpace(c: Char) = c == '\n' || c == '\t' || c == ' ';System.out.println("""isSpace: (c: Char)Boolean""");$skip(836); 
                                                
  def eval(str: String) =
  {
  	var expr = str
  	//??? What is isSpace _ : without underscore, it still works
  	expr = expr.dropWhile(isSpace _)
  	val num1 = expr.takeWhile(isNumeric _) //take it out, but it is not dropped yet
  	if(num1.isEmpty) throw new Exception("operands must be numbers")
  	expr = expr.drop(num1.length) //must assign to it
  	expr = expr.dropWhile(isSpace _)
  	val operator = expr.takeWhile(isOperator _)// result of take: type String
  	if(operator.isEmpty) throw new Exception("operator must be +")
  	expr = expr.drop(operator.length)
  	expr = expr.dropWhile(isSpace _)
  	val num2 = expr.takeWhile(isNumeric _)
  	if(num2.isEmpty) throw new Exception("operands must be numbers")
  	num1.toDouble + num2.toDouble
  	//??? Why do we need Double.NaN
  };System.out.println("""eval: (str: String)Double""");$skip(36); val res$11 = 
  
  eval("    -3.26  +    -9.50");System.out.println("""res11: Double = """ + $show(res$11));$skip(23); val res$12 = 
  eval(" -26 + 49.99");System.out.println("""res12: Double = """ + $show(res$12));$skip(84); val res$13 = 
  try
  {
  	eval("21 * 43")
  }
  catch
  {
  	case e: Exception => println(e)
  };System.out.println("""res13: AnyVal = """ + $show(res$13));$skip(85); val res$14 = 
 
	try
  {
  	eval("abc + 3")
  }
  catch
  {
  	case e: Exception => println(e)
  };System.out.println("""res14: AnyVal = """ + $show(res$14));$skip(59); 
  
  
  //problem 9
  def isMultiply(c: Char) = c == '*';System.out.println("""isMultiply: (c: Char)Boolean""");$skip(790); 
  def multiply(str: String) =
  {
  	var expr = str
  	//??? What is isSpace _ : without underscore, it still works
  	expr = expr.dropWhile(isSpace _)
  	val num1 = expr.takeWhile(isNumeric _) //take it out, but it is not dropped yet
  	if(num1.isEmpty) throw new Exception("operands must be numbers")
  	expr = expr.drop(num1.length) //must assign to it
  	expr = expr.dropWhile(isSpace _)
  	val operator = expr.takeWhile(isMultiply _)// result of take: type String
  	if(operator.isEmpty) throw new Exception("operator must be +")
  	expr = expr.drop(operator.length)
  	expr = expr.dropWhile(isSpace _)
  	val num2 = expr.takeWhile(isNumeric _)
  	if(num2.isEmpty) throw new Exception("operands must be numbers")
  	num1.toDouble * num2.toDouble
  	//??? Why do we need Double.NaN
  };System.out.println("""multiply: (str: String)Double""");$skip(39); val res$15 = 
  
  multiply("    -3.26  *    -9.50");System.out.println("""res15: Double = """ + $show(res$15));$skip(27); val res$16 = 
  multiply(" -26 * 49.99");System.out.println("""res16: Double = """ + $show(res$16));$skip(88); val res$17 = 
  try
  {
  	multiply("21 + 43")
  }
  catch
  {
  	case e: Exception => println(e)
  };System.out.println("""res17: AnyVal = """ + $show(res$17));$skip(89); val res$18 = 
 
	try
  {
  	multiply("abc * 3")
  }
  catch
  {
  	case e: Exception => println(e)
  };System.out.println("""res18: AnyVal = """ + $show(res$18))}
  
}
