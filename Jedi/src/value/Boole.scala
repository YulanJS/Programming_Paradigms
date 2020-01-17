package value

case class Boole(val value: Boolean) extends Literal with Equals{
  //all operators get Boole() type, and use toString to print true or false
  def && (other: Boole) = Boole(value && other.value)
  
  def || (other: Boole) = Boole(value || other.value)
  
  def unary_! = Boole(!value)
  
  override def canEqual(other: Any)= other.isInstanceOf[Boole]
  
  override def equals(other: Any) =
    other match{
      //for the symmetry of equality, must check other.canEqual(this)
      //otherwise parentObj == childObj: true; childObj == parentObj: false
      //because the latter one checks isInstanceOf in child class
      case other: Boole => other.canEqual(this) && (other.value == this.value)
      case _ => false
    }
  
  //Otherwise, print Boole(true)
  override def toString = value.toString
}

object Boole{
  
}