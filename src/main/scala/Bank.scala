// Bank.scala
object Bank {
  var customers: Map[String, Customer] = Map()

  def addCustomer(name: String, customerId: String): Customer = {
    val customer = Customer(name, customerId)
    customers += (customerId -> customer)
    println(s"Customer $name added with ID $customerId.")
    customer
  }

  private def getCustomer(customerId: String): Option[Customer] = customers.get(customerId)

  def performTransaction(customerId: String, accountNumber: String, transactionType: Customer.TransactionType, amount: Double): Unit = {
    val customerOpt = getCustomer(customerId)
    customerOpt match {
      case Some(customer) =>
        val accountOpt = customer.getAccounts.find(_.accountNumber == accountNumber)
        accountOpt match {
          case Some(account) =>
            val transaction = new customer.Transaction(transactionType, amount, account)
            transaction.execute()
          case None =>
            println(s"No account found with number $accountNumber for customer $customerId.")
        }
      case None =>
        println(s"No customer found with ID $customerId.")
    }
  }
}
