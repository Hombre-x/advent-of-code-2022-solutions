package com.mycode
package app

import cats.syntax.applicative.*
import cats.data.Reader
import december.*

import cats.effect.{IO, IOApp}
import utils.peek

import com.mycode.december.day1.CalorieCount

object Test1 extends IOApp.Simple:

  
  type Input = List[String]
  
  case class Day(part1: String, part2: String)
  
  /**
   *
   * List[Path] =>> List[Input] =>> ??? (List[Days]) =>> List[(String, String)] =>> List[Unit]
   *
   * Stream[F, Path] =>> Stream[F, Input] =>> Stream[F, Days] =>> Stream[F, (String, String)] =>> Stream[F, Nothing]
   *
   */
  

  
  
  override def run: IO[Unit] = ???
  
  
  
end Test1