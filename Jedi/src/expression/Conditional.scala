package expression
import context._
import value._
case class Conditional(val condition: Expression, val consequent: Expression, val alternative: Expression = null) 
  extends SpecialForm {
  //laziness: not eager execution: auto met by if ... else
  
  def execute(env: Environment): Value =
  {
    //using match is better
    //if...else... is match case in Scala
    //condition.execute(env).asInstanceOf[Boole].value: case Boole(value)
    //try... catch exception: case _ => throws exception
    condition.execute(env) match
    {
      case Boole(value) =>
        if(value) consequent.execute(env)
        else if(alternative != null) alternative.execute(env)
        else Notification.UNSPECIFIED
      case _ => throw new TypeException("In if(condition), condition should be Boole type")
    }
  }
    /*
    try{
      if(condition.execute(env).asInstanceOf[Boole].value)
      {
        consequent.execute(env)
      }
      else if(alternative == null)
      {
        Notification.UNSPECIFIED
      }
      else
      {
        alternative.execute(env)
      }
    }catch{
      case e: Exception => throw new TypeException("Conditional expects Boole condition")
    }
  } 
  */
}