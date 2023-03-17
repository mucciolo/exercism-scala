import scala.annotation.tailrec

object CollatzConjecture {

  def next(n: Int): Int = {

    if (n % 2 == 0)
      n / 2
    else
      3 * n + 1

  }

  def steps(n: Int): Option[Int] = {

    @tailrec
    def iterate(n: Int, steps: Int = 0): Int = {

      if (n == 1)
        steps
      else
        iterate(next(n), steps + 1)

    }

    if (n < 1)
      None
    else
      Some(iterate(n))

  }

}