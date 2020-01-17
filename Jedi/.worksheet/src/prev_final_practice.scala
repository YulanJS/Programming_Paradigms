object prev_final_practice {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  println("Welcome to the Scala worksheet")}
  object practice_final_prev_year {
	import value._
	import expression._
	import test._
	import context._
  println("Welcome to the Scala worksheet")
  //scala form
  //Jedi form
  
  def swap = lambda(x, y)
  {
  	if(!x isinstanceof[Variable] || !y isinstanceof[Variable])
  	{
  		throw TypeException("x, y must be Variable Type")
  	}
  	def temp = var(0)
  	temp = [x]
  	x = [y]
  	y = [temp]
  }
  
  
  /*
  def a = var(10)
  def b = var(20)
  swap(a, b)
  a
  b
  */
  
  /*
  def sumPairs = lambda(n)
  {
  	//nested iteration
  	//sumPairs(3) = (0 + 0) + (0 + 1) + ...
  	//0... n - 1 //What is n
  	def i = var(0)
  	def j = var(0)
  	def sum = var(0)
    while([i] < n)
    {
    	while([j] < n)
    	{
    		sum = [sum] + [j]
    	}
    	sum = [sum] + [i]
    }
    [sum]
  }
  */
}
}
