import ReleaseTransformations._
import Dependencies._

name := "social-signin"

organization := "com.gu"

scalaVersion := "2.12.4"

libraryDependencies ++= deps

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-target:jvm-1.8",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)

scalacOptions in doc in Compile := Nil
crossScalaVersions := Seq(scalaVersion.value, "2.11.8")

scmInfo := Some(ScmInfo(
  url("https://github.com/guardian/social-sign-in"),
  "scm:git:git@github.com:guardian/social-sign-in.git"
))

homepage := Some(url("https://profile.theguardian.com/signin"))

developers := List(
  Developer(id="", name="Mark Butler", email="markjamesbutler@gmail.com", url=url("https://mark-butler.co.uk"))
)

description := "Scala library for Social Sign-in."

licenses := Seq("Apache V2" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
releaseIgnoreUntrackedFiles := true

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

publishTo := Some(
  if (isSnapshot.value) Opts.resolver.sonatypeSnapshots
  else Opts.resolver.sonatypeReleases
)

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep(action = Command.process("publishSigned", _)),
  setNextVersion,
  commitNextVersion,
  ReleaseStep(action = Command.process("sonatypeReleaseAll", _)),
  pushChanges
)
