package com.mycode
package instances

import fs2.io.file.Path

import typeclasses.Adapter
import domain.DayTypes.*

object DayInstances:
  
  // Day 1
  given day1Adapter: Adapter[ElfCalories] with
    
    override def adaptInput(input: Input): ElfCalories =
      input.foldLeft((Vector.empty[Vector[Int]], Vector.empty[Int])): (accum, cal) =>
        val (mtx, elf) = accum
        if cal matches "[0-9]+" then (mtx, elf :+ cal.toInt)
        else (mtx :+ elf, Vector.empty[Int])
      ._1
    
  end day1Adapter
  
  // Day 2
  given day2Adapter: Adapter[Strategy] with
    
    private def matchMove(move: Char): Move =
      move match
        case 'A' => Move.Rock
        case 'B' => Move.Paper
        case 'C' => Move.Scissors
        
    private def matchAction(action: Char): Action =
      action match
        case 'X' => Action.Lose
        case 'Y' => Action.Win
        case 'Z' => Action.Draw
      
    override def adaptInput(input: Input): Strategy =
      input.foldLeft(Vector.empty[Round]): (accum, round) =>
        round.toCharArray match
          case Array(him, _, me) => accum :+ Round(matchMove(him), matchAction(me))
          
  
  // Day 3
//  given day3instances: Adapter[Any] with {}
 
end DayInstances
