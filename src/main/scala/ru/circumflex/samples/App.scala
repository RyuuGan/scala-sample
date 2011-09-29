package ru.circumflex.samples

import java.util.Date


/**
 * @author Valery Aligorsky
 */
object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    println("concat arguments = " + foo(args))
    val e = new Example
    println(e.registeredAt.map(d => d.toString))
    println(e.queuedAt.map(d => d.toString))
  }

}
