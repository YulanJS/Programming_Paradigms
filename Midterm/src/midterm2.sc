object midterm2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  import scala.math._
  //1
  
  class Entry(val temp: Double, val mon: Int, val day: Int){}
  
  def cToF(c: Entry): Double = c.temp * 1.8 + 32.0//> cToF: (c: midterm2.Entry)Double
  
  def avgTemp(month: Int, log: List[Entry]): Double =
  	//average temperature in degrees Fahrenheit for all readings taken in month
	{
		var list: List[Double] = log.filter((elem: Entry) => elem.mon == month).map(cToF _)
		if(list == Nil) 0
		else list.reduce(_ + _) / list.size
	}                                         //> avgTemp: (month: Int, log: List[midterm2.Entry])Double
	
	val log = List(new Entry(20, 1, 1), new Entry(25, 1, 2), new Entry(15, 2, 2), new
		Entry(10, 1, 3), new Entry(22, 6, 5))
                                                  //> log  : List[midterm2.Entry] = List(midterm2$Entry$1@2f7a2457, midterm2$Entry
                                                  //| $1@1554909b, midterm2$Entry$1@6bf256fa, midterm2$Entry$1@6cd8737, midterm2$E
                                                  //| ntry$1@22f71333)
		avgTemp(1, log)                   //> res0: Double = 65.0
		
			//3.
		trait Value
		
		class Number(val value: Int) extends Value {
			override def toString = "Number(" + value + ")"
		}
			
		class Boole(val value: Boolean) extends Value {
			override def toString = "Boole(" + value + " )"
		}
		
		def lift(f: Int => Int): Value => Option[Number] =
		{
			def r(input: Value): Option[Number] =
			{
				input match
				{
					case n: Number => Some(new Number(f(n.value)))
					case _ => None
				}
			}
			r _
		}                                 //> lift: (f: Int => Int)midterm2.Value => Option[midterm2.Number]
		
		val numSquare = lift((n: Int) => n * n)
                                                  //> numSquare  : midterm2.Value => Option[midterm2.Number] = midterm2$$$Lambda$
                                                  //| 16/335471116@4e04a765
		numSquare(new Number(7))          //> res1: Option[midterm2.Number] = Some(Number(49))
		numSquare(new Boole(true))        //> res2: Option[midterm2.Number] = None
		
	
		//2.
  class Knight(val name: String)
		{
			var health: Int = 100
			var strategy: AttackStrategy = null
			def attack(opponent: Knight): Unit =
			{
			  if(this.health <= 0) println(this.name + " dead: cannot attack")
				else
				{
				  println(this.name + " is attacking " + opponent.name)
				  strategy.attack(opponent)
				}
			  println(opponent.name +" health: " + opponent.health)
			}
		}
		
		trait AttackStrategy
		{
			def attack(opponent: Knight): Unit
		}
		
		object Stab extends AttackStrategy
		{
			override def attack(opponent: Knight): Unit =
			{
				println("Stabing")
				opponent.health = max(opponent.health - 15, 0)
			}
		}
		
		object Mace extends AttackStrategy
		{
			override def attack(opponent: Knight): Unit =
			{
				println("Macing")
				opponent.health = max(opponent.health - 10, 0)
			}
		}
		
		class CompositeStrategy(strategyList: List[AttackStrategy]) extends AttackStrategy
		{
			override def attack(opponent: Knight): Unit =
			{
				for(strategy <- strategyList)
				{
					strategy.attack(opponent)
				}
			}
		}
		
		
		val k1 = new Knight("Drobot")     //> k1  : midterm2.Knight = midterm2$Knight$1@735f7ae5
		
		val k2 = new Knight("Baldimore")  //> k2  : midterm2.Knight = midterm2$Knight$1@180bc464
		
		k1.strategy = Mace
		k2.strategy = new CompositeStrategy(List(Mace, Stab, Stab))
		k1.attack(k2)                     //> Drobot is attacking Baldimore
                                                  //| Macing
                                                  //| Baldimore health: 90
		k2.attack(k1)                     //> Baldimore is attacking Drobot
                                                  //| Macing
                                                  //| Stabing
                                                  //| Stabing
                                                  //| Drobot health: 60
}