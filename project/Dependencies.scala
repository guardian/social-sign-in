import sbt._

object Dependencies {

  lazy val akkaVersion = "10.0.9"

  // Libraries
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaVersion

  val deps =
    Seq(akkaHttp)

}
