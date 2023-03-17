object SecretHandshake {

  private val CommandListOperationByBinaryPosition: Map[Int, List[String] => List[String]] = Map(
    0 -> (_ :+ "wink"),
    1 -> (_ :+ "double blink"),
    2 -> (_ :+ "close your eyes"),
    3 -> (_ :+ "jump"),
    4 -> (_.reverse)
  )

  def commands(decimal: Int): List[String] = {
    decimal.toBinaryString.reverse.zipWithIndex
      .filter { case (binaryCommand, _) => binaryCommand == '1' }
      .map { case (_, position) => CommandListOperationByBinaryPosition(position)}
      .foldLeft(List.empty[String])((commandList, operation) => operation.apply(commandList))
  }

}