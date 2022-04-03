object ScrabbleScore {

  private val lettersByScore = Map(
    1 -> Set('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
    2 -> Set('D', 'G'),
    3 -> Set('B', 'C', 'M', 'P'),
    4 -> Set('F', 'H', 'V', 'W', 'Y'),
    5 -> Set('K'),
    8 -> Set('J', 'X'),
    10 -> Set('Q', 'Z')
  )

  private val letterScore: Map[Char, Int] = lettersByScore.flatMap { case (score, letters) => letters.map(_ -> score) }

  def score(word: String): Int = word.map(letter => letterScore(letter.toUpper)).sum

}