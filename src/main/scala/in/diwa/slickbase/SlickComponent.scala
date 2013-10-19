package in.diwa.slickbase

import scala.slick.driver.JdbcProfile
import in.diwa.slickbase.model.Entity

trait SlickProfile {
  val profile: JdbcProfile
}

trait TableComponent { this: SlickProfile =>
  import profile.simple._

  abstract class BaseTable[E <: Entity[E]](tag: Tag, tableName: String) extends Table[E](tag, tableName) {
  }

}
