import scala.annotation.tailrec

object FlattenArray {

  def flatten[A](list: List[Any]): List[A] = {

    @tailrec
    def iterate(list: List[Any], acc: List[A] = List.empty): List[A] = list match {
      case Nil => acc.reverse
      case x :: xs => x match {
        case ys: List[_] => iterate(ys ::: xs, acc)
        case y: A => iterate(xs, y :: acc)
        case null => iterate(xs, acc)
      }
    }

    iterate(list)
  }
}