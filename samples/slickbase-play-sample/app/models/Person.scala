package models

import in.diwa.slickbase.model.Entity
import in.diwa.slickbase._

case class Person(firstName: String,
                  lastName: String,
                  id: Option[Long] = None) extends Entity[Person] {

  def withId(id: Long): Person = copy(id = Some(id))

}


trait PersonComponent  extends TableComponent{ this: SlickProfile =>

  import profile.simple._

  class Persons(tag: Tag) extends BaseTable[Person](tag, "PERSONS") {

    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def firstName = column[String]("FIRST_NAME")

    def lastName = column[String]("LAST_NAME")

    def * = (firstName, lastName, id.?) <> (Person.tupled, Person.unapply)
  }

  val persons = TableQuery[Persons]

}


