import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers


/** @version 1.1.0 */
class PrimeFactorsTest extends AnyFunSuite with Matchers {

  test("isPrime") {
    PrimeFactors.isPrime(0) should be(false)
    PrimeFactors.isPrime(1) should be(false)
    PrimeFactors.isPrime(2) should be(true)
    PrimeFactors.isPrime(3) should be(true)
    PrimeFactors.isPrime(4) should be(false)
    PrimeFactors.isPrime(5) should be(true)
    PrimeFactors.isPrime(6) should be(false)
  }

  test("nextPrime") {
    PrimeFactors.nextPrime(2) should be(3)
    PrimeFactors.nextPrime(3) should be(5)
    PrimeFactors.nextPrime(5) should be(7)
    PrimeFactors.nextPrime(7) should be(11)
  }

  test("no factors") {
    PrimeFactors.factors(1) should be(List())
  }

  test("prime number") {
    PrimeFactors.factors(2) should be(List(2))
  }

  test("square of a prime") {
    PrimeFactors.factors(9) should be(List(3, 3))
  }

  test("cube of a prime") {
    PrimeFactors.factors(8) should be(List(2, 2, 2))
  }

  test("product of primes and non-primes") {
    PrimeFactors.factors(12) should be(List(2, 2, 3))
  }

  test("product of primes") {
    PrimeFactors.factors(901255) should be(List(5, 17, 23, 461))
  }

  test("factors include a large prime") {
    PrimeFactors.factors(93819012551L) should be(List(11, 9539, 894119))
  }
}
