object Evaluator {
  
  def isNumeric(c: Char) = c.isDigit || c == '.'  //> isNumeric: (c: Char)Boolean
  def isOperator(c: Char) = c == '+' || c == '*'  //> isOperator: (c: Char)Boolean
  def isSpace(c: Char) = c == ' ' || c == '\t' || c == '\n'
                                                  //> isSpace: (c: Char)Boolean

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
  }                                               //> eval: (exp: String)Double
  
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
  }                                               //> repl: ()Unit

  def main(args: Array[String]): Unit = { repl }  //> main: (args: Array[String])Unit

}
 