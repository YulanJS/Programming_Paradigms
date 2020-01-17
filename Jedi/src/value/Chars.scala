package value

case class Chars(val value: String) extends Literal with Ordered[Chars] with Equals{
  def +(other: Chars) = Chars(value + other.value)
  //update value: def animal: side effect: how to print OK
  
  override def canEqual(other: Any) = other.isInstanceOf[Chars]
  
  override def equals(other: Any) = 
    other match{
      case other: Chars => other.canEqual(this) && this.value == other.value
      case _ => false
    }
   
  def length: Integer = Integer(value.length)
  
  override def compare(other: Chars) =
    //this way: succinct than if else
    value.compare(other.value)
  
  override def hashCode = this.toString.##
    
  def substring(start: Integer, end: Integer): Chars =
    Chars(value.substring(start.value, end.value))
  
  // < calls compare; == calls equals
   
  //have toString, otherwise, it will show Char(str)
  override def toString = this.value
}

object Chars{
}
  