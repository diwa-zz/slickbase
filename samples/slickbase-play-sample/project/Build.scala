import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "slickbase-play-sample"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    "in.diwa" %% "slickbase" % "0.1.0-SNAPSHOT",
    "org.scalatest"       %% "scalatest"    % "2.0.RC2"   % "test",
    "org.mockito"         % "mockito-core"  % "1.9.5"     % "test"
    )

  resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

  val main = play.Project(appName, appVersion, appDependencies).settings(
    )
}
