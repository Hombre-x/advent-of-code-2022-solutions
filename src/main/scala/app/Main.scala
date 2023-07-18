package com.mycode
package app

import cats.syntax.applicative.*
import cats.syntax.apply.*
import cats.effect.{IO, IOApp}

import fs2.Stream
import fs2.io.file.{Files, Path}

import programs.PerformSolutions.month
import domain.DayTypes.Input
import utils.{createPaths, getInputs}

object Main extends IOApp.Simple:
  
  override def run: IO[Unit] = IO(Thread.activeCount()).flatMap: t =>
    Stream
      .emits(createPaths)
      .parEvalMap[IO, Input](t)( path => getInputs[IO](path) )
      .evalTap(IO.println)
      .parZipWith(Stream.emits(month))( (inp, day) => day(inp) )
      .evalTap(IO.println)
      .compile
      .drain
  
end Main