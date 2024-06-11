// Account.scala
class Account (val accountNumber: String, val accountHolder: String) {
  private var balance: Double = 0.0

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$amount. New balance: $$balance")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$amount. New balance: $$balance")
    } else {
      println("Insufficient funds or invalid amount.")
    }
  }

  def getBalance: Double = balance

  override def toString: String = s"Account($accountNumber, $accountHolder, Balance: $$balance)"
}
object Account {
  def apply(accountNumber: String, accountHolder: String): Account = new Account(accountNumber, accountHolder)
}
