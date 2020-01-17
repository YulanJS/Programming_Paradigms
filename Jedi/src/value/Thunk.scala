package value
import expression._
import context._
class Thunk(body: Expression, defEnv: Environment) 
  extends Closure(Nil, body, defEnv){
  //Thunk doesn't have params, inherits Nil as params from Closure
  //passByName
  //???better form of definition for params in Thunk?
  //???inherit something from closure?
  //Thunk doesn't have args: List[Value]
  var cache: Value = null
  def apply(callingEnv: Environment = null): Value = 
  { 
      //cache
    if(cache == null)
    {
      super.apply(Nil, callingEnv) 
    }
    else
    {
      cache
    }
    //Nil for params, inherited
    //Nil for args, passed into super.apply()
    //store in cache, don't do it twice: imagine a Thunk: x| x * x
  }
}