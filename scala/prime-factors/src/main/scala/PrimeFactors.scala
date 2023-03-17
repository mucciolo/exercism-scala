import scala.annotation.tailrec
import scala.math._

object PrimeFactors {

  def isPrime(n: Long): Boolean = abs(n) match {
    case 1 => false
    case 2 => true
    case even if n % 2 == 0 => false
    case _ =>
      (3L to sqrt(n).floor.longValue by 2).forall(d => n % d != 0)
  }

  def nextPrime(prime: Long): Long = {
    val from = if (prime == 2) prime + 1 else prime + 2
    (from to Int.MaxValue).find(isPrime).get
  }

  def factors(n: Long): List[Long] = {

    @tailrec
    def iterate(remainder: Long, currPrime: Long, factors: List[Long]): List[Long] = {
      if (currPrime > remainder)
        factors.reverse
      else if (remainder % currPrime == 0)
        iterate(remainder / currPrime, currPrime, currPrime :: factors)
      else
        iterate(remainder, nextPrime(currPrime), factors)
    }

    if (isPrime(n))
      List(n)
    else
      iterate(n, 2, List.empty)
  }
}