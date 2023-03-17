object Pangrams {

  private val UpperCaseAlphabet = 'A' to 'Z'

  def isPangram(phrase: String): Boolean = {

    val upperCasePhrase = phrase.toUpperCase

    UpperCaseAlphabet.forall(upperCasePhrase.contains(_))
  }

}

