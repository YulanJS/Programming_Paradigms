import scala.util.Random
object string {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //problem 1 only letters pal OK
  //asked Prof, it is case sensitive
  def isPal(str: String) = (str.trim) == (str.trim.reverse) //reverse function in API
                                                  //> isPal: (str: String)Boolean
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
  isPal("rotator")                                //> res0: Boolean = true
  isPal("cat")                                    //> res1: Boolean = false
  isPal("1,2332,1")                               //> res2: Boolean = true
  isPal("    a bcb a  ")                          //> res3: Boolean = true
  isPal("Atta")                                   //> res4: Boolean = false
  
  //problem 2: ignore case, punctuation and white space
  def isPal2(str: String) =
  {
  	var myStr = str
  	myStr = myStr.filter(p => p.isLetterOrDigit)
  	isPal(myStr.toLowerCase)
  }                                               //> isPal2: (str: String)Boolean
  isPal2("A man, a plan, a canal, Panama!")       //> res5: Boolean = true
  isPal2("A_bcdCba")                              //> res6: Boolean = true
  isPal2("i t%une   , eiNU(((T---i")              //> res7: Boolean = false
  
  //problem 4: word generator (only lowercase letters)
  val randGen = new Random(System.currentTimeMillis)
                                                  //> randGen  : scala.util.Random = scala.util.Random@7a0ac6e3
  def mkWord(len: Int = 5)= //default argument
  {
  	var result = ""
  	for(i <- 1 to len) result +=(randGen.nextInt(26) + 'a').toChar
  	//one random letter //num + 'a': auto conversion
  	result
  }                                               //> mkWord: (len: Int)String
  val a1 = mkWord()                               //> a1  : String = azeqe
  val a2 = mkWord()                               //> a2  : String = ewowo
  val a3 = mkWord()                               //> a3  : String = umuag
  val a4 = mkWord(20)                             //> a4  : String = hpysgsuboecuahldtdjh
  
  //problem 5: randome sentence generator
  def mkSentence(words: Int = 10) =
  {
  	var str = ""
  	str += mkWord().capitalize
  	for(i <- 2 to words) str += " " + mkWord()
  	str += "."
  	str
  }                                               //> mkSentence: (words: Int)String
  
  mkSentence()                                    //> res8: String = Udjkq omqcy qdwmm eqmhd caqix tpsgx soedp agczq xosoy oyodz.
                                                  //| 
  mkSentence()                                    //> res9: String = Vhjzb dhrcx egazr ptbiq ulrox hlnap gnity oczsg gcuoj qdpqn.
                                                  //| 
  mkSentence(8)                                   //> res10: String = Gbpjo objjn jcrhk petqo akkgq ilpme htmsu llabs.
  
  //problem 8: need to write exception ; negative number; addition only
  // ???Think about how to use Array to do it later, after finishing hw
  def isNumeric(c: Char) = c.isDigit || c == '.' || c == '-' //it can be negative numbers
                                                  //> isNumeric: (c: Char)Boolean
  def isOperator(c: Char) = c == '+'              //> isOperator: (c: Char)Boolean
  def isSpace(c: Char) = c == '\n' || c == '\t' || c == ' '
                                                  //> isSpace: (c: Char)Boolean
                                                
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
  }                                               //> eval: (str: String)Double
  
  eval("    -3.26  +    -9.50")                   //> res11: Double = -12.76
  eval(" -26 + 49.99")                            //> res12: Double = 23.990000000000002
  try
  {
  	eval("21 * 43")
  }
  catch
  {
  	case e: Exception => println(e)
  }                                               //> java.lang.Exception: operator must be +
                                                  //| res13: AnyVal = ()
 
	try
  {
  	eval("abc + 3")
  }
  catch
  {
  	case e: Exception => println(e)
  }                                               //> java.lang.Exception: operands must be numbers
                                                  //| res14: AnyVal = ()
  
  
  //problem 9
  def isMultiply(c: Char) = c == '*'              //> isMultiply: (c: Char)Boolean
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
  }                                               //> multiply: (str: String)Double
  
  multiply("    -3.26  *    -9.50")               //> res15: Double = 30.97
  multiply(" -26 * 49.99")                        //> res16: Double = -1299.74
  try
  {
  	multiply("21 + 43")
  }
  catch
  {
  	case e: Exception => println(e)
  }                                               //> java.lang.Exception: operator must be +
                                                  //| res17: AnyVal = ()
 
	try
  {
  	multiply("abc * 3")
  }
  catch
  {
  	case e: Exception => println(e)
  }                                               //> java.lang.Exception: operands must be numbers
                                                  //| res18: AnyVal = ()
  
}