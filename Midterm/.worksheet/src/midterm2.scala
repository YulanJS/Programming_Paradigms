object midterm2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet")
  import scala.math._
  //1
  
  class Entry(val temp: Double, val mon: Int, val day: Int){};$skip(147); 
  
  def cToF(c: Entry): Double = c.temp * 1.8 + 32.0;System.out.println("""cToF: (c: midterm2.Entry)Double""");$skip(286); 
  
  def avgTemp(month: Int, log: List[Entry]): Double =
  	//average temperature in degrees Fahrenheit for all readings taken in month
	{
		var list: List[Double] = log.filter((elem: Entry) => elem.mon == month).map(cToF _)
		if(list == Nil) 0
		else list.reduce(_ + _) / list.size
	};System.out.println("""avgTemp: (month: Int, log: List[midterm2.Entry])Double""");$skip(125); 
	
	val log = List(new Entry(20, 1, 1), new Entry(25, 1, 2), new Entry(15, 2, 2), new
		Entry(10, 1, 3), new Entry(22, 6, 5));System.out.println("""log  : List[midterm2.Entry] = """ + $show(log ));$skip(18); val res$0 = 
		avgTemp(1, log)
		
			//3.
		trait Value
		
		class Number(val value: Int) extends Value {
			override def toString = "Number(" + value + ")"
		}
			
		class Boole(val value: Boolean) extends Value {
			override def toString = "Boole(" + value + " )"
		};System.out.println("""res0: Double = """ + $show(res$0));$skip(461); 
		
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
		};System.out.println("""lift: (f: Int => Int)midterm2.Value => Option[midterm2.Number]""");$skip(45); 
		
		val numSquare = lift((n: Int) => n * n);System.out.println("""numSquare  : midterm2.Value => Option[midterm2.Number] = """ + $show(numSquare ));$skip(27); val res$1 = 
		numSquare(new Number(7));System.out.println("""res1: Option[midterm2.Number] = """ + $show(res$1));$skip(29); val res$2 = 
		numSquare(new Boole(true))
		
	
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
		};System.out.println("""res2: Option[midterm2.Number] = """ + $show(res$2));$skip(1112); 
		
		
		val k1 = new Knight("Drobot");System.out.println("""k1  : midterm2.Knight = """ + $show(k1 ));$skip(38); 
		
		val k2 = new Knight("Baldimore");System.out.println("""k2  : midterm2.Knight = """ + $show(k2 ));$skip(24); 
		
		k1.strategy = Mace;$skip(62); 
		k2.strategy = new CompositeStrategy(List(Mace, Stab, Stab));$skip(16); 
		k1.attack(k2);$skip(16); 
		k2.attack(k1)}
}
