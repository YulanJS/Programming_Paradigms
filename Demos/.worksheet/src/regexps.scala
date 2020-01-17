object regexps {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet");$skip(135); 
  
  // tokens ::= number | identifier | operator
  // number ::= nat | int | real
  
  val nat = "0|[1-9][0-9]*";System.out.println("""nat  : String = """ + $show(nat ));$skip(20); val res$0 =  //don't start with 0
  "23".matches(nat);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(21); val res$1 = 
  "007".matches(nat);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(52); 
  
  val int = "0|(\\+|-)?[1-9][0-9]*";System.out.println("""int  : String = """ + $show(int ));$skip(283); //avoid +0 -0
  //problem: + means 1 or more in regex, I want + to mean positive sign
  // "I said "\hello\" " //  distinguish between quotes in string and string end sign
  // There is no \+ in syntax; escape symbols
  //another way: single \ with """ """
  val inte = """0|(\+|-)?[1-9][0-9]*""";System.out.println("""inte  : String = """ + $show(inte ));$skip(21); val res$2 = 
  "+23".matches(int);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(22); val res$3 = 
  "+23".matches(inte);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(112); 
  
  // Good:-0.0001 bad: -0
  // . means a single character in regex
  val real = "(\\+|-)?[0-9]*(\\.[0-9]+)?";System.out.println("""real  : String = """ + $show(real ));$skip(23); val res$4 = 
  "+007".matches(real);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(27); val res$5 = 
  "-0.00001".matches(real);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(25); val res$6 = 
  "23&007".matches(real);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(45); 
  
  val identifier = "[a-zA-Z][a-zA-Z0-9]*";System.out.println("""identifier  : String = """ + $show(identifier ));$skip(28); val res$7 = 
  "x23".matches(identifier);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(32); val res$8 = 
  "2forYou".matches(identifier);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(36); 
  
  val operator = "\\+|-|\\*|\\/";System.out.println("""operator  : String = """ + $show(operator ));$skip(24); val res$9 = 
  "-".matches(operator);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(24); val res$10 = 
  "/".matches(operator);System.out.println("""res10: Boolean = """ + $show(res$10))}
}
