import scala.math.max

case class Triangle(a: Double, b: Double, c: Double) {

  lazy val valid: Boolean = a != 0 && b != 0 && c != 0 && 2 * max(a, max(b, c)) < a + b + c

  lazy val equilateral: Boolean = valid && a == b && b == c

  lazy val isosceles: Boolean = valid && (a == b || a == c || b == c)

  lazy val scalene: Boolean = valid && a != b && a != c && b != c

}