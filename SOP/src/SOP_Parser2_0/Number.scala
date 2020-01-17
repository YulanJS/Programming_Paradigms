package SOP_Parser2_0
case class Number(val value: Double) extends Expression 
{ 
  def execute = value 
}
