object prac {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
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
  }                                               //> addPositives: (list: List[Option[Int]])Int
 
  addPositives(List(Option(3), None, Option(4), Option(-5)))
                                                  //> res0: Int = 7
  //map, filter, reduce
  
  def select(elem: Option[Int]): Boolean =
  {
  	elem match
  	{
  		case Some(a) if a > 0 => true
  		case _ => false
  	}
  }                                               //> select: (elem: Option[Int])Boolean
  
  def deoptionize(elem: Option[Int]): Int =
  {
  	elem match
  	{
  		case Some(a) => a
  		case None => 0
  	}
  }                                               //> deoptionize: (elem: Option[Int])Int
  
  def addPositives0(list: List[Option[Int]]): Int =
  {
  	//pick out; then get Int; +
  	list.filter(select(_)).map(deoptionize(_)).reduce(_ + _)
  }                                               //> addPositives0: (list: List[Option[Int]])Int
  addPositives0(List(Option(3), None, Option(4), Option(-5)))
                                                  //> res1: Int = 7
                                                  
}