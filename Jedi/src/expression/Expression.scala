package expression
import context. _
import value. _
trait Expression {
  //all Expression classes have to be case classes
  def execute(env: Environment): Value
}