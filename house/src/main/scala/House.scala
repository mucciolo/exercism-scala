object House {

  case class VerseElement(head: String, postmodifier: String)

  private val VerseStart = "This is"
  private val VerseEnd = ".\n"
  private val RhymeEnd = "\n"
  private val Determiner = " the "
  private val PostmodifierComplement = " that "
  private val VerseElements: Array[VerseElement] = Array(
    VerseElement("0", "0"),
    VerseElement("house", "Jack built"),
    VerseElement("malt", "lay in"),
    VerseElement("rat", "ate"),
    VerseElement("cat", "killed"),
    VerseElement("dog", "worried"),
    VerseElement("cow with the crumpled horn", "tossed"),
    VerseElement("maiden all forlorn", "milked"),
    VerseElement("man all tattered and torn", "kissed"),
    VerseElement("priest all shaven and shorn", "married"),
    VerseElement("rooster that crowed in the morn", "woke"),
    VerseElement("farmer sowing his corn", "kept"),
    VerseElement("horse and the hound and the horn", "belonged to")
  )

  def recite(fromVerse: Int, toVerse: Int): String = (fromVerse to toVerse).map(nthVerse).reduce(_ + _) + RhymeEnd

  private def assembleVerse(element: VerseElement): String =
    Determiner + element.head + PostmodifierComplement + element.postmodifier

  private def nthVerse(verseNum: Int): String =
    VerseStart + (verseNum to 1 by -1).map(VerseElements).map(assembleVerse).reduce(_ + _) + VerseEnd

}