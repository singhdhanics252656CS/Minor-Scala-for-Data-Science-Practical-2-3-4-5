import scala.util.Random
import scala.math.sqrt

object variancestddev extends App {

  val random = new Random()

  val data = List.fill(10)(random.nextInt(100) + 1)

  val mean = data.sum.toDouble / data.length

  val variance = data.map(x => math.pow(x - mean, 2)).sum / data.length

  val stdDev = sqrt(variance)

  println("Random Dataset: " + data)
  println("Mean: " + mean)
  println("Variance: " + variance)
  println("Standard Deviation: " + stdDev)
}
