package expression
import value._
import context._
case class Declaration(val identifier: Identifier, val expression: Expression) extends SpecialForm {
  def execute(env: Environment): Value = 
  {
    env.put(identifier, expression.execute(env)) 
    Notification.OK
  }
}