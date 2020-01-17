package expression
import context. _
import value. _


case class Identifier(val name: String) extends Expression {
  override def toString = name
  def execute(env: Environment) = 
  {
    //println("looking up " + this)
    val result = env(this)
    if(result.isInstanceOf[Thunk])
    {
      result.asInstanceOf[Thunk].apply(env)
    }
    else if(result.isInstanceOf[Text])
    {
      //??? text.body
      result.asInstanceOf[Text].body.execute(env)
      //getbody is automatically generated in scala, and the name of getBody is body in scala
    }
    else
    {
      //env(this)
      result
    }
  }
}
