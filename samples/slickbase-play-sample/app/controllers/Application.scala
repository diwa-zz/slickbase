package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    //val count = persons.where(_.firstName == "John")
    Ok(views.html.index("Your new application is ready."))
  }

}
