## Synopsis

This library is to enable the sharing of social sign-in code.

## Installation

```scala
libraryDependencies ++= Seq(
  "com.gu" %% "social-signin" % "0.1.0"
)
```

## Code Example

```

val idToken = IDToken("YXNkZmFzZGZhc2RmYXNk)
val googleClientID = GoogleClientID("10001")

GoogleOpenIDConnect.fetchSocialUser(idToken, googleClientID).map(_).getOrElse("")
  
```

## Motivation

Reduce duplication and encourage best practice.

## License

SocialSignin is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0) (the "License"); 
you may not use this software except in compliance with the License.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an 
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific 
language governing permissions and limitations under the License.