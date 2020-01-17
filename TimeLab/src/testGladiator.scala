object testGladiator extends App {
  class Gladiator(val name: String) {
    protected var health = 100 // for subclasses to see it
    //don't hope users to initialize it 
  
    def damage(amount: Int){
      if (amount > health)health = 0 else health -= amount
    }
  
    def attack(opponent: Gladiator){
        if(health == 0) println(name + " is dead: cannot attack" + opponent.name)
        else{
          println(opponent.name + " takes 5 damage.")
          opponent.damage(5)
        }
    }
    def getHealth = health
  }

  class CrusherMasher(name: String) extends Gladiator(name) with Crusher with Masher() {
    override def attack(opponent: Gladiator) = {
      if(health == 0) println(name + " is dead: cannot attack" + opponent.name)
      else
      {
        super.attack(opponent)
        crush(opponent)
        mash(opponent)
      }
    }
  }

  object BumbleBee extends Gladiator("bumbleBee") with Slasher with Masher {
    override def attack(opponent: Gladiator) = {
      if(health == 0) println(name + " is dead: cannot attack" + opponent.name)
      else
      {
        super.attack(opponent)
        slash(opponent)
        mash(opponent)
      }   
    }
  }

  trait Slasher {
    def slash(opponent: Gladiator) = {      
      println(opponent.name + " gets slashed and takes 10 damage.")
      opponent.damage(10)
    }
  }

  trait Masher {
    def mash(opponent: Gladiator) = {
      println(opponent.name + " gets mashed and takes 10 damage.")
      opponent.damage(10)
    }
  }

  trait Crusher {
    def crush(opponent: Gladiator) {
      println(opponent.name + " gets crushed and takes 10 damage.")
      opponent.damage(10)
    }
  }
  
  val maximus = new CrusherMasher("Maximus")
  val bee = BumbleBee
  for(i <- 0 to 5){
    maximus.attack(bee)
    println("BumbleBee's health:" + bee.getHealth)
    bee.attack(maximus)
    println("Maximus's health:" + maximus.getHealth)
    println()
  }
  
  
  /*
   * bumbleBee takes 5 damage.
  bumbleBee gets crushed and takes 10 damage.
  bumbleBee gets mashed and takes 10 damage.
  BumbleBee's health:75
  Maximus takes 5 damage.
  Maximus gets slashed and takes 10 damage.
  Maximus gets mashed and takes 10 damage.
  Maximus's health:75
  
  bumbleBee takes 5 damage.
  bumbleBee gets crushed and takes 10 damage.
  bumbleBee gets mashed and takes 10 damage.
  BumbleBee's health:50
  Maximus takes 5 damage.
  Maximus gets slashed and takes 10 damage.
  Maximus gets mashed and takes 10 damage.
  Maximus's health:50
  
  bumbleBee takes 5 damage.
  bumbleBee gets crushed and takes 10 damage.
  bumbleBee gets mashed and takes 10 damage.
  BumbleBee's health:25
  Maximus takes 5 damage.
  Maximus gets slashed and takes 10 damage.
  Maximus gets mashed and takes 10 damage.
  Maximus's health:25
  
  bumbleBee takes 5 damage.
  bumbleBee gets crushed and takes 10 damage.
  bumbleBee gets mashed and takes 10 damage.
  BumbleBee's health:0
  bumbleBee is dead: cannot attackMaximus
  Maximus's health:25
  
  bumbleBee takes 5 damage.
  bumbleBee gets crushed and takes 10 damage.
  bumbleBee gets mashed and takes 10 damage.
  BumbleBee's health:0
  bumbleBee is dead: cannot attackMaximus
  Maximus's health:25
  
  bumbleBee takes 5 damage.
  bumbleBee gets crushed and takes 10 damage.
  bumbleBee gets mashed and takes 10 damage.
  BumbleBee's health:0
  bumbleBee is dead: cannot attackMaximus
  Maximus's health:25
	*/
}