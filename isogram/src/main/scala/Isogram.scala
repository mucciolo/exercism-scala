object Isogram {

  def isIsogram(str: String): Boolean = str
    .filter(_.isLetter)
    .groupBy(_.toLower)
    .mapValues(_.length)
    .forall { case (_, count) => count == 1 }

}