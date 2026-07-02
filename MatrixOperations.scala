import breeze.linalg._
import breeze.stats.distributions.{Gaussian, Rand}

object MatrixOperations extends App {

  val randomMatrix = DenseMatrix.rand[Double](3, 3)
  println("Random Matrix:")
  println(randomMatrix)

  val rng = new scala.util.Random(42)
  val matrixWithSeed = DenseMatrix.rand[Double](3, 3, new Rand[Double] {
    override def draw(): Double = rng.nextGaussian()
    override def toString = "Gaussian"
  })
  println("\nRandom Matrix with Seed:")
  println(matrixWithSeed)

  val randomIntMatrix = DenseMatrix.rand[Int](3, 4)
  println("\nRandom Integer Matrix:")
  println(randomIntMatrix)

  val transposeMatrix = randomMatrix.t
  println("\nTranspose of Matrix:")
  println(transposeMatrix)

  val det = det(randomMatrix)
  println(f"\nDeterminant: $det%.4f")

  val doubleIntMatrix = randomIntMatrix.map(_.toDouble)
  if (doubleIntMatrix.rows == doubleIntMatrix.cols) {
    val detInt = det(doubleIntMatrix)
    println(f"Determinant of integer matrix: $detInt%.4f")
  }

  println("\n--- Additional Operations ---")

  val trace = randomMatrix.trace
  println(s"Trace: $trace")

  if (math.abs(det) > 1e-10) {
    val inverse = inv(randomMatrix)
    println("\nInverse Matrix:")
    println(inverse)
  } else {
    println("\nMatrix is singular (det = 0), inverse doesn't exist")
  }

  val vec = DenseVector(1.0, 2.0, 3.0)
  val matrixVecProduct = randomMatrix * vec
  println("\nMatrix * Vector:")
  println(matrixVecProduct)
}
