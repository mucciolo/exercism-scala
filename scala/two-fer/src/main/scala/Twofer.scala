object Twofer {

  private val twoFerFormat = "One for %s, one for me."
  private val defaultName = "you"

  def twofer(name: String = defaultName): String = {
    name.formatted(twoFerFormat)
  }
}
