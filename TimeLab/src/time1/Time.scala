

package time1

class Time(val hours: Int, val minutes: Int = 0) {   
  if(hours < 0 || hours > 23) throw new IllegalArgumentException
  if(minutes < 0 || minutes > 59) throw new IllegalArgumentException
  
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