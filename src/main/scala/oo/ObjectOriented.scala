package oo

import oo.ObjectOriented.Animal.canLeave

import scala.annotation.targetName

object ObjectOriented extends App {

  class Animal {
    val age: Int = 0
    val height : Int = 0
    def eat(): Unit = println("Eat")
    def canLive: Boolean = canLeave
  }

  // the constructor parameter is not a field
  // for become a constructor parameter a field it is necessary add the val before
  class Dog(name: String) extends Animal

  class DogDos(val name:String) extends Animal

  val dog = new DogDos("Jose")
  dog.eat()
  println(dog.name)
  dog.eat()

  val animal = new Animal

  //subtype - polymorphic
  val theAnimal:Animal = new DogDos("silvio")
  theAnimal.eat()

  // abstract class
  abstract class WalkingAnimal {
    // al field or methods are public, you can restrict using only private o protected
    private def code()  = 900
    val hasLegs = true
    def wal(): Unit
  }

  class WalkingAnimalExtended extends WalkingAnimal {
    override def wal(): Unit = println("This is the wal method of the walking animal class")
  }
  
  // interface
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    @targetName("name")
    def ?!(thought: String): Unit // valid method name
  }

  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you")
    @targetName("name")
    override def ?!(thought: String): Unit = println(s"This is what do you said  $thought")
  }

  val crock = new Crocodile
  crock.eat()
  crock eat new Animal // this is infix notation, only available for methods with one argument
  crock.?!("Hola como estas amigo")
  crock ?! "Hello how are you"

  // operators in scala are actually methods
  val math = 1 + 2
  val anotherBasicMath = 1 * 2
  println(math + anotherBasicMath)

  // anonymous classes
  val dino = new Crocodile {
    override def eat(animal: Animal): Unit = println("silvio")
  }
  dino eat(new Animal)

  // singleton object
  // only instance of my singleton type
  object MySingleton {
    val myValue = "this is a tes"
    def method(): Int = 500
    def apply(x: Int): Int = x + 1
  }

  MySingleton.apply(900)
  // or
    println(MySingleton(5))

  object Animal { // the class animal and the object animal are code companions
  // companions can access each other private and protected
  // methods and fields
  // singleton animals an instance animals are different things
  val canLeave = false
 }

  val animalCanLeaveForever = Animal.canLeave // this is the same that an static field
  val mannitol = new Animal
  println(s"This animal can live? ${mannitol.canLive}")
  // case classes
  // they are light weight data structures
  // sensible equals and hash code
  // serialization
  // companion with apply
  // patter matching
  case class Person (val name:String, val age:Int) {

  }
  // may be constructed without NEW
  val bob = Person("bob", 55)
  val bob2 = Person.apply("bob2", 55)

  // exceptions
  try {
    val x: String = null
  } catch {
    case e: Exception => "some error message"
  } finally {
    println("some code")
  }

  // generic
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // In scala we opperate with inmuteble values/objects
  // any modification can return an object no object modifications
  /*
    Benefits:
    1 - works miracles in multithreading/distributed env
    2 - helps making sense of code ("reasoning about")
    3 - Scala is closets to the OO ideal
  */


}
















