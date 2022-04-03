case class CustomSet[+T](private val map: Map[Int, T])

object CustomSet {

  implicit class MapAsCustomSet[+X](map: Map[Int, X]) {
    def asCustomSet: CustomSet[X] = new CustomSet(map)
  }

  def fromList[T](list: List[T]): CustomSet[T] = list.toStream
    .map(elem => elem.hashCode() -> elem)
    .toMap
    .asCustomSet

  def empty[T](set: CustomSet[T]): Boolean = set.map.isEmpty

  def member[T](set: CustomSet[T], x: T): Boolean = set.map.contains(x.hashCode())

  def isSubsetOf[T](a: CustomSet[T], b: CustomSet[T]): Boolean = a.map.keys.forall(b.map.contains)

  def isDisjointFrom[T](a: CustomSet[T], b: CustomSet[T]): Boolean = empty(intersection(a, b))

  def isEqual[T](a: CustomSet[T], b: CustomSet[T]): Boolean = a.map == b.map

  def insert[T](set: CustomSet[T], x: T): CustomSet[T] = set.map.updated(x.hashCode(), x).asCustomSet

  def intersection[T](a: CustomSet[T], b: CustomSet[T]): CustomSet[T] = a.map.filterKeys(b.map.contains).asCustomSet

  def difference[T](a: CustomSet[T], b: CustomSet[T]): CustomSet[T] = a.map.filterKeys(!b.map.contains(_)).asCustomSet

  def union[T](a: CustomSet[T], b: CustomSet[T]): CustomSet[T] = (a.map ++ b.map).asCustomSet

}