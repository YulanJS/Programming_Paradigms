package expression
import context._
import value._
trait SpecialForm extends Expression{
  def execute(env: Environment): Value
}