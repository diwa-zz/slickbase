package in.diwa.slickbase

package object dao {
  type Session = scala.slick.jdbc.JdbcBackend#Session

  var newDbProvider: Option[DBProvider] = None
  def setDBProvider(dbProvider: DBProvider) = {
    newDbProvider = Option(dbProvider)
  }

  def DB = newDbProvider.get.newDB
}
