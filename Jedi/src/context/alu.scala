package context


  
import expression._
import value._


/*
 * Notes:
 * alu implements all low-level arithmetic, logic, and I/O functions
 * alu does lots of type checking
 * alu is a singleton
 */
object alu {
  // dispatcher
  def execute(opcode: Identifier, args: List[Value]): Value = {
    opcode.name match {
      case "add" => add(args)
      case "mul" => mul(args)
      case "sub" => sub(args)
      case "div" => div(args)
      case "less" => less(args) //binary
      case "more" => more(args) // binary
      case "equals" => equals(args) // note: equals(7, true) = false, not error
      case "unequals" => unequals(args) // binary, = not(equals(args))?
      case "not" => not(args) // unary
      // primitive I/O ops:
      case "write" => write(args)
      case "prompt" => prompt(args)
      case "read" => read(args)
      case _ => throw new UndefinedException(opcode)
    }
  }
  
  private def toInt(arg: Value): Option[Integer] =
      if (arg.isInstanceOf[Integer]) Some(arg.asInstanceOf[Integer]) else None
      
    private def toReal(arg: Value): Option[Real] =
      if (arg.isInstanceOf[Real]) Some(arg.asInstanceOf[Real]) 
      //intToReal is in singleton Integer in Integer class
      else if (arg.isInstanceOf[Integer]) Some(Integer.intToReal(arg.asInstanceOf[Integer]))
      else None
      
    private def toChars(arg: Value): Option[Chars] =
      if (arg.isInstanceOf[Chars]) Some(arg.asInstanceOf[Chars]) else None
      
    private def add(args: List[Value]) = {
      //toInt is defined just above  //toInt: Some() or None
      val args2 = args.map(toInt).filter(_ != None) 
      //List[Some(Integer)], flattens it to List[Integer]
      if (args2.size == args.size) args2.flatten.reduce(_+_)
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) args3.flatten.reduce(_+_)
        else {
          val args4 = args.map(toChars).filter(_ != None)
          if (args4.size == args.size) args4.flatten.reduce(_+_)
          else {
            throw new TypeException("Inputs to + must be numbers or texts")
          }
        }
      }
    }
  
  def less(args: List[Value]): Value = {
      if (args.length  != 2) throw new TypeException("less expects two inputs")
      val args2 = args.map(toInt).filter(_ != None)
      if (args2.size == args.size) Boole(args2(0) < args2(1))
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) Boole(args3(0) < args3(1))
        else {
          val args4 = args.map(toChars).filter(_ != None)
          if (args4.size == args.size) Boole(args4(0) < args4(1))
          else throw new TypeException("Inputs to < must be numbers or texts")
        }
      }
   }  
  
   private def mul(args: List[Value]) = {
      //toInt is defined just above  //toInt: Some() or None
      val args2 = args.map(toInt).filter(_ != None) 
      //List[Some(Integer)], flattens it to List[Integer]
      if (args2.size == args.size) args2.flatten.reduce(_*_)
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) args3.flatten.reduce(_*_)
        else {
          throw new TypeException("Inputs to * must be numbers")
        }
      }
    }
  
   private def sub(args: List[Value]) = {
      //toInt is defined just above  //toInt: Some() or None
      val args2 = args.map(toInt).filter(_ != None) 
      //List[Some(Integer)], flattens it to List[Integer]
      if (args2.size == args.size) args2.flatten.reduce(_-_)
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) args3.flatten.reduce(_-_)
        else {
          throw new TypeException("Inputs to - must be numbers")      
        }
      }
    }
  
   private def div(args: List[Value]) = {
      //toInt is defined just above  //toInt: Some() or None
      val args2 = args.map(toInt).filter(_ != None) 
      //List[Some(Integer)], flattens it to List[Integer]
      if (args2.size == args.size) args2.flatten.reduce(_/_)
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) args3.flatten.reduce(_/_)
        else {
            throw new TypeException("Inputs to / must be numbers")       
        }
      }
    }
  
  def more(args: List[Value]): Value = {
      if (args.length  != 2) throw new TypeException("less expects two inputs")
      val args2 = args.map(toInt).filter(_ != None)
      if (args2.size == args.size) Boole(args2(0) > args2(1))
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) Boole(args3(0) > args3(1))
        else {
          val args4 = args.map(toChars).filter(_ != None)
          if (args4.size == args.size) Boole(args4(0) > args4(1))
          else throw new TypeException("Inputs to < must be numbers or texts")
        }
      }
   }  
  
   //equals don't throw exceptions: No type checking, just return false for different types
  //it will automatically calls the equals method in your defined class
  //at least one arg in List
   def equals(vals: List[Value]): Value = {
     //doesn't require binary
     if (vals == Nil) throw new TypeException("equals expects at least one input")
     val args2 = vals.map(toInt).filter(_ != None)
      if (args2.size == vals.size) Boole(args2.map(_ == args2(0)).reduce(_&&_))
      else {
        val args3 = vals.map(toReal).filter(_ != None)
        if (args3.size == vals.size) Boole(args3.map(_ == args3(0)).reduce(_&&_))
        else {
          val args4 = vals.map(toChars).filter(_ != None)
          if (args4.size == vals.size) Boole(args4.map(_ == args4(0)).reduce(_&&_))
          else Boole(false)
        }
      }
   }
   
   //not(alu.equals(List()))
   def unequals(vals: List[Value]): Value = {
    if (vals.length != 2) throw new TypeException("unequals expects two inputs")
    not(List(equals(vals))) //not accepts List
  }
   
   //unary
   
   def not(vals: List[Value]): Value = {
    if (vals.length != 1) throw new TypeException("not expects two inputs")
    try {
      //Boole has ! method returns true or false, Boole() change it to Boole type
      !(vals(0).asInstanceOf[Boole])
    } catch {
      case e: TypeException => throw new TypeException("not expects a Boole type")
    }
  }
   
   def write(vals: List[Value]): Value = { println(vals(0)); Notification.DONE }
   def read(vals: List[Value]): Value = { val result = io.StdIn.readDouble(); Real(result)}
   def prompt(vals: List[Value]): Value = { print("=> "); Notification.DONE }
   
    
}