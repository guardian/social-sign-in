package com.gu.identity.social.jwt

import akka.http.scaladsl.model.Uri

case class JWTUser(id: String,
                   email: String,
                   emailVerified: Boolean,
                   name: String,
                   givenName: String,
                   familyName: String,
                   pictureUrl: Uri,
                   network: Network)

sealed trait Network
case object Google extends Network

case class IDToken(token: String)
case class GoogleClientID(id: String)
case class AccessTokenClientID(id: String)
