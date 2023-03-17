object Bst {
  def fromList[A: Ordering](elements: List[A]): Bst[A] = {
    elements.tail.foldLeft(Bst(elements.head))((tree, element) => tree.insert(element))
  }
  def toList[A: Ordering](tree: Bst[A]): List[A] = {
    tree.left.map(toList[A]).getOrElse(List.empty) ++ (tree.value :: tree.right.map(toList[A]).getOrElse(List.empty))
  }
}

case class Bst[A: Ordering](value: A, left: Option[Bst[A]] = None, right: Option[Bst[A]] = None) {
  def insert(newValue: A): Bst[A] =
    if (implicitly[Ordering[A]].lteq(newValue, value))
      copy(left = left.map(_.insert(newValue)).orElse(Some(Bst(newValue))))
    else
      copy(right = right.map(_.insert(newValue)).orElse(Some(Bst(newValue))))
}