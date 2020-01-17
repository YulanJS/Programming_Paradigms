class MathCalculator extends Calculator 
{ 
  def sin { result = math.sin(result) } 
  def cos { result = math.cos(result) } 
  def tan { result = math.tan(result) } 
  override def help { 
    super.help 
    println("Also: sin, cos, tan") 
  } 
} 