import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "slickbase-play-sample"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
     "in.diwa" %% "slickbase" % "0.1.0-SNAPSHOT"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
  )
}
