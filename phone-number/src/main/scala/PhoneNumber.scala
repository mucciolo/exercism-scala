import scala.util.matching.Regex

object PhoneNumber {

  private val NanpFormat: Regex = raw"\+?1?\s*\(?([2-9]\d{2})\)?(?:\s*|-|\.)([2-9]\d{2})(?:\s*|-|\.)(\d{4})".r

  def clean(number: String): Option[String] = number.trim match {

    case NanpFormat(areaCode, exchangeCode, subscriberNumber) => Some(areaCode + exchangeCode + subscriberNumber)

    case _ => None

  }

}