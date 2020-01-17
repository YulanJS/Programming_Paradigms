object Evaluator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(70); 
  
  def isNumeric(c: Char) = c.isDigit || c == '.';System.out.println("""isNumeric: (c: Char)Boolean""");$skip(49); 
  def isOperator(c: Char) = c == '+' || c == '*';System.out.println("""isOperator: (c: Char)Boolean""");$skip(60); 
  def isSpace(c: Char) = c == ' ' || c == '\t' || c == '\n';System.out.println("""isSpace: (c: Char)Boolean""");$skip(712); 

  def eval(exp: String) = {
     var e = exp
     e = e.dropWhile(isSpace _)
     val num1 = e.takeWhile(isNumeric _)
     if (num1.isEmpty) throw new Exception("operands must be numbers")
     e = e.drop(num1.length)
     e = e.dropWhile(isSpace _)
     val op = e.takeWhile(isOperator _)
     if (op.isEmpty)  throw new Exception("operator must be + or *")
     e = e.drop(op.length)
     e = e.dropWhile(isSpace _)
     val num2 = e.takeWhile(isNumeric _)
     if (num2.isEmpty) throw new Exception("operands must be numbers")
     if (op == "+") num1.toDouble + num2.toDouble
     else if (op == "*") num1.toDouble * num2.toDouble
     else Double.NaN //???how can be here? threw all exceptions already
  };System.out.println("""eval: (exp: String)Double""");$skip(365); 
  
  def repl() = {
    var more = true
    while(more) {
      try {
        var exp = readLine("-> ")
        if (exp == "quit") {
          more = false
        } else {
          println("result = " + eval(exp))
        }
      } catch {
          case e: Exception => println(e)
      } finally {
          Console.flush()
      }
    }
    println("bye")
  };System.out.println("""repl: ()Unit""");$skip(50); 

  def main(args: Array[String]): Unit = { repl };System.out.println("""main: (args: Array[String])Unit""")}

}
 