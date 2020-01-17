object Feb28 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(120); 
  //list processing 1 No.3:
  //(((1, 2, (3)))) left parenthesis 4
  
  
  def isList(a: Any) = a.isInstanceOf[List[_]];System.out.println("""isList: (a: Any)Boolean""");$skip(18); val res$0 = 
  isList(List(1));System.out.println("""res0: Boolean = """ + $show(res$0));$skip(12); val res$1 = 
  isList(1);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(39); val res$2 = 
  Map("one"-> 1).isInstanceOf[List[_]];System.out.println("""res2: Boolean = """ + $show(res$2))}
  //1.isInstanceOf[List[_]] doesn't work
  //isInstanceOf cannot test if value types are references.
  
  
}
