object midterm1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet")
  class Number(val value: Int)
  {
  	override def toString = "Num ber(" + value + ")"
  };$skip(226); 
  
  def lift(f: Int => Int): Number => Number =
  {
  	def r(num: Number): Number =
  	{
  		new Number(f(num.value))
  	}
  	r _
  };System.out.println("""lift: (f: Int => Int)midterm1.Number => midterm1.Number""");$skip(42); 
  val numSquare = lift((n: Int) => n * n);System.out.println("""numSquare  : midterm1.Number => midterm1.Number = """ + $show(numSquare ));$skip(27); val res$0 = 
  numSquare(new Number(7));System.out.println("""res0: midterm1.Number = """ + $show(res$0));$skip(468); 
  
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
  };System.out.println("""map2: [T, S, U](list1: List[S], list2: List[T], combiner: (S, T) => U)List[U]""");$skip(64); val res$1 = 
  map2(List(2, 3, 4), List(6, 7, 8), (x: Int, y: Int) => x + y)
  
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
  };System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(447); 
  
  def spitFire(opponent: Warrior)
  {
  	println("Spits fire")
  	opponent.health -= 10
  };System.out.println("""spitFire: (opponent: midterm1.Warrior)Unit""");$skip(87); 
  
  def stomp(opponent: Warrior)
  {
  	println("Stomps")
  	opponent.health -= 7
  };System.out.println("""stomp: (opponent: midterm1.Warrior)Unit""");$skip(169); 
  
  def makeCompositeStrategy(list: List[Warrior => Unit]): Warrior => Unit =
  {
  	def r(oppo: Warrior): Unit =
  	{
  		for(elem <- list) elem(oppo)
  	}
  	r _
  };System.out.println("""makeCompositeStrategy: (list: List[midterm1.Warrior => Unit])midterm1.Warrior => Unit""");$skip(37); 
  val red = new Warrior("Red Sonya");System.out.println("""red  : midterm1.Warrior = """ + $show(red ));$skip(40); 
  val blue = new Warrior("Blue Velvet");System.out.println("""blue  : midterm1.Warrior = """ + $show(blue ));$skip(23); 
  red.strategy = stomp;$skip(73); 
  blue.strategy = makeCompositeStrategy(List(spitFire, stomp, spitFire));$skip(19); 
  red.attack(blue);$skip(19); 
  blue.attack(red)}
  
                                                  
                                                  
}
