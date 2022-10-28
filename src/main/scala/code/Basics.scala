object Basics extends App {

  val meaningOfLife:Int = 900

  val asBoolean = false /// type is optional

  val meuChar: Char = 'A'

  val aString = "I love scala"

  val aComposedString = "q" + "s" + "a"

  val anInterpolation = s"The meaning of life $aComposedString"

  // expressions
  val anExpression = 2 + 3

  // in scala everything is an expression
  val ifExpression = if (meaningOfLife > 43) 56 else 89

  val chainedExpression = if (meaningOfLife > 45) 56
  else  if (meaningOfLife> 900) 300
  else 0

  // code blocks
  val aCodeBlock = {
    val localValue = 90
    localValue + 3
  }
  println(aCodeBlock)

  def myFunction2(x: Int, y:String): String = {
    y +" "+x
  }

  println(myFunction2(100, "400"))

  // in scala we do not use loops for interation we use recursion

  // the unit return type = no meaningful value === void in other languages like java
  def myUnitReturningFunction(): Unit = {
    println("I do not return unit")
  }

  val theUnit = ()



}
 class Silvio:
   def myFunction(x: Int, y:String): String = {
     y +" "+x
   }