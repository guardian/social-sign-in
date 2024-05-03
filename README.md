Publish library with

```
sbt "release"
```

Import library with:
```scala
libraryDependencies += "com.gu" %% "social-signin" % "<latest-version>"

```

Code example:

```
val idToken = IDToken("YXNkZmFzZGZhc2RmYXNk)
val googleClientID = GoogleClientID("10001")

GoogleOpenIDConnect.fetchSocialUser(idToken, googleClientID).map(_).getOrElse("")
```
