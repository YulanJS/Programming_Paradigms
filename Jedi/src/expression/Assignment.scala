package expression
import context.Environment 
import context.TypeException
import value._

case class Assignment (val idf : Identifier, val update: Expression) extends SpecialForm {
  def execute(env: Environment) :Value = {
    var result = idf.execute(env)
    if(!result.isInstanceOf[Variable]) throw new TypeException("Assignment has to be a Variable!")
    else {
      result.asInstanceOf[Variable].content = update.execute(env)
      Notification.DONE
    }    
  }
}