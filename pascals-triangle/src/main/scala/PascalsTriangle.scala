object PascalsTriangle {

  def nextPascalRow(row: List[Int]): List[Int] = {
    LazyList.from(0 :: row).lazyAppendedAll(LazyList(0)).sliding(2).map(_.sum).toList
  }

  def rows(n: Int): List[List[Int]] = List.iterate(List(1), n)(nextPascalRow)

}