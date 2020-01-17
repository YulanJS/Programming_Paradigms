package SOP_Parser2_0
case class Product(val operand1: Expression, val operands: List[Expression] = Nil) extends Expression 
{ 
  def execute = 
    if (operands == Nil) operand1.execute 
    else operand1.execute * operands.map(_.execute).reduce(_*_) 
}
