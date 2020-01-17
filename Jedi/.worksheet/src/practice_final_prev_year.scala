object practice_final_prev_year {
	import value._
	import expression._
	import test._
	import context._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(147); 
  println("Welcome to the Scala worksheet");$skip(357); 
  //scala form
  //Jedi form
  def swap = lambda(x, y)
  {
  	//else? throws an exception? why throw an exception?
  	//x, y must be variable type, otherwise, exception
  	//if(!x isinstanceof[Variable] || !y isinstanceof[Variable])
  		//throw TypeException("x, y must be Variable Type")
  	def temp = var(0);
  	temp = [x];
  	x = [y];
  	y = [temp];
  };System.out.println("""swap: => <error>""");$skip(21); 
  
  def a = var(10);System.out.println("""a: => Null#5850""");$skip(18); 
  def b = var(20);System.out.println("""b: => Null#5850""");$skip(13); val res$0 = 
  swap(a, b);System.out.println("""res0: <error> = """ + $show(res$0));$skip(4); val res$1 = 
  a;System.out.println("""res1: Null#5850 = """ + $show(res$1));$skip(4); val res$2 = 
  b;System.out.println("""res2: Null#5850 = """ + $show(res$2))}
  
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
