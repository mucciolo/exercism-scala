
object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int =
    factors.flatMap(n => Stream.from(1).map(_ * n).takeWhile(_ < limit)).sum
}

