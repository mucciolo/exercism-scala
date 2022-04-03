import scala.annotation.tailrec

object BinarySearch {

  @tailrec
  def find(list: List[Int], n: Int, baseIdx: Int = 0): Option[Int] = list match {

    case Nil => None

    case head :: Nil => if (n == head) Some(baseIdx) else None

    case _ =>
      val middleIdx = list.size / 2
      val middleElement = list(middleIdx)

      if (n == middleElement)
        Some(baseIdx + middleIdx)
      else if (n < middleElement)
        find(list.slice(0, middleIdx), n, 0)
      else
        find(list.slice(middleIdx, list.size), n, baseIdx + middleIdx)
  }

}