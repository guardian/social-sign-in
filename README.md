
> [!WARNING]
> As of **12/12/2024** this library is no longer maintained and has been archived. It's last known use was removed from IDAPI in [github/identity@1e3af8](https://github.com/guardian/identity/commit/1e3af820041c6e0b1a95da18a5d939da3bfc368a).

# social-signin

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
