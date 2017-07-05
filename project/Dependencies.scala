import sbt._

object Dependencies {

  lazy val akkaVersion = "10.0.9"

  // Libraries
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaVersion
  val googleApiClient = "com.google.api-client" %"google-api-client" % "1.22.0"
  val cats =  "org.typelevel" %% "cats" % "0.7.2"
  val logging = "com.typesafe.scala-logging" %% "scala-logging" % "3.7.0"
  val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"

  val deps =
    Seq(akkaHttp, googleApiClient, cats, logging, logback)

}
