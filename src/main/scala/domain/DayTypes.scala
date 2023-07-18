package com.mycode
package domain

import cats.data.Reader
import december.*

import cats.Show
import com.mycode.typeclasses.Adapter

object DayTypes:
  
  type Input = List[String]
  
  case class Day(part1: String, part2: String)
  object Day:
    private def performSolutions[I: Adapter, O: Show](input: Input)(solution: I => O): String =
      (Show[O].show compose solution compose Adapter[I].adaptInput)(input)
      
    def getSolutions[I : Adapter, O : Show](solution1: I => O, solution2: I => O): Input => Day =
      (input: Input) =>
        Day(
          performSolutions[I, O](input)(solution1),
          performSolutions[I, O](input)(solution2)
        )
  end Day
  
  
  // Day 1
  private type Food = Vector[Int]
  type ElfCalories = Vector[Food]
  
  // Day 2
  enum Move:
    case Rock
    case Paper
    case Scissors
    
  enum Action:
    case Draw
    case Win
    case Lose

  case class Round(elf: Move, mine: Action)
  type Strategy = Vector[Round]
 
end DayTypes
