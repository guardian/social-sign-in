package com.gu.identity.social.google

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.gu.identity.social.Google
import com.gu.identity.social.SocialAuthErrors.{AuthError, MissingScope, TokenVerificationFailed}
import com.gu.identity.social.jwt.IDToken
import com.gu.identity.social.jwt.JWTUser
import akka.http.scaladsl.model.Uri

import collection.JavaConverters._
import scala.util.Try

object GoogleOpenIDConnect {

  def fetchSocialUser(idToken: IDToken, googleClientID: GoogleClientID): Either[AuthError, JWTUser] =
    verifyToken(idToken, googleClientID)

  def verifyToken(idToken: IDToken, googleClientID: GoogleClientID): Either[AuthError, JWTUser] = {
    val verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport, GsonFactory.getDefaultInstance)
      .setAudience(List(googleClientID.id).asJavaCollection)
      .setIssuer("https://accounts.google.com")
      .build();

    val googleIdToken = Try(verifier.verify(idToken.token))
    googleIdToken.map {
      token =>
        val payload = token.getPayload
        Right(new JWTUser(
          payload.getSubject,
          payload.getEmail,
          payload.getEmailVerified,
          payload.get("name").toString,
          payload.get("given_name").toString,
          payload.get("family_name").toString,
          Uri(payload.get("picture").toString),
          Google
        ))
    }.recover {
      case e: NullPointerException => {
        Left(MissingScope)
      }
    }.getOrElse(Left(TokenVerificationFailed))
  }
}
