import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "slickbase-play-sample"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc     // The JDBC connection pool and the play.api.db API,
  )

  val slickbase = RootProject(file("../../"))
  val main = play.Project(appName, appVersion, appDependencies).settings(
  ).dependsOn(slickbase).aggregate(slickbase)

}
