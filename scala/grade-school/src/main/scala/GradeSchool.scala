import scala.collection.immutable.TreeMap

class School {

  private var studentsByGrade: DB = TreeMap.empty(Ordering.Int).withDefaultValue(Seq.empty)

  type DB = Map[Int, Seq[String]]

  def add(name: String, grade: Int): Unit = {
    val updatedStudents = studentsByGrade(grade) :+ name
    studentsByGrade += (grade -> updatedStudents)
  }

  def db: DB = studentsByGrade

  def grade(grade: Int): Seq[String] = db(grade)

  def sorted: DB = db.mapValues(_.sorted)
}

