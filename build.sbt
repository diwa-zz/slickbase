import scalariform.formatter.preferences._
import org.scalastyle.sbt.ScalastylePlugin

name := "slickbase"

organization := "in.diwa"

version := "0.1.0-SNAPSHOT"

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("https://github.com/diwa/slickbase"))

startYear := Some(2013)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/diwa/slickbase"),
    "scm:git:https://github.com/diwa/slickbase.git",
    Some("scm:git:git@github.com:diwa/slickbase.git")
    )
  )

scalaVersion := "2.10.2"

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8",
  "-target:jvm-1.7",
  "-Ywarn-all", // doesn't actually turn them all on :-\
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-dead-code",
  "-Ywarn-inaccessible",
  "-Ywarn-nullary-override",
  "-Ywarn-nullary-unit",
  "-Yclosure-elim",
  "-Yinline",
  "-Xlint"
  )

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

libraryDependencies ++= Seq (
  "com.typesafe.slick"  %% "slick"        % "2.0.0-M2",
  "org.scalatest"       %% "scalatest"    % "2.0.RC2"   % "test",
  "com.h2database"      % "h2"            % "1.3.173"   % "test",
  "org.mockito"         % "mockito-core"  % "1.9.5"     % "test"
  )

resolvers ++= Seq(
 "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
 )

releaseSettings

atmosSettings

defaultScalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
.setPreference(AlignParameters, true)
.setPreference(AlignSingleLineCaseStatements, true)
.setPreference(DoubleIndentClassDeclaration, true)
.setPreference(PreserveDanglingCloseParenthesis, true)

logLevel in compile := Level.Warn

traceLevel := 5

offline := false

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
  Some("snapshots" at nexus + "content/repositories/snapshots")
  else
  Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

mappings in (Compile, packageBin) ~= { (ms: Seq[(File, String)]) =>
  ms filter { case (file, toPath) => toPath != "application.conf" }
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>diwa</id>
      <name>Diwa Laksh</name>
      <email>diwalak@gmail.com</email>
    </developer>
  </developers>
  )

ScalastylePlugin.Settings

val gc = taskKey[Unit]("Runs garbage collector")

gc := System gc()
