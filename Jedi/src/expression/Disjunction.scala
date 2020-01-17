package expression
import context._
import value._
case class Disjunction(val operands: List[Expression]) extends SpecialForm{
  //lazy
  def execute(env: Environment): Value = 
  {
    var result: Value = Boole(false)
    try{
      for(elem <- operands if !(result.asInstanceOf[Boole].value))
      {
        //hope it to be Boole(true) or Boole(false), otherwise typeException or syntaxException?
        result = elem.execute(env)
      }
      result
    }catch{
      case e: Exception => throw new TypeException("Disjunction expects Boole type")
    }
  }
}