object Apr11 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(17); val res$0 = 
  2 == 2 == true;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(296); 
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
  };System.out.println("""equals: (vals: List[Int])Boolean""");$skip(27); val res$1 = 
  
  equals(List(2, 2, 4));System.out.println("""res1: Boolean = """ + $show(res$1));$skip(24); val res$2 = 
  equals(List(1, 1, 1));System.out.println("""res2: Boolean = """ + $show(res$2));$skip(107); 
  try{
  	var a = 1
  	var b = a.asInstanceOf[Boolean]
  }
  catch{
  	case e: Exception => println(e)
  }}
}
