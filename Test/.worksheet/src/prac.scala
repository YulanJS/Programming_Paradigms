object prac {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(527); 
  //No.3 write in scala
  //tail recursion
  def addPositives(list: List[Option[Int]]): Int =
  //addPositives(List(Option(3), None, Option(4), Option(-5))) // = 3 + 4 = 7
  {
  	def helper(result: Int, unseen: List[Option[Int]]): Int =
  	{
  		if(unseen == Nil) result
  		else
  		{
  			unseen.head match
  			{
  				case Some(a) if a > 0 => helper(result + a, unseen.tail)
  				case Some(a) if a <= 0 => helper(result, unseen.tail)
  				case None => helper(result, unseen.tail)
  			}
  		}
  	}
  	helper(0, list)
  };System.out.println("""addPositives: (list: List[Option[Int]])Int""");$skip(63); val res$0 = 
 
  addPositives(List(Option(3), None, Option(4), Option(-5)));System.out.println("""res0: Int = """ + $show(res$0));$skip(156); 
  //map, filter, reduce
  
  def select(elem: Option[Int]): Boolean =
  {
  	elem match
  	{
  		case Some(a) if a > 0 => true
  		case _ => false
  	}
  };System.out.println("""select: (elem: Option[Int])Boolean""");$skip(120); 
  
  def deoptionize(elem: Option[Int]): Int =
  {
  	elem match
  	{
  		case Some(a) => a
  		case None => 0
  	}
  };System.out.println("""deoptionize: (elem: Option[Int])Int""");$skip(154); 
  
  def addPositives0(list: List[Option[Int]]): Int =
  {
  	//pick out; then get Int; +
  	list.filter(select(_)).map(deoptionize(_)).reduce(_ + _)
  };System.out.println("""addPositives0: (list: List[Option[Int]])Int""");$skip(62); val res$1 = 
  addPositives0(List(Option(3), None, Option(4), Option(-5)));System.out.println("""res1: Int = """ + $show(res$1))}
                                                  
}
