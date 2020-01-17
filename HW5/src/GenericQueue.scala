import scala.collection.mutable.ArrayBuffer

class GenericQueue[T] {
  private val elements = new ArrayBuffer[T]
  //No type T after enqueue: def enqueue[T] is wrong
  def enqueue(elem: T) = elements += elem
  //ArrayBuffer similar to ArrayList in java
  def dequeue() = elements.remove(0)
  def isEmpty = elements.size == 0
  override def toString = {
    var result = "Queue: "
    for(elem <- elements) result += elem.toString + " "
    result
  }  
}

object GenericQueue{
  def apply[T] = new GenericQueue[T]
  def testQueue = 
  {
      val waitingList = GenericQueue[String]
      waitingList.enqueue("a")
      waitingList.enqueue("b")
      waitingList.enqueue("c")
      waitingList.enqueue("d")
      waitingList.enqueue("e")
      println(waitingList)
      while(!waitingList.isEmpty)
      {
        waitingList.dequeue
        println(waitingList)
      }
  }
}