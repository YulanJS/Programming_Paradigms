object practice {
  println("Welcome to the Scala worksheet")
  //No.3 write in scala
  //tail recursion
  1 + 2
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
  }
 
  addPositives(List(Option(3), None, Option(4), Option(-5)))
  //map, filter, reduce
}