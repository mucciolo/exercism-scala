import scala.annotation.tailrec

class Accumulate {
  def accumulate[A, B](f: A => B, list : List[A]): List[B] = {

    @tailrec
    def iterate(queue: List[A], acc: List[B] = List.empty): List[B] = queue match {
      case Nil => acc.reverse
      case x :: xs => iterate(xs, f(x) :: acc)
    }

    iterate(list)

  }
}
