import scala.math._

object WeatherStation extends App {
  trait IThermometer {
    // = avg degrees Farenheit 
    def getMeanTemperature(cities: List[String]): Double
  }
  
  class CelsiusTherm { 
    // = degrees Celsius 
    def computeTemp(city: String) = 50 * math.random // fake temperature for now        
  }
  
  //need to convert between F and C
  class ThermAdapter extends CelsiusTherm with IThermometer
  {
    def cToF(c: Double) = 1.8 * c + 32
    
    def getMeanTemperature(cities: List[String]) = 
      if(cities == null) 0
      else cities.map(computeTemp).map(cToF).reduce(_+_)/cities.size
  }
  val thermometer: IThermometer = new ThermAdapter
  val avgTemp = thermometer.getMeanTemperature(List("LA", "SF", "SLC", "Rio")) 
  println("avg temp = " + avgTemp)
  //output: 
  //avg temp = 76.43780191661357
    
}