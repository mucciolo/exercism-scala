import scala.annotation.tailrec

object Strain {

  def keep[T](list: Seq[T], predicate: T => Boolean): Seq[T] = {

    @tailrec
    def iterate(list: Seq[T], acc: List[T] = List.empty): Seq[T] = list match {
      case Nil => acc.reverse
      case x :: xs => if (predicate(x)) iterate(xs, x :: acc) else iterate(xs, acc)
    }

    iterate(list)
  }

  def discard[T](list: Seq[T], predicate: T => Boolean): Seq[T] = keep[T](list, !predicate(_))

}