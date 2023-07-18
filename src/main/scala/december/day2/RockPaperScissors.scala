package com.mycode
package december.day2

import cats.Show
import com.mycode.domain.DayTypes.*

object RockPaperScissors:
  
  // Typelevel
  trait Lose[M1 <: Move, M2 <: Move]
  trait Win[M1 <: Move, M2 <: Move]
  
  given Lose[Move.Scissors.type, Move.Rock.type] with {}
  given Lose[Move.Rock.type, Move.Paper.type] with {}
  given Lose[Move.Paper.type, Move.Scissors.type] with {}
  
  given Win[Move.Scissors.type, Move.Paper.type] with {}
  given Win[Move.Paper.type, Move.Rock.type] with {}
  given Win[Move.Rock.type, Move.Scissors.type] with {}
  

  def firstTournament[M <: Int](strategy: Strategy): Int = ??? 
    

end RockPaperScissors
