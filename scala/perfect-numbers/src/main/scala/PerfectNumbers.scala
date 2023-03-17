import NumberType.NumberType

import scala.math.sqrt

object NumberType extends Enumeration {

  type NumberType = Value
  val Deficient, Perfect, Abundant = Value

}

object PerfectNumbers {

  def classify(n: Int): Either[String, NumberType] = {

    if (n < 1)
      Left("Classification is only possible for natural numbers.")
    else
      Right(
        properDivisors(n).sum.compare(n) match {
          case -1 => NumberType.Deficient
          case 0 => NumberType.Perfect
          case 1 => NumberType.Abundant
        }
      )

  }

  def properDivisors(n: Int): Seq[Int] = {

    if (n < 2)
      Seq.empty
    else
      1 +: Range.BigDecimal(2, sqrt(n), 1)
        .map(_.toInt)
        .filter(n % _ == 0)
        .flatMap {
          case d if n/d == d => Seq(d)
          case d => Seq(d, n/ d)
        }

  }

}