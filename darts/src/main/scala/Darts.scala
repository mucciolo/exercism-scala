object Darts {

  object CircleRadius {

    val Outer = 10.0
    val Middle = 5.0
    val Inner = 1.0

  }

  object Points {

    val InnerCircle = 10
    val MiddleCircle = 5
    val OuterCircle = 1
    val OutsideTarget = 0

  }

  def score(x: Double, y: Double): Int = math.hypot(x, y) match {
    case r if r <= CircleRadius.Inner => Points.InnerCircle
    case r if r <= CircleRadius.Middle => Points.MiddleCircle
    case r if r <= CircleRadius.Outer => Points.OuterCircle
    case _ => Points.OutsideTarget
  }


}