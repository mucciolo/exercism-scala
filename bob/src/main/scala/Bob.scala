object Bob {

  def isYell(statement: String): Boolean = {

    val statementLetters = statement.filter(_.isLetter)

    statementLetters.nonEmpty && statementLetters.forall(_.isUpper)
  }

  def isQuestion(statement: String): Boolean = statement.endsWith("?")

  private object Reaction {
    val Silence = "Fine. Be that way!"
    val YelledQuestion = "Calm down, I know what I'm doing!"
    val NormalQuestion = "Sure."
    val Yell = "Whoa, chill out!"
    val Default = "Whatever."
  }

  def response(statement: String): String = {

    val trimmedStatement = statement.trim

    if (trimmedStatement.isEmpty) {
      Reaction.Silence
    } else {

      val isYell = Bob.isYell(trimmedStatement)

      if (isQuestion(trimmedStatement)) {

        if (isYell) Reaction.YelledQuestion else Reaction.NormalQuestion

      } else if (isYell) {
        Reaction.Yell
      } else {
        Reaction.Default
      }

    }
  }
}
