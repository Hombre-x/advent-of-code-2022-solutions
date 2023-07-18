package com.mycode
package programs

import december.*
import domain.DayTypes.*
import instances.DayInstances.given

import cats.Show

object PerformSolutions:
  
  import day1.*

  val month: List[Input => Day] =
    List( 
      Day.getSolutions(CalorieCount.countMacros, CalorieCount.threeElfs)

    )
 
end PerformSolutions
