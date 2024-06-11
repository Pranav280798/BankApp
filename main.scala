import Bank.{addCustomer, performTransaction}

object main {
  def main(args: Array[String]): Unit = {
    val customer1 = addCustomer("Alice", "C001")
    val customer2 = addCustomer("Bob", "C002")

    val aliceAccount1 = customer1.openAccount("A001")
    val aliceAccount2 = customer1.openAccount("A002")

    val bobAccount1 = customer2.openAccount("A003")

    performTransaction("C001", "A001", Customer.Deposit, 500)
    performTransaction("C001", "A001", Customer.Withdrawal, 100)

    performTransaction("C002", "A003", Customer.Deposit, 1000)
    performTransaction("C002", "A003", Customer.Withdrawal, 200)

    println(s"Alice's Accounts: ${customer1.getAccounts}")
    println(s"Bob's Accounts: ${customer2.getAccounts}")

    println(s"Alice's Balance in Account A001: ${aliceAccount1.getBalance}")
    println(s"Bob's Balance in Account A003: ${bobAccount1.getBalance}")
    
    println(s"list of customer ${Bank.customers}")
  }
}
