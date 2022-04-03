import scala.annotation.tailrec

object FlattenArray {

  def flatten(list: List[Any]): List[Any] = {

    @tailrec
    def iterate(list: List[Any], acc: List[Any] = List.empty): List[Any] = list match {
      case Nil => acc.reverse
      case x :: xs => x match {
        case y: Int => iterate(xs, y :: acc)
        case ys: List[_] => iterate(ys ::: xs, acc)
        case null => iterate(xs, acc)
      }
    }

    iterate(list)
  }
}