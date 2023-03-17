import scala.annotation.tailrec

object MatchingBrackets {

  private val Unpaired = '.'

  private def isPairMatched(a: Char, b: Char): Boolean = a match {

    case '(' =>
      b == ')'

    case '[' =>
      b == ']'

    case '{' =>
      b == '}'

    case _ =>
      false

  }

  def isPaired(str: String): Boolean = {

    @tailrec
    def iterate(str: String, bracketStack: List[Char]): Boolean = {

      if (str.isEmpty) {
        bracketStack.isEmpty
      } else {

        val updatedBracketStack = str.head match {

          case '(' | '[' | '{' =>
            str.head :: bracketStack

          case ')' | ']' | '}' =>
            bracketStack.headOption
              .filter(isPairMatched(_, str.head))
              .map(_ => bracketStack.tail)
              .getOrElse(Unpaired :: bracketStack)

          case _ =>
            bracketStack

        }

        if (updatedBracketStack.nonEmpty && updatedBracketStack.head == Unpaired)
          false
        else
          iterate(str.tail, updatedBracketStack)
      }

    }

    iterate(str, List.empty)
  }
}