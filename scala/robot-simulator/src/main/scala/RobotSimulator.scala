object Robot {
  implicit class RichPairOfInt(self: (Int, Int)) {
    def plus(other: (Int, Int)): (Int, Int) = (self._1 + other._1, self._2 + other._2)
  }
}

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {

  import Robot._

  private val InstructionFunction: Map[Char, Robot => Robot] = Map(
    'R' -> (_.turnRight),
    'L' -> (_.turnLeft),
    'A' -> (_.advance)
  )

  def turnRight: Robot = Robot(bearing.right, coordinates)
  def turnLeft: Robot = Robot(bearing.left, coordinates)
  def advance: Robot = Robot(bearing, coordinates plus bearing.advancementDisplacement)
  def simulate(instructions: String): Robot = instructions.toStream
    .map(InstructionFunction.apply)
    .foldLeft(this)((robot, instruction) => instruction.apply(robot))
}

sealed abstract class Bearing(_left: => Bearing, _right: => Bearing, val advancementDisplacement: (Int, Int)) {
  lazy val left: Bearing = _left
  lazy val right: Bearing = _right
}

object Bearing {
  final object North extends Bearing(West, East, (0, 1))
  final object East extends Bearing(North, South, (1, 0))
  final object South extends Bearing(East, West, (0, -1))
  final object West extends Bearing(South, North, (-1, 0))
}