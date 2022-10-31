package functional

object UsingFunctionAsParameter extends App {

  var result = (1 to 10).filter(_ % 2 == 0).map(_ * 2).reduce(_  * _)
  assert(result == 122880)


  var factor = 2
  val multiplier = (i:Int) => i * factor

  var result2 = (1 to 10).filter(_ % 2 == 0).map(multiplier).reduce(_ * _)
  println(result2)


  var comparator = (v:Int) => v % 2 == 0

  var result3 = (1 to 10).filter(comparator).map(multiplier).reduce(_ * _)
  println(result3)

  var range = (1 to 12)

  var product = (v:Int, m:Int) => {
    println(s"Mult:  ${v * m}")
    v * m
  }

  var result3_5 = range.filter(comparator).map(multiplier).reduce(product)
  println(s"This is the value of the product: $result3_5")

  var result4 = range.filter(comparator).map(multiplier).product
  println(result4)




}
