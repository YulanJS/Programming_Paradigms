package expression
import context._
import value._
case class Block(val exps: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = 
  {
    //(1) tempEnv = new Env(env)
    val tempEnv = new Environment(env)
    //(2) execute exps relative to tempEnv: 
    //one by one, but the return value is the last one
    val args: List[Value] = exps.map(_.execute(tempEnv))
    args.last
    //(3) return value of last one
  }
  //temp env will be deleted after...
}