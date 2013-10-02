package models

import in.diwa.slickbase.SlickProfile
import scala.slick.driver.JdbcProfile


class DAL(override val profile: JdbcProfile) extends PersonComponent with SlickProfile

object DAL {
}
