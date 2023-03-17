object RnaTranscription {

  private val DnaToRna = Map(
    'G' -> 'C',
    'C' -> 'G',
    'T' -> 'A',
    'A' -> 'U'
  )

  def toRna(dna: String): Option[String] = {
    if (dna.isEmpty)
      None
    else
      Some(dna.map(DnaToRna))
  }

}