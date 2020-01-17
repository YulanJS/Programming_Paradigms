package value
import expression._
import context._
class Closure(val params: List[Identifier], val body: Expression, val defEnv: Environment) extends Value{
  //When a closure is built, it doesn't know its calling env
  def apply(args: List[Value], callingEnv: Environment): Value = 
  {
    //???console closure.apply(List[Value]) instead of closure.apply(Value)
    //closure is a value: isSmall(a function) -> closure
    if(Flags.useStaticScopeRule)
    {
      val tempEnv = new Environment(defEnv);
      //add bindings to tempEnv
      //values in... not in defEnv... try global env?
      tempEnv.bulkPut(params, args);
      body.execute(tempEnv); //???lazy? here
    }
    else
    {
      //dynamic
      val tempEnv = new Environment(callingEnv)
      //add bindings to tempEnv
      //values in... not in defEnv... try global env?
      tempEnv.bulkPut(params, args);
      body.execute(tempEnv); //???lazy? here
    }
  }
}