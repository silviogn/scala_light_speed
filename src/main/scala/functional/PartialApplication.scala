package functional

object PartialApplication extends App {

  def cast1(s1:String)(s2:String) = s1 + s2
  def cast2(s1:String) = (s2:String) => s1 + s2

  println(cast1("Hello - ")("Silvio"))

  val f = cast2("Hello - ")
  println(f("Silvio"))



}
