package com.mycode
package december.day1

import cats.Show

import typeclasses.Adapter
import instances.DayInstances.day1Adapter
import domain.DayTypes.*

object CalorieCount:
  
  // Part 1
  def countMacros(calories: ElfCalories): Int = calories.map(elfs => elfs.sum).max

  // Part 2
  def threeElfs(calories: ElfCalories): Int =
    calories
      .map(_.sum)
      .sortWith(_ > _)
      .take(3)
      .sum
  
end CalorieCount


