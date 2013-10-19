package in.diwa.slickbase.dao

import scala.slick.jdbc.JdbcBackend.Database

trait DBProvider {
  def newDB: Database
}
