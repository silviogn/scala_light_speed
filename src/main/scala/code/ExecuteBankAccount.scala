package code
import code._
object ExecuteBankAccount extends App {
  val bankAccount = new BankAccount("200-900", "900009899", "Alberto da Costa Silva", 5000)
  bankAccount.printInformation()
  bankAccount.printInformationWithCodeBlock()
  println(bankAccount.getMoney(90000))
  println(bankAccount.getMoney(90))
  println(bankAccount.getMoneyWithPatterMatching(0))
  println(bankAccount.getMoneyWithPatterMatching(5000))
  println(bankAccount.getMoneyWithPatterMatching(10))

  if (bankAccount.getMoneyWithPatterMatching(5000).contains(true)){
    println("Ok this is fine and we can take the money")
  }

}

class BankAccount(agency: String, account: String, personName: String, funds: Double) {
  def printInformation(): Unit = {
    val message = s"The account belongs to $personName, the agency is $agency and the number is $account "
    println(message)
  }

  def printInformationWithCodeBlock(): Unit = {
    val codeBlock = {
      val message = s"The account belongs to $personName, the agency is $agency and the number is $account "
      message
    }
    println(codeBlock)
  }

  def getMoney(value: Double): Option[Boolean] = {
    val operationResul = {
      if (value > funds) None
      else {
        Some(true)
      }
    }
    operationResul
  }

  def getMoneyWithPatterMatching(value: Double): Option[Boolean] = {
    value match {
      case (0) => None
      case (5000) => Some(true)
      case _ => Some(false)
    }
  }
}



