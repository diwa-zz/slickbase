package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    //val count = persons.where(_.firstName == "John")
    import in.diwa.slickbase.dao
    println ( "DB1 : "+ dao.DB.toString)
    println ( "DB2 : " + dao.DB.toString)
    println ( "DB3 : " + dao.DB.toString)
    Ok(views.html.index("Your new application is ready."))
  }

}
