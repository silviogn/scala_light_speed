package functional

object CurriedFunctions extends App {

  def mcat(s:String, s2:String) = s + s2

  val mcatCurried = mcat.curried

  println(mcat("Hello ","Silvio"))
  println(mcatCurried("Hello ")("Silvio"))

  val fcat = (s:String, s2:String) => s + s2
  val fcatCurried = fcat.curried  

  println(fcat("Hello ","Silvio"))
  println(fcatCurried("Hello ")("Silvio"))

  val mcatUncirried = Function.uncurried(mcatCurried)
  println(mcatUncirried("Hello ","Silvio"))


}
