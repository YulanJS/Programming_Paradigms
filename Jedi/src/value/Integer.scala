package value

case class Integer(val value: Int) extends Literal with Ordered[Integer] with Equals{
  //trait Equals has canEqual() and equals()
  //trait Ordered[Integer] contains: < <= > >= compareTo
  //overload
  def +(other: Integer) = Integer(this.value + other.value)
  
  def -(other: Integer) = Integer(this.value - other.value)
  
  def *(other: Integer) = Integer(this.value * other.value)
  
  def /(other: Integer) = { 
    if(other.value == 0) throw new Exception("Cannot divide by zero")
    Integer(this.value / other.value)}
    
  def unary_- = Integer(-1 * this.value)
  
  override def toString = value.toString
  
  //Ordered[] concrete methods: compareTo() < <= > >=, they all compare()
  //compare() is abstract method in Ordered[]
  def compare(other: Integer) = 
    if(this.value < other.value) -1
    else if(other.value < this.value) 1
    else 0
  
  override def canEqual(other: Any)= other.isInstanceOf[Integer]
  
  override def equals(other: Any) =
    other match{
      //for the symmetry of equality, must check other.canEqual(this)
      //otherwise parentObj == childObj: true; childObj == parentObj: false
      //because the latter one checks isInstanceOf in child class
      case other: Integer => other.canEqual(this) && (other.value == this.value)
      case _ => false
    }
  
  //let hashCode be related to the value
  override def hashCode = this.toString.##
}

object Integer{
  implicit def intToReal(n: Integer) = Real(n.value.toDouble)
}