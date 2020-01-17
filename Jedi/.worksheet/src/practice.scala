object practice {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet");$skip(51); val res$0 = 
  //No.3 write in scala
  //tail recursion
  1 + 2;System.out.println("""res0: Int(3) = """ + $show(res$0));$skip(484); 
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
  };System.out.println("""addPositives: (list: List[Option[Int]])Int""");$skip(63); val res$1 = 
 
  addPositives(List(Option(3), None, Option(4), Option(-5)));System.out.println("""res1: Int = """ + $show(res$1))}
  //map, filter, reduce
}
