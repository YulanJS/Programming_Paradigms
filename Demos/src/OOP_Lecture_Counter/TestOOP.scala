package OOP_Lecture_Counter

object TestOOP extends App{
  val c = new Counter(5, 8)
  c.inc()
  c.inc()
  //auto generated getters and setters
  println("c.count = " + c.getCount)
  // calling getCount //private count causes errors here. calling getCount
  
  //c.setCount = 12 
  // calling setCount automatically, but when count it private, cannot do this
  println("c.count = " + c.getCount)
  println("c.modulus = " + c.modulus)
  //c.modulus = 10: error
  //val modulus, cannot be changed, doesn't have a setter
}