import ReleaseTransformations._

name := "social-signin"
organization := "com.gu"
scalaVersion := "2.13.4"
sonatypeProfileName := "com.gu"

libraryDependencies ++= Seq(
  "org.apache.pekko"           %%  "pekko-http"         % "1.0.1",
  "com.google.api-client"       %   "google-api-client" % "2.2.0",
  "com.typesafe.scala-logging"  %%  "scala-logging"     % "3.9.2"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

publishTo := Some(
  if (isSnapshot.value) Opts.resolver.sonatypeSnapshots
  else Opts.resolver.sonatypeStaging
)

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

pomExtra :=
 <developers>
      <developer>
        <id>dominickendrick</id>
        <name>Dominic Kendrick</name>
        <url>https://github.com/dominickendrick</url>
      </developer>
    </developers>

releaseCrossBuild := true
releasePublishArtifactsAction := PgpKeys.publishSigned.value
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts,
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)
