object FoodChain {

  private final case class SwallowableAnimal(name: String, swallowingPhrase: String)
  private object SwallowableAnimal {
    val Fly = SwallowableAnimal(
      "fly",
      "I don't know why she swallowed the fly. Perhaps she'll die."
    )
    val Spider = SwallowableAnimal(
      "spider",
      "It wriggled and jiggled and tickled inside her."
    )
    val Bird = SwallowableAnimal(
      "bird",
      "How absurd to swallow a bird!"
    )
    val Cat = SwallowableAnimal(
      "cat",
      "Imagine that, to swallow a cat!"
    )
    val Dog = SwallowableAnimal(
      "dog",
      "What a hog, to swallow a dog!"
    )
    val Goat = SwallowableAnimal(
      "goat",
      "Just opened her throat and swallowed a goat!"
    )
    val Cow = SwallowableAnimal(
      "cow",
      "I don't know how she swallowed a cow!"
    )
    val Horse = SwallowableAnimal(
      "horse",
      "She's dead, of course!"
    )
  }

  import FoodChain.SwallowableAnimal._

  private val SwallowingOrder = Vector(Fly, Spider, Bird, Cat, Dog, Goat, Cow, Horse)

  def recite(startingVerse: Int, endingVerse: Int): String = {
    (startingVerse to endingVerse).map(makeVerse).mkString("", "\n\n", "\n\n")
  }

  private def makeVerse(n: Int): String = {

    if (n == 1 || n == SwallowingOrder.length) {
      openingVerse(SwallowingOrder(n-1))
    } else {
      val lastAnimal = SwallowingOrder(n - 1)

      val middleVerses = SwallowingOrder
        .take(n)
        .reverse
        .sliding(2)
        .map {
          case Vector(swallower, swallowed) =>

            val ending =
              if (swallowed == Spider)
                s" that${Spider.swallowingPhrase.dropWhile(!_.isWhitespace)}"
              else
                "."

            s"She swallowed the ${swallower.name} to catch the ${swallowed.name}$ending"

          case _ =>
            List.empty
        }

      middleVerses.fold(openingVerse(lastAnimal))(_ + "\n" + _) + "\n" + SwallowingOrder.head.swallowingPhrase
    }
  }

  private def openingVerse(animal: SwallowableAnimal): String = {
    s"""I know an old lady who swallowed a ${animal.name}.
       |${animal.swallowingPhrase}""".stripMargin
  }
}