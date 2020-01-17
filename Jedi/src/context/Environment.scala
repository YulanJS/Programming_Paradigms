package context

import scala.collection.mutable._
import value._
import expression._

class Environment(var extension: Environment = null) 
  extends HashMap[Identifier, Value] with Value {
  //with Value will be used in Jedi4: OOP  
  // used by closures to bind parameters to arguments
  def bulkPut(params: List[Identifier], args: List[Value]) {
    if (params.length != args.length) throw new TypeException("# arguments != #parameters")
    for(i <- 0 until params.length) this.put(params(i), args(i))
  }
  
  //Global_Env and local Env (extends Global_Env)
  //hashMap(x): search an identifier
  override def apply(name: Identifier): Value = {
    if (super.contains(name)) super.apply(name) //finds in current hashMap (super)
    //else if: considers broader environment, 
    //also suitable if this class is a local env
    else if (extension != null) extension.apply(name) 
    else throw new UndefinedException(name)
  }
  
  
  //It is to check if the identifier is in this hashMap or one of the extensive hashMaps
  override def contains(operator: Identifier) = 
  {       
    var result = super.contains(operator)//super is a hashMap
    if(!result && extension != null)
    {
      //finds in hashMap
       result = extension.contains(operator) 
       //contains: true or false
    }
    result 
  }
}
