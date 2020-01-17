object midReview1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet")
  import scala.collection.mutable.ArrayBuffer;$skip(215); 
  def decode(list: List[String]): String =
  {
  	if(list.filter(_.length >= 4) == null) " "
  	else list.filter(_.length >= 4).map(_.substring(2, 4)).reduce(_ + _)
  };System.out.println("""decode: (list: List[String])String""");$skip(63); val res$0 = 
  decode(List("I hate", "to", "get", "back", "mid", "-terms"))
                                                  
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
  };System.out.println("""res0: String = """ + $show(res$0));$skip(815); 
  	val cart = new Cart;System.out.println("""cart  : midReview1.Cart = """ + $show(cart ));$skip(29); val res$1 = 
		cart.add(Toy(3, 5, 19.99));System.out.println("""res1: scala.collection.mutable.ArrayBuffer[midReview1.Item] = """ + $show(res$1));$skip(43); val res$2 = 
		cart.add(Book("Scala for Poets", 22.99));System.out.println("""res2: scala.collection.mutable.ArrayBuffer[midReview1.Item] = """ + $show(res$2));$skip(41); val res$3 = 
		cart.add(Book("OOP for Jocks", 18.25));System.out.println("""res3: scala.collection.mutable.ArrayBuffer[midReview1.Item] = """ + $show(res$3));$skip(13); val res$4 = 
		cart.total;System.out.println("""res4: Double = """ + $show(res$4));$skip(195); 
		
		def listRecur[T, S](nilVal: S, combiner: (T, S)=>S): List[T]=>S =
		{
			def r(list: List[T]): S =
			{
				if(list == Nil) nilVal
				else combiner(list.head, r(list.tail))
			}
			r _
		};System.out.println("""listRecur: [T, S](nilVal: S, combiner: (T, S) => S)List[T] => S""");$skip(108); 
		
		def sum(list: List[Double]): Double =
		{
			listRecur(0.0, (x: Double, y: Double) => x + y)(list)
		};System.out.println("""sum: (list: List[Double])Double""");$skip(110); 
		
		def concat(list: List[String]): String =
		{
			listRecur("", (x: String, y: String) => x + y)(list)
		};System.out.println("""concat: (list: List[String])String""");$skip(30); val res$5 = 
		
		sum(List(1.0, 2.0, 3.0));System.out.println("""res5: Double = """ + $show(res$5));$skip(37); val res$6 = 
		concat(List("say", "hat", "chin"));System.out.println("""res6: String = """ + $show(res$6))}
		
}
