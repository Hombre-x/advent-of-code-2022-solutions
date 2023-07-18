package com.mycode
package typeclasses

import fs2.io.file.Path

import domain.DayTypes.Input

/**
 * Typeclass for adapting an Input type to the desired type used for the solution
 * @tparam MI The type on which the input is adapted to, i.g., the type used for the 
 *            day 1 is ElfCalories, of if there exists an instance of Adapter[ElfCalories]
 *            is should be possible to use convert the type Input to ElfCalories via 
 *            adaptInput method.
 */
trait Adapter[MI]:
  
  def adaptInput(input: Input): MI
  
end Adapter

object Adapter:
  
  def apply[MI : Adapter]: Adapter[MI] = summon
