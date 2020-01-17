object Feb28 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //list processing 1 No.3:
  //(((1, 2, (3)))) left parenthesis 4
  
  
  def isList(a: Any) = a.isInstanceOf[List[_]]    //> isList: (a: Any)Boolean
  isList(List(1))                                 //> res0: Boolean = true
  isList(1)                                       //> res1: Boolean = false
  Map("one"-> 1).isInstanceOf[List[_]]            //> res2: Boolean = false
  //1.isInstanceOf[List[_]] doesn't work
  //isInstanceOf cannot test if value types are references.
  
  
}