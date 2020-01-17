object Apr11 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  2 == 2 == true                                  //> res0: Boolean = true
  def equals(vals: List[Int]): Boolean =
  {
  	vals.map(_==vals(0)).reduce(_&&_)
  	//equals
  	//how to check if all integers in the List are equal...
  	/*
  	var result = true
	  for(i <- 0 until vals.length if result)
	  {
	    if(vals(i) != vals(0)) result = false
	  }
	  result
	  */
  }                                               //> equals: (vals: List[Int])Boolean
  
  equals(List(2, 2, 4))                           //> res1: Boolean = false
  equals(List(1, 1, 1))                           //> res2: Boolean = true
  try{
  	var a = 1
  	var b = a.asInstanceOf[Boolean]
  }
  catch{
  	case e: Exception => println(e)
  }                                               //> java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.
                                                  //| Boolean
}