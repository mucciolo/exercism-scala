object RotationalCipher {

  private val AlphabetLength = 26

  def rotate(str: String, n: Int): String = str.map {
    case c if c.isLower => rotateLowerLetter(c, n)
    case c if c.isUpper => rotateUpperLetter(c, n)
    case c => c
  }

  private def rotateChar(c: Char, n: Int, displacement: Char) = {
    ((c - displacement + n) % AlphabetLength + displacement).toChar
  }

  private def rotateLowerLetter(c: Char, n: Int) = rotateChar(c, n, 'a')
  private def rotateUpperLetter(c: Char, n: Int) = rotateChar(c, n, 'A')
}