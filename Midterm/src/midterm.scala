
import scala.math. _
object midterm extends App {
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
		
		
		val k1 = new Knight("Drobot")
		
		val k2 = new Knight("Baldimore")
		
		k1.strategy = Mace
		k2.strategy = new CompositeStrategy(List(Mace, Stab, Stab))
		k1.attack(k2)
		k2.attack(k1)
}