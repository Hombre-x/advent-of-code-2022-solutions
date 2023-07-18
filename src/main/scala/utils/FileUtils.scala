package com.mycode
package utils

import cats.syntax.all.*
import cats.effect.Concurrent
import fs2.text.utf8
import fs2.io.file.{Files, Path}
import domain.DayTypes.Input

/**
 * Reads a file containing the different inputs for the day, then parses each line 
 * to store it inside a list.
 * 
 * @param path Path of the file
 * @tparam F Effect type with an instance of Files and Concurrent from Cats Effect
 * @return An effect F containing the different lines of the input 
 */

def getInputs[F[_] : Files : Concurrent](path: Path): F[Input] =
  Files[F].readUtf8Lines(path)
    .handleError(e => s"Not found ${e.getLocalizedMessage}")
    .compile
    .toList


/**
 * 
 * @return A List containing the paths of the different input days
 *         from day 1 to 25
 */

def createPaths: List[Path] =
  (1 to 25).map(n => Path(s"src/main/resources/inputs/day$n.txt")).toList