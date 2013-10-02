package in.diwa.slickbase.dao

import scala.slick.jdbc.WrappedSlickDatabase

class SlickDatabase(ds: javax.sql.DataSource) extends WrappedSlickDatabase {
  protected def datasource = ds
}

object SlickDatabase {

  def forDataSource(datasource: javax.sql.DataSource): SlickDatabase = {
    new SlickDatabase(datasource)
  }
}
