object accumulator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  println("Welcome to the Scala worksheet")
  
  //trait can have concrete methods: already implemented
  trait Operation {def execute(r: Int): Int}
  class Add(n: Int) extends Operation {
    def execute(r: Int) = r + n //execute can have input parameters: register
  }
  
  object Add {def apply(n: Int) = new Add(n)}
  
  class Mul(n: Int) extends Operation {
    def execute(r: Int) = r * n
  }
  
  object Mul {def apply(n: Int) = new Mul(n)}
  
  //var ins: Operation = null
  //ins = new Add(3) // parent child
  
  object Accumulator
  {
    var reg = 0
    var program = List[Operation]()
    def register = reg
    def register_=(r: Int)= reg = r
    def run()=
    {
      for(inst <- program)
      {
        inst match{
          case a: Add => reg = a.execute(reg) //update reg value
          case m: Mul => reg = m.execute(reg)
          case _ => println("Error: no such operation")
        }
      }
      //println("register value: " + register)
    }
    
  };$skip(1029); 
  //computing ((3 * 5) + 1) * 2
  Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2));$skip(20); 
  Accumulator.run();$skip(23); val res$0 = 
  Accumulator.register;System.out.println("""res0: Int = """ + $show(res$0));$skip(63); 
  // computing (((10 * 2) + 3) * 5)
  Accumulator.register = 0;$skip(62); 
  Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5));$skip(20); 
  Accumulator.run();$skip(23); val res$1 = 
  Accumulator.register;System.out.println("""res1: Int = """ + $show(res$1))}
}
