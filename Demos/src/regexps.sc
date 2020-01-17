object regexps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // tokens ::= number | identifier | operator
  // number ::= nat | int | real
  
  val nat = "0|[1-9][0-9]*" //don't start with 0  //> nat  : String = 0|[1-9][0-9]*
  "23".matches(nat)                               //> res0: Boolean = true
  "007".matches(nat)                              //> res1: Boolean = false
  
  val int = "0|(\\+|-)?[1-9][0-9]*"//avoid +0 -0  //> int  : String = 0|(\+|-)?[1-9][0-9]*
  //problem: + means 1 or more in regex, I want + to mean positive sign
  // "I said "\hello\" " //  distinguish between quotes in string and string end sign
  // There is no \+ in syntax; escape symbols
  //another way: single \ with """ """
  val inte = """0|(\+|-)?[1-9][0-9]*"""           //> inte  : String = 0|(\+|-)?[1-9][0-9]*
  "+23".matches(int)                              //> res2: Boolean = true
  "+23".matches(inte)                             //> res3: Boolean = true
  
  // Good:-0.0001 bad: -0
  // . means a single character in regex
  val real = "(\\+|-)?[0-9]*(\\.[0-9]+)?"         //> real  : String = (\+|-)?[0-9]*(\.[0-9]+)?
  "+007".matches(real)                            //> res4: Boolean = true
  "-0.00001".matches(real)                        //> res5: Boolean = true
  "23&007".matches(real)                          //> res6: Boolean = false
  
  val identifier = "[a-zA-Z][a-zA-Z0-9]*"         //> identifier  : String = [a-zA-Z][a-zA-Z0-9]*
  "x23".matches(identifier)                       //> res7: Boolean = true
  "2forYou".matches(identifier)                   //> res8: Boolean = false
  
  val operator = "\\+|-|\\*|\\/"                  //> operator  : String = \+|-|\*|\/
  "-".matches(operator)                           //> res9: Boolean = true
  "/".matches(operator)                           //> res10: Boolean = true
}