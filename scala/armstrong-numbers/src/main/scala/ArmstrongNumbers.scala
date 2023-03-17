object ArmstrongNumbers {

  def isArmstrongNumber(n: Int): Boolean = {

    val nStr = n.toString

    n == nStr.map(_.asDigit).map(math.pow(_, nStr.length)).sum.toInt

  }

}