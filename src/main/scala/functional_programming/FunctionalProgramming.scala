package functional_programming

object FunctionalProgramming extends App {

  // scala is a OO language
  class Person(name: String){
    def apply(age:Int) = println(s"I have aged $age years")
  }

  val bob = new Person("bob")
  // both invocations are the same here
  bob.apply(34)
  bob(43)
  /*
  Scala runs on JVM
  in Functional Programming:
  - compose functions
  - pass functions as args
  - return functions as result

  Conclusion: FunctionX
  * */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
 // example
  simpleIncrementer.apply(23)
  // define a function
  simpleIncrementer(23)

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES
  // the max number of args is Function22 - 22

  val stringConcatenation = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(stringConcatenation("I love", " - Scala"))

  // syntax sugars
  val doubler: Function1[Int, Int] = (x:Int) => 2 * x
  doubler(23)
  // the Int => Int is equivalent to Function1
  val double2: (Int) => Int = (x: Int) => 2 * x
  println(double2)

  //another example
  val double3: (Int, Int) => Int = (x:Int, y:Int) => x + y * 2

  // higher order functions: take fucntions as arguments/return functions as results
  val aMappedList: List[Int] = List(1, 2, 3).map(x => x + 1)
  println(aMappedList)

  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x))
  println(aFlatMappedList)
  // this is equivalent to the above command of flatMap
  val aFlatMappedListTwo = List(1,2,3).flatMap {
    x =>
    println("hello")
    List(x, 2 * x)
  }
  // filter
  val aFilteredList = List(1,2,3).filter(x => x % 2 == 0)
  val aFilteredListTwo = List(1,2,3,4,5,6).filter(x => x >= 3)
  // alternative with shorter sin-taxis
  val aFilteredListThree = List(1,2,3,4,5,6).filter(_ >= 3)
  // example with all the possible combinations
  val allPairs = List(1,2,3).flatMap(number => List('a','b','c').map(letter => s"$number-$letter"))
  println(allPairs)

  // for comprehension
  // this is equivalent to the flat map chain
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a','b','c')
  } yield s"$number-$letter"

  /**
   * Collections
   */
  // Lists
  val aList = List(1,2,3,4,5)
  val firstElements = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5) this is the result
  val extendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6) this is the result

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence.apply(1) // the element at index 1: 2

  // vectors: fast seq implementation
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicates
  val aSet = Set(1,2,3,4) // no duplicates
  val hasFive = aSet.contains(5)
  val andAddedSet = aSet + 5 // Set(1,2,3,4,5)
  val removeSet = aSet - 1 // Set(2,3,4,5)

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // List(2,4,6....,2000)

  // tuples
  val aTuple = ("B", "J", 100, 300)

  // maps
  val aMap:Map[String, Int] = Map(
    ("Daniel", 40000),
    ("Silvio", 5000)
  )

}
















