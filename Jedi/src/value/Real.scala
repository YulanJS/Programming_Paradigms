package value

case class Real(val value: Double) extends Literal with Ordered[Real] with Equals{
  //trait Equals has canEqual() and equals()
  //trait Ordered[Integer] contains: < <= > >= compareTo
  def +(other: Real) = Real(this.value + other.value)
  
  def -(other: Real) = Real(this.value - other.value)
  
  def *(other: Real) = Real(this.value * other.value)
  
  def /(other: Real) = 
    if(other.value != 0.0)Real(this.value / other.value)
    else throw new Exception("Cannot divide by zero")
  
  def unary_- = Real(-1 * this.value)
  
  override def toString = value.toString
  
  //Ordered[] concrete methods: compareTo() < <= > >=
  //compare() is abstract method in Ordered[]
  def compare(other: Real) = 
    if(this.value < other.value) -1
    else if(other.value < this.value) 1
    else 0
  
  override def canEqual(other: Any)= other.isInstanceOf[Real]
  
  override def equals(other: Any) =
    other match{
      //for the symmetry of equality, must check other.canEqual(this)
      //otherwise parentObj == childObj: true; childObj == parentObj: false
      //because the latter one checks isInstanceOf in child class
      case other: Real => other.canEqual(this) && (other.value == this.value)
      case _ => false
    }
  
  override def hashCode = this.toString.##
}

object Real{
  
}