object Grains {

  private val Min = 1
  private val Max = 64

  private def computeSquare(n: Int): BigInt = BigInt(1) << (n - 1)

  def square(n: Int): Option[BigInt] = if (Min <= n && n <= Max) Some(computeSquare(n)) else None

  lazy val total: Number = computeSquare(Max + 1) - 1

}