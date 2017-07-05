package com.gu.identity.social.jwt

import akka.http.scaladsl.model.Uri
import com.gu.identity.social.Network

case class JWTUser(id: String,
                   email: String,
                   emailVerified: Boolean,
                   name: String,
                   givenName: String,
                   familyName: String,
                   pictureUrl: Uri,
                   network: Network)


case class IDToken(token: String)
case class AccessTokenClientID(id: String)
