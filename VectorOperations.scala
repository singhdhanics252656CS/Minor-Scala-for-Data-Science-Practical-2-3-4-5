import breeze.linalg._

object VectorOperations extends App {

  val v1 = DenseVector(1.0, 2.0, 3.0, 4.0, 5.0)
  val v2 = DenseVector(2.0, 4.0, 6.0, 8.0, 10.0)

  val sumV1 = sum(v1)
  println(s"Sum of v1: $sumV1")

  val meanV1 = mean(v1)
  println(s"Mean of v1: $meanV1")

  val dotProduct = v1 dot v2
  println(s"Dot product of v1 and v2: $dotProduct")

  val dotProductAlt = (v1.t * v2).toScalar
  println(s"Dot product (alternative): $dotProductAlt")

  val sumV2 = sum(v2)
  val meanV2 = mean(v2)
  println(s"Sum of v2: $sumV2")
  println(s"Mean of v2: $meanV2")
}
