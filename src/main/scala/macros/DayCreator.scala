package com.mycode
package macros

import scala.quoted.*

abstract class Days:
  def adaptInput[In, Out](input: In): Out

inline def createDays: List[Days] = ${ createDaysImpl }


private def createDaysImpl(using Quotes): Expr[List[Days]] = ???



  
