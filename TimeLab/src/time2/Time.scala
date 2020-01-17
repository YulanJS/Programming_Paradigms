

package time2

class Time(private var h: Int, private var m: Int = 0) {
  //hours_= 
  //hours_= is a function name for setters
  //These things allow the method to be used in the same way as 
  //directly accessing the public property.
  //person.age = 99
  //(value: Int) is the input
  def hours_= (value:Int) = {
    if(value < 0 || value > 23) throw new IllegalArgumentException
    else h = value
  }
  def minutes_= (value: Int) = {
    if(value < 0 || value > 59) throw new IllegalArgumentException
    else m = value
  }
  //define function hours and minutes to keep the original code in time1 package working
  def hours = h
  def minutes = m
  override def toString() = if(minutes < 10)hours + ":" + "0" + minutes else hours + ":" + minutes

  def before(t2: Time) =
    (t2.hours, t2.minutes) match {
      case (h2, m2) if hours == h2 => if (minutes < m2) true else false
      case (h2, _) if hours < h2 => true
      case _ => false
    }

  def minutesSinceMidNight() = hours * 60 + minutes
}

object Time {
  def apply(hours: Int, minutes: Int = 0) = {
	//apply calls the constructor
    new Time(hours, minutes)
  }
}