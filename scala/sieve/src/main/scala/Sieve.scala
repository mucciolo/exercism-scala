import scala.annotation.tailrec

object Sieve {

  def primes(upperLimit: Int): List[Int] = {

    @tailrec
    def iterate(n: Int, primes: List[Int], composites: Set[Int]): List[Int] = {

      if (upperLimit < n)
        primes.reverse
      else if (composites.contains(n))
        iterate(n + 1, primes, composites)
      else
        iterate(n + 1, n :: primes, composites ++ (n to upperLimit by n))

    }

    if (upperLimit < 2)
      List.empty
    else
      iterate(2, List.empty, Set.empty)

  }

}