package SOP_Parser2_0
case class Sum(val operand1: Expression, val operand2: Expression = null) extends Expression 
{ 
  def execute = 
    if (operand2 == null) operand1.execute 
    else operand1.execute + operand2.execute 
}

