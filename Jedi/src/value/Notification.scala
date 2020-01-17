package value

class Notification(val message: String) extends Value{
   //OK DONE UNSPECIFIED
  override def toString = message
}
object Notification{
  def apply(str: String) = new Notification(str) 
  val OK = Notification("OK")
  val DONE = Notification("DONE")
  val UNSPECIFIED = Notification("UNSPECIFIED")
}