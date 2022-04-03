import scala.annotation.tailrec

object BeerSong {

  private val BottlesOnTheWall = "\n%1$s bottles of beer on the wall, %1$s bottles of beer.\n"
  private val PluralPass = "Take one down and pass it around, %s bottles of beer on the wall.\n"
  private val SingularPass = "Take one down and pass it around, 1 bottle of beer on the wall.\n"

  private val LastBottle = "\n1 bottle of beer on the wall, 1 bottle of beer.\n" +
    "Take it down and pass it around, no more bottles of beer on the wall.\n"

  private val NoMoreBottles = "\nNo more bottles of beer on the wall, no more bottles of beer.\n" +
    "Go to the store and buy some more, 99 bottles of beer on the wall.\n"

  @tailrec
  def recite(bottleAmount: Int, passAmount: Int, lyrics: String = ""): String = {

    if (passAmount == 0) {
      lyrics.stripPrefix("\n")
    } else bottleAmount match {

      case 0 =>
        recite(0, 0, lyrics + NoMoreBottles)

      case 1 =>
        recite(bottleAmount - 1, passAmount - 1, lyrics + LastBottle)

      case 2 =>
        recite(bottleAmount - 1, passAmount - 1, lyrics + 2.formatted(BottlesOnTheWall) + SingularPass)

      case _ =>
        val oneLessBottle = bottleAmount - 1
        recite(oneLessBottle, passAmount - 1,
          lyrics + bottleAmount.formatted(BottlesOnTheWall) + oneLessBottle.formatted(PluralPass))

    }

  }

}