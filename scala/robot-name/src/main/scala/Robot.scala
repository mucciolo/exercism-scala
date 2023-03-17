import scala.collection.immutable.Stream
import scala.language.postfixOps
import scala.util.Random

object Robot {

  private val UpperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  private val Digits = "0123456789"

  private val NameLetterAmount = 2
  private val NameDigitAmount = 3

  private def generator(chars: String): Iterator[Char] = {

    def nextChar: Char = chars.charAt(Random nextInt chars.length)

    Stream.continually(nextChar).iterator
  }

  private val UpperCaseLetterGenerator: Iterator[Char] = generator(UpperCaseLetters)
  private val DigitGenerator: Iterator[Char] = generator(Digits)

  private def nextName: String = {
    UpperCaseLetterGenerator.take(NameLetterAmount).mkString + DigitGenerator.take(NameDigitAmount).mkString
  }

  private val NameGenerator: Iterator[String] = Stream.continually(nextName).distinct.iterator

}

class Robot {

  var name: String = Robot.NameGenerator.next()

  def reset(): Unit = name = Robot.NameGenerator.next()
}