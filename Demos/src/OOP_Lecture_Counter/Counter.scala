package OOP_Lecture_Counter

class Counter(val modulus: Int = 8, private var count: Int = 0) {
  //constructors can have default values
  def inc() { count = (count + 1) % modulus }
  def getCount = count
}

//companion object
object Counter{
  def apply(modulus: Int = 8, count: Int = 0) = new Counter(modulus, count)
  
  def test()
  {
    val c = new Counter
    c.inc()
    c.inc()
    //auto generated getters and setters
    println("c.count = " + c.getCount)
    // calling getCount //private count causes errors here. calling getCount
    
    c.count = 12 // callling setCount
    println("c.count = " + c.getCount)
    println("c.modulus = " + c.modulus)
    //c.modulus = 10: error
    //val modulus, cannot be changed, doesn't have a setter
    val c2 = Counter(3) //are calling apply
    c2.inc()
    c2.inc()
    c2.inc()
    println("c2.count = " + c2.getCount)
  }
}
