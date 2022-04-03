

case class ComplexNumber(real: Double = 0.0, imaginary: Double = 0.0) {

  def +(other: ComplexNumber): ComplexNumber = ComplexNumber(this.real + other.real, this.imaginary + other.imaginary)

  def -(other: ComplexNumber): ComplexNumber = ComplexNumber(this.real - other.real, this.imaginary - other.imaginary)

  def *(other: ComplexNumber): ComplexNumber = ComplexNumber(
    this.real * other.real - this.imaginary * other.imaginary,
    this.imaginary * other.real + this.real * other.imaginary
  )

  def /(other: ComplexNumber): ComplexNumber = {

    val denominator = other.real * other.real + other.imaginary * other.imaginary

    ComplexNumber(
      (this.real * other.real + this.imaginary * other.imaginary) / denominator,
      (this.imaginary * other.real - this.real * other.imaginary) / denominator
    )
  }

  def abs: Double = math.hypot(real, imaginary)

  def conjugate: ComplexNumber = ComplexNumber(real, -imaginary)

}

object ComplexNumber {

  def exp(z: ComplexNumber): ComplexNumber = {

    val expRe = math.exp(z.real)

    ComplexNumber(expRe * math.cos(z.imaginary), expRe * math.sin(z.imaginary))
  }

}