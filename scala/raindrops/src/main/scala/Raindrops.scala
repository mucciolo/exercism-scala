import scala.collection.SortedMap

object Raindrops {

  private val FactorToRaindrop = SortedMap(
    3 -> "Pling",
    5 -> "Plang",
    7 -> "Plong"
  )

  def convert(n: Int): String = {

    val raindrops = FactorToRaindrop.collect {
      case (factor, raindrop) if n % factor == 0 => raindrop
    }

    if (raindrops.isEmpty)
      n.toString
    else
      raindrops.mkString
  }

}
