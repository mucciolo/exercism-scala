object Etl {

  def transform(legacySystem: Map[Int, Seq[String]]): Map[String, Int] = {
    legacySystem.flatMap {
      case (score, letters) => letters.toStream.map(_.toLowerCase).map(_ -> score).toMap
    }
  }

}