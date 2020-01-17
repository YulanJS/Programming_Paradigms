import scala.math. _
object test extends App {
  def depth(a: Any): Int =
  {
  	a match
  	{
  		case Nil => 0
  		case head::tail => max(depth(head), depth(tail)) + 1
  		case _ => 0
  	}
  }  
  print(depth(List(1, List(2))))
}