import java.time.temporal.ChronoUnit
import java.time.{LocalDate, LocalDateTime}

object Gigasecond {

  private val Giga: Long = 1E9.toLong

  def add(startDate: LocalDate): LocalDateTime = add(startDate.atStartOfDay())

  def add(startDateTime: LocalDateTime): LocalDateTime = startDateTime.plus(Giga, ChronoUnit.SECONDS)
}
