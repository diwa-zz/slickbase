name := "slickbase"

organization := "in.diwa"

version := "0.1.0-SNAPSHOT"

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
  " -Ywarn-nullary-unit",
  "-Yclosure-elim",
  "-Yinline",
  "-Xlint"
  )

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

libraryDependencies ++= Seq (
  "com.typesafe.slick" %% "slick" % "2.0.0-M2",
  "com.h2database" % "h2" % "1.3.166",
  "org.scalatest" %% "scalatest" % "2.0.RC1" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.13"
  )

resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeRepo("releases")
  )

assemblySettings

test in AssemblyKeys.assembly := {}

atmosSettings

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

offline := false

/* publishing */
publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some(
    "snapshots" at nexus + "content/repositories/snapshots"
  )
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

mappings in (Compile, packageBin) ~= { (ms: Seq[(File, String)]) =>
  ms filter { case (file, toPath) =>
      toPath != "application.conf"
  }
}

publishArtifact in Test := false

// publishArtifact in (Compile, packageDoc) := false

// publishArtifact in (Compile, packageSrc) := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>diwa</id>
      <name>Diwa Laksh</name>
      <email>diwalak@gmail.com</email>
//    <url>http://johndoe.com</url>
    </developer>
  </developers>
)
