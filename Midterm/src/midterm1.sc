object midterm1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  class Number(val value: Int)
  {
  	override def toString = "Num ber(" + value + ")"
  }
  
  def lift(f: Int => Int): Number => Number =
  {
  	def r(num: Number): Number =
  	{
  		new Number(f(num.value))
  	}
  	r _
  }                                               //> lift: (f: Int => Int)midterm1.Number => midterm1.Number
  val numSquare = lift((n: Int) => n * n)         //> numSquare  : midterm1.Number => midterm1.Number = midterm1$$$Lambda$9/312116
                                                  //| 338@27f674d
  numSquare(new Number(7))                        //> res0: midterm1.Number = Num ber(49)
  
  //2 using recursion //assume list1 list2 equal length
  def map2[T, S, U](list1: List[S], list2: List[T], combiner: (S, T)=>U): List[U] =
  {
  	def helper(unseen1: List[S], unseen2: List[T], result: List[U]): List[U] =
  	{
  		if(unseen1 == Nil) result
  		else helper(unseen1.tail, unseen2.tail, result:+combiner(unseen1.head, unseen2.head))
  		// here using list1.head list2.head, mistake. should use unseen1.head
  	}
  	helper(list1, list2, List[U]())
  }                                               //> map2: [T, S, U](list1: List[S], list2: List[T], combiner: (S, T) => U)List[U
                                                  //| ]
  map2(List(2, 3, 4), List(6, 7, 8), (x: Int, y: Int) => x + y)
                                                  //> res1: List[Int] = List(8, 10, 12)
  
  //3. strategies are lambdas
  class Warrior(val name: String)
  {
  	var health: Int = 100
  	var strategy: Warrior => Unit = null
  	def attack(opponent: Warrior) =
  	{
  		if(health > 0)
  		{
  			println(name + " is fighting " + opponent.name)
  			strategy(opponent)
  			println(opponent.name + "health: " + opponent.health)
  		}
  	}
  }
  
  def spitFire(opponent: Warrior)
  {
  	println("Spits fire")
  	opponent.health -= 10
  }                                               //> spitFire: (opponent: midterm1.Warrior)Unit
  
  def stomp(opponent: Warrior)
  {
  	println("Stomps")
  	opponent.health -= 7
  }                                               //> stomp: (opponent: midterm1.Warrior)Unit
  
  def makeCompositeStrategy(list: List[Warrior => Unit]): Warrior => Unit =
  {
  	def r(oppo: Warrior): Unit =
  	{
  		for(elem <- list) elem(oppo)
  	}
  	r _
  }                                               //> makeCompositeStrategy: (list: List[midterm1.Warrior => Unit])midterm1.Warri
                                                  //| or => Unit
  val red = new Warrior("Red Sonya")              //> red  : midterm1.Warrior = midterm1$Warrior$1@21bcffb5
  val blue = new Warrior("Blue Velvet")           //> blue  : midterm1.Warrior = midterm1$Warrior$1@380fb434
  red.strategy = stomp
  blue.strategy = makeCompositeStrategy(List(spitFire, stomp, spitFire))
  red.attack(blue)                                //> Red Sonya is fighting Blue Velvet
                                                  //| Stomps
                                                  //| Blue Velvethealth: 93
  blue.attack(red)                                //> Blue Velvet is fighting Red Sonya
                                                  //| Spits fire
                                                  //| Stomps
                                                  //| Spits fire
                                                  //| Red Sonyahealth: 73
  
                                                  
                                                  
}