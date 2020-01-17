package expression
import value._
import context._
case class Lambda(val parameters: List[Identifier], val body: Expression) extends SpecialForm {
  def execute(env: Environment): Value = 
  {
    //returns a closure
    new Closure(parameters, body, env)
  }
}