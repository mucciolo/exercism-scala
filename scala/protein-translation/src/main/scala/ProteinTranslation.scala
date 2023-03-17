object ProteinTranslation {

  private val CodonSize = 3
  private val StopProtein = "STOP"

  private val ProteinsCodons: Map[String, Set[String]] = Map(
    "Methionine" -> Set("AUG"),
    "Phenylalanine" -> Set("UUU", "UUC"),
    "Leucine" -> Set("UUA", "UUG"),
    "Serine" -> Set("UCU", "UCC", "UCA", "UCG"),
    "Tyrosine" -> Set("UAU", "UAC"),
    "Cysteine" -> Set("UGU", "UGC"),
    "Tryptophan" -> Set("UGG"),
    StopProtein -> Set("UAA", "UAG", "UGA")
  )

  private val CodonToProtein: Map[String, String] = ProteinsCodons.flatMap {
    case (protein, codons) => codons.map(_ -> protein)
  }.withDefaultValue("?")

  def proteins(rna: String): Seq[String] = {
    rna.grouped(CodonSize).map(CodonToProtein).takeWhile(_ != StopProtein).toSeq
  }

}