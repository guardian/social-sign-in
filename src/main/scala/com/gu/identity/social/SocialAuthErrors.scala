package com.gu.identity.social

object SocialAuthErrors {

  sealed trait AuthError
  case object TokenVerificationFailed extends AuthError
  case object MissingScope extends AuthError
  case object UserLookupFailed extends AuthError
  case object CreateUserFailed extends AuthError
  case object UpdateUserFailed extends AuthError
  case object CreateAccessTokenFailed extends AuthError
  case object MissingIDToken extends AuthError

}
