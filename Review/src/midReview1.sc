object midReview1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  import scala.collection.mutable.ArrayBuffer
  def decode(list: List[String]): String =
  {
  	if(list.filter(_.length >= 4) == null) " "
  	else list.filter(_.length >= 4).map(_.substring(2, 4)).reduce(_ + _)
  }                                               //> decode: (list: List[String])String
  decode(List("I hate", "to", "get", "back", "mid", "-terms"))
                                                  //> res0: String = hacker
                                                  
  //val price: must have val: won't be assigned directly, so OK?
  class Item(val price: Double){}
  
  //val val notVal: must follow: reason, I don't know
  class Toy(val minAge: Int, val maxAge: Int, price: Double) extends Item(price) {}
  
  object Toy{def apply(minAge: Int, maxAge: Int, price: Double) = new Toy(minAge, maxAge,price)}
  
  class Book(val title: String, price: Double) extends Item(price) {}
  object Book {
  	def apply(title: String, price: Double) = new Book(title, price)
  }
  
  class Cart {
  	var elements = scala.collection.mutable.ArrayBuffer[Item]()
  	def add(elem: Item) =
  	{
  		elements += elem
  	}
  	def total =
  	{
  		if(elements == null) 0.0
  		else elements.map(_.price).reduce(_ + _)
  	}
  }
  	val cart = new Cart                       //> cart  : midReview1.Cart = midReview1$Cart$1@3498ed
		cart.add(Toy(3, 5, 19.99))        //> res1: scala.collection.mutable.ArrayBuffer[midReview1.Item] = ArrayBuffer(m
                                                  //| idReview1$Toy$2@42d3bd8b)
		cart.add(Book("Scala for Poets", 22.99))
                                                  //> res2: scala.collection.mutable.ArrayBuffer[midReview1.Item] = ArrayBuffer(m
                                                  //| idReview1$Toy$2@42d3bd8b, midReview1$Book$2@26ba2a48)
		cart.add(Book("OOP for Jocks", 18.25))
                                                  //> res3: scala.collection.mutable.ArrayBuffer[midReview1.Item] = ArrayBuffer(m
                                                  //| idReview1$Toy$2@42d3bd8b, midReview1$Book$2@26ba2a48, midReview1$Book$2@5f2
                                                  //| 050f6)
		cart.total                        //> res4: Double = 61.23
		
		def listRecur[T, S](nilVal: S, combiner: (T, S)=>S): List[T]=>S =
		{
			def r(list: List[T]): S =
			{
				if(list == Nil) nilVal
				else combiner(list.head, r(list.tail))
			}
			r _
		}                                 //> listRecur: [T, S](nilVal: S, combiner: (T, S) => S)List[T] => S
		
		def sum(list: List[Double]): Double =
		{
			listRecur(0.0, (x: Double, y: Double) => x + y)(list)
		}                                 //> sum: (list: List[Double])Double
		
		def concat(list: List[String]): String =
		{
			listRecur("", (x: String, y: String) => x + y)(list)
		}                                 //> concat: (list: List[String])String
		
		sum(List(1.0, 2.0, 3.0))          //> res5: Double = 6.0
		concat(List("say", "hat", "chin"))//> res6: String = sayhatchin
		
}