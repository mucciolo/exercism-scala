object Leap {

  private implicit class EnrichedInt(n: Int) {

    def isMultipleOf(d: Int): Boolean = {
      n % d == 0
    }

    def isNotMultipleOf(d: Int): Boolean = {
      !isMultipleOf(d)
    }

  }

  def leapYear(year: Int): Boolean = {
    year.isMultipleOf(4) && (year.isNotMultipleOf(100) || year.isMultipleOf(400))
  }
}
