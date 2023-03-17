object Hamming {

  def distance(oneStr: String, anotherStr: String): Option[Integer] = {

    if (oneStr.length == anotherStr.length)
      Some(oneStr.zip(anotherStr).count { case (a, b) => a != b })
    else
      None
  }

}