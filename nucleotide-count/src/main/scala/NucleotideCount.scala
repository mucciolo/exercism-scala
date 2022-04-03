class DNA (strand: String) {

  private val ValidStrand = "^[ACGT]*$".r
  private val DefaultValue = Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)

  lazy val nucleotideCounts: Either[String, Map[Char, Int]] = strand match {
    case ValidStrand() => Right(DefaultValue ++ strand.groupBy(identity).mapValues(_.length))
    case _ => Left("Invalid DNA strand")
  }

}