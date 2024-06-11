
// Bank.scala
class Customer(val name: String, val customerId: String) {
  import Customer._

  private var accounts: List[Account] = List()

  def openAccount(accountNumber: String): Account = {
    val account = Account(accountNumber, name)
    accounts = account :: accounts
    println(s"Account $accountNumber opened for $name.")
    account
  }

  def getAccounts: List[Account] = accounts

  override def toString: String = s"Customer($name, $customerId, Accounts: ${accounts.map(_.accountNumber).mkString(", ")})"

  // Inner class for transactions
  class Transaction(val transactionType: TransactionType, val amount: Double, val account: Account) {
    def execute(): Unit = transactionType match {
      case Deposit =>
        account.deposit(amount)
      case Withdrawal =>
        account.withdraw(amount)
    }
  }
}
object Customer {
  // Case classes and pattern matching for transactions
  trait TransactionType
  case object Deposit extends TransactionType
  case object Withdrawal extends TransactionType

  def apply(name: String, customerId: String): Customer = new Customer(name, customerId)
}