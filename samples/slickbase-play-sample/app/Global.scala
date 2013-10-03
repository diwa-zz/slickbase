import play.api._
import play.api.db.DB
import in.diwa.slickbase.dao
import in.diwa.slickbase.dao.DBProvider
import in.diwa.slickbase.dao.SlickDatabase
import play.api.Play
import play.api.Play.current

object Global extends GlobalSettings {

   override def onStart(app: Application) {

    class AppDBProvider extends DBProvider {
        def newDB = SlickDatabase.forDataSource(DB.getDataSource()(Play.current))
    }

    dao.setDBProvider(new AppDBProvider)

  } 

}