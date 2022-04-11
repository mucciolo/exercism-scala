trait SimpleLinkedList[+T] {
  def isEmpty: Boolean
  def value: T
  def add[U >: T](item: U): SimpleLinkedList[U]
  def next: SimpleLinkedList[T]
  def reverse: SimpleLinkedList[T]
  def toSeq: Seq[T]
}

object SimpleLinkedList {
  def apply[T](): SimpleLinkedList[T] = EmptySimpleLinkedList[T]()

  def fromSeq[T](seq: Seq[T]): SimpleLinkedList[T] = seq.foldLeft(SimpleLinkedList[T]()) {
    case (linkedList, elem) => linkedList.add(elem)
  }

  def apply[T](elems: T*): SimpleLinkedList[T] = fromSeq(elems)
}

case class EmptySimpleLinkedList[T]() extends SimpleLinkedList[T] {
  override lazy val isEmpty: Boolean = true
  override def value: T = throw new NoSuchElementException
  override def add[U >: T](item: U): SimpleLinkedList[U] = NonEmptySimpleLinkedList(item, EmptySimpleLinkedList())
  override def next: SimpleLinkedList[T] = throw new NoSuchElementException
  override def reverse: SimpleLinkedList[T] = this
  override def toSeq: Seq[T] = Seq.empty
}

case class NonEmptySimpleLinkedList[T](value: T, next: SimpleLinkedList[T]) extends SimpleLinkedList[T] {
  override lazy val isEmpty: Boolean = false
  override def add[U >: T](item: U): SimpleLinkedList[U] = NonEmptySimpleLinkedList(value, next.add(item))
  override def reverse: SimpleLinkedList[T] = if (next.isEmpty) this else next.reverse.add(value)
  override def toSeq: Seq[T] = value +: next.toSeq
}