Cross publish library for 2.11 and 2.12 with

```
sbt "release cross"
```

Import library with:
```scala
libraryDependencies += "com.gu" %% "social-signin" % "0.1.0"

```

Code example:

```
val idToken = IDToken("YXNkZmFzZGZhc2RmYXNk)
val googleClientID = GoogleClientID("10001")

GoogleOpenIDConnect.fetchSocialUser(idToken, googleClientID).map(_).getOrElse("")
```
