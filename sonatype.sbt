sonatypeProfileName := "com.gu"

publishMavenStyle := true

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
