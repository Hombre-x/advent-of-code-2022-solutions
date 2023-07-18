package com.mycode
package utils

import cats.effect.Sync
import cats.syntax.flatMap.*
import cats.syntax.functor.*

extension [F[_] : Sync, A](fa: F[A])
  def peek: F[A] =
    for
      a <- fa
      t <- Sync[F].delay(Thread.currentThread().getName)
      _ <- Sync[F].delay(println(s"[$t] $a"))
    yield a

    

