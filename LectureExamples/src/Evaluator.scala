//String Processing
object Evaluator {
  
  def isNumeric(c: Char) = c.isDigit || c == '.' || c == '-'  //negative numbers and subtraction how to distinguish
  def isOperator(c: Char) = c == '+' || c == '*'  
  def isSpace(c: Char) = c == ' ' || c == '\t' || c == '\n'

  def eval(exp: String) = {
     var e = exp
     e = e.dropWhile(isSpace _)
     val num1 = e.takeWhile(isNumeric _) //are not responsible for checking multiple decimal points
     if (num1.isEmpty) throw new Exception("operands must be numbers")
     e = e.drop(num1.length) //length
     e = e.dropWhile(isSpace _)
     val op = e.takeWhile(isOperator _)
     if (op.isEmpty)  throw new Exception("operator must be + or *")
     e = e.drop(op.length)
     e = e.dropWhile(isSpace _)
     val num2 = e.takeWhile(isNumeric _)
     if (num2.isEmpty) throw new Exception("operands must be numbers")
     if (op == "+") num1.toDouble + num2.toDouble //number format exception comes from here
     else if (op == "*") num1.toDouble * num2.toDouble
     else Double.NaN
  }
  
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
          case e: Exception => println(e) //need to check exception, like number format exception
      } finally {
          Console.flush()
      }
    }
    println("bye")
  }

  def main(args: Array[String]): Unit = { repl }

}