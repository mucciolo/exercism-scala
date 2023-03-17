trait Deque[+A] {

  def push[B >: A](x: B): Unit

  def pop: Option[A]

  def unshift[B >: A](x: B): Unit

  def shift: Option[A]

}

object Deque {

  def apply[T]() = new MutableDeque[T]()

}

case class MutableDeque[A]() extends Deque[A] {

  private sealed abstract class Node[-B]

  private final case class EmptyNode[B]() extends Node[B]

  private final case class NonemptyNode[B](elem: B,
                                           var prev: Node[B] = EmptyNode[B](),
                                           var next: Node[B] = EmptyNode[B]()) extends Node[B]

  private var first: Node[A] = EmptyNode[A]()
  private var last: Node[A] = EmptyNode[A]()

  override def push[B >: A](x: B): Unit = {

    val newLast = NonemptyNode[B](x)

    last match {

      case EmptyNode() =>
        first = newLast
        last = newLast

      case newLastPrev: NonemptyNode[B] =>
        newLast.prev = newLastPrev
        newLastPrev.next = newLast
        last = newLast

    }

  }

  override def pop: Option[A] = last match {

    case EmptyNode() =>
      None

    case NonemptyNode(elem: A, prev: Node[A], _) =>
      last = prev
      Some(elem)

  }

  override def unshift[B >: A](x: B): Unit = {

    val newFirst = NonemptyNode[B](x)

    first match {

      case EmptyNode() =>
        first = newFirst
        last = newFirst

      case newFirstNext: NonemptyNode[B] =>
        newFirst.next = newFirstNext
        newFirstNext.prev = newFirst
        first = newFirst

    }

  }

  override def shift: Option[A] = first match {

    case EmptyNode() =>
      None

    case NonemptyNode(elem: A, _, next: Node[A]) =>
      first = next
      Some(elem)

  }

}