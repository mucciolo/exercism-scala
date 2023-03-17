object DifferenceOfSquares {

  def sumOfSquares(n: Int): Int = n * (n + 1) * (2*n + 1) / 6

  def squareOfSum(n: Int): Int = {

    val nFirstNaturalNumbersSum = n * (n + 1) / 2

    nFirstNaturalNumbersSum * nFirstNaturalNumbersSum
  }

  def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)
  
}
