package advanced

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  val noLazyValueWithSideEffect2 = {
    println("I am so very lazy")
    43
  }
  // lazy evaluation
  lazy val aLazyValue = 2
  // useful in infinite collections

  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy")
    43
  }

  // pseudo-collections =: Options Try
  // options
  // we not do this in scala
  def methodWithCanReturnNull(): String = "hello"
  if (methodWithCanReturnNull() == null){
    // bablablbaa
  }

  val anOption = Option(methodWithCanReturnNull()) // Some("hello scala")
  // option = "collection which contains at most on element: Some(value) or None"
  val stringProcessing = anOption match {
    case Some(string: String) => s"I have obtained a value : $string"
    case None => "I obtained nothing"
  }

  // exception this is the common form
  def methodWhichCanThrwoException(): String = throw new RuntimeException()
  try{
    methodWhichCanThrwoException()
  }
  catch {
    case e: Exception => "This was an exceptions"
  }
  // how we dot his in scala
  val aTry = Try(methodWithCanReturnNull())
  // a try = "collection with either a value if the code wen well
  // or an exception if the code threw one"

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string $validValue"
    case Failure(exception) => s"I have obtained an exception $exception"
  }

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */

  val aFuture = Future({
    println("Loading")
    Thread.sleep(1000)
    println("I have ")
    67
  })
  // Future is a collection which contains a value when it is evaluated
  // Future is composable with map flatMap and Filter
  /// This is to wait until the future end due that the future is executed in
  // another thread
  Thread.sleep(2000)

  // Implicits
  // two common use cases
  // #1: Implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1

  implicit val myImplicitInt: Int = 45
  println(aMethodWithImplicitArgs)

  // #2 Implicit conversion
  //implicit class MyRichInteger(n: Int)
  //  def isEven() = n % 2 == 2
  //println(23.isEven())
}











