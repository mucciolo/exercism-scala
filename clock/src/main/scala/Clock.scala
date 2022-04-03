import scala.math.abs

case class Clock private (hours: Int, minutes: Int) {

  def +(other: Clock): Clock = Clock(this.hours + other.hours, this.minutes + other.minutes)

  def -(other: Clock): Clock = Clock(this.hours - other.hours, this.minutes - other.minutes)

}

object Clock {

  def apply(minutes: Int): Clock = {

    val borrowed = if (minutes % 60 < 0) -1 else 0

    new Clock(nonNegativeModN(minutes / 60 + borrowed, 24), nonNegativeModN(minutes, 60))
  }

  def apply(hours: Int, minutes: Int): Clock = Clock(hours * 60 + minutes)

  private def nonNegativeModN(a: Int, n: Int) = {

    val possiblyNegativeMod = a % n

    if (possiblyNegativeMod < 0)
      possiblyNegativeMod + abs(n)
    else
      possiblyNegativeMod
  }

}