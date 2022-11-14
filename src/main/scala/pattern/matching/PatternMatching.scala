package pattern.matching

object PatternMatching extends App {

  // patter matching is kind os a switch expression

  val anInteger = 56

  val order = anInteger match {
  case 1 => "first"
  case 2 => "second"
  case 3 => "third"
  case  _ =>  anInteger + "th"
  }
  // PM is an expression
  println(order)

  case class Person(name:String, age:Int)

  /// patter matching available for case classes
  val bob = Person("Bob", 43) // the same that Person.apply("Bob", 43)
  val personGreeting = bob match {
    case Person(n, age) => s"Hi my name is $n and I am $age old."
    case _ => "Something else"
  }
  println(personGreeting)

  // deconstructing tuples
  val aTuple = ("Bon jovi", "Rock")

  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I do not know what you are talking about"
  }

  // decomposing lists
  val aList = List(1,2,3)

  val aListDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "unknown list"
  }

  // if PM does not match anything, it will throw a MatchError
  // PM will try all cases in sequence


}











