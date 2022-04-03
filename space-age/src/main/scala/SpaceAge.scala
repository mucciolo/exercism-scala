object SpaceAge {

  private val EarthYearInSeconds: Long = 31557600

  private def onPlanet(orbitalPeriodRelativeToEarth: Double)(ageInSeconds: Double): Double = {
    ageInSeconds / EarthYearInSeconds / orbitalPeriodRelativeToEarth
  }

  def onMercury: Double => Double = onPlanet(0.2408467)
  def onVenus: Double => Double = onPlanet(0.61519726)
  def onEarth: Double => Double = onPlanet(1)
  def onMars: Double => Double = onPlanet(1.8808158)
  def onJupiter: Double => Double = onPlanet(11.862615)
  def onSaturn: Double => Double = onPlanet(29.447498)
  def onUranus: Double => Double = onPlanet(84.016846)
  def onNeptune: Double => Double = onPlanet(164.79132)

}