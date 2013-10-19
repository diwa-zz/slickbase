package scala.slick.jdbc

abstract class WrappedSlickDatabase extends JdbcBackend.Database {
  protected def datasource: javax.sql.DataSource
  def createConnection(): java.sql.Connection = datasource.getConnection
}
