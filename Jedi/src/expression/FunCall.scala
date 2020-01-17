package expression
import context._
import value._
case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression{
  //parsed in operands in Jedi1Parsers, operands here is List[Expression]
  
  def execute(env: Environment): Value = 
  {
    if(env.contains(operator))
    {
      //in current env or extensive env, maybe closure
      val maybeClosure = operator.execute(env)
      if(maybeClosure.isInstanceOf[Closure])
      {
        val closure = maybeClosure.asInstanceOf[Closure]
        val args = operands.map(_.execute(env))
        closure(args, env)
      }    
      else
      {
        throw new TypeException("Only functions can be called")
      }
    }
    else
    {
      //alu will throw exception too
      alu2.execute(operator, operands.map(_.execute(env)))
    }
  }
   
  
  /*
  def execute(env: Environment): Value = 
  {
    //env is the calling environment
    try
    {      
      //println("contains " + operator + " = " + env.contains(operator)) 
      val maybeClosure = operator.execute(env)
      //if maybeClosure not a closure throw type exception
      if(Flags.paramaterPassing == Flags.passByValue)
      {
        //gives the closure calling env by apply()
        maybeClosure.asInstanceOf[Closure].apply(operands.map(_.execute(env)), env)   
      }
      else if(Flags.paramaterPassing == Flags.passByText)
      {
        maybeClosure.asInstanceOf[Closure].apply(operands.map((expr: Expression) => new Text(expr)), env)
      }
      else if(Flags.paramaterPassing == Flags.passByName)
      {
        //Thunk
        val aClosure = maybeClosure.asInstanceOf[Closure]
        //???better way? 
        //env for thunk
        //closure is defined long ago when declare as lambda
        //aclosure's calling environment: env, current env
        //Thunk's defining env: this env
        //Thunk is built before aClosure is applied
        aClosure.apply(operands.map((expr: Expression) => new Thunk(expr, env)), env)
      }
      else
      {
        throw new JediException("Flags.parameterPassing gets the wrong value");
      }
    }catch{
      //alu all eager execution
      case e: UndefinedException => alu.execute(operator, operands.map(_.execute(env)))
      //alu is responsible to throw exception
    }
    
    /*
    // or //hashmap contains
    // or override contains to search all extensions (all environment)
    if(env.contains(operator))
    {
      //user defined closure, closure is Value
      //funcall is where needs to execute to get final value
      val closure = operator.execute(env)
      (closure.asInstanceOf[Closure]).apply(operands.map(_.execute(env)))
      //System.out.println("env contains add")
      //alu.execute(operator, operands.map(_ .execute(env)))//eager execution
    }
    else
    {
      //???add is not defined in env?
       //System.out.println("env contains add")
       alu.execute(operator, operands.map(_ .execute(env)))//eager execution
      //alu knows how to throw undefined exception
    }
    
    //modify: user defined functions
    
  }
  * */
  */
}