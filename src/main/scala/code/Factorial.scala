package code

import scala.annotation.tailrec

object Factorial extends App {

  def factorial(i: Int): BigInt =
    @tailrec
    def fact(i: Int, accumulator: BigInt): BigInt =
      if i <= 1 then accumulator
      else fact(i - 1, i * accumulator)

    fact(i, BigInt(1))

  println(factorial(800))

  (1000 to 10000).foreach( i => println( s" Factorial of $i: ${factorial(i)}" ))


}
