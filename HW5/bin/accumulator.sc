object accumulator {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
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
    
  }
  //computing ((3 * 5) + 1) * 2
  Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
  Accumulator.run()
  Accumulator.register                            //> res0: Int = 32
  // computing (((10 * 2) + 3) * 5)
  Accumulator.register = 0
  Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5))
  Accumulator.run()
  Accumulator.register                            //> res1: Int = 115
}