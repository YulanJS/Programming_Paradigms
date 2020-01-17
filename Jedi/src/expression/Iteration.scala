package expression
import context._
import value._

case class Iteration(condition: Expression, body: Expression) extends SpecialForm {
  def execute(env: Environment): Value = 
  {
    while(condition.execute(env) == Boole(true))
    {
      body.execute(env)    
    }
    Notification.DONE
  }
  /*
  def execute(env: Environment): Value = {
    val con = condition.execute(env)
    if (!con.isInstanceOf[Boole]) throw new TypeException("Condition must be Boole!")
    var conInst = con.asInstanceOf[Boole]
    while (conInst.value) {
      body.execute(env)
      conInst = condition.execute(env).asInstanceOf[Boole]
    }
    Notification.DONE
  }
  * */
  
}