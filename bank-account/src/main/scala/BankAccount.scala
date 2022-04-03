import java.util.concurrent.atomic.AtomicInteger

trait DelegateBankAccount {

  def getBalance: Option[Int]

  def incrementBalance(increment: Int): Option[Int]

}

trait BankAccount extends DelegateBankAccount {

  def closeAccount(): Unit

}

object Bank {

  def openAccount(): BankAccount = ForwardingBankAccount()

}

case class ForwardingBankAccount(@volatile private var bankAccount: DelegateBankAccount = OpenBankAccount())
  extends BankAccount {

  override def closeAccount(): Unit = { bankAccount = ClosedBankAccount }

  override def getBalance: Option[Int] = bankAccount.getBalance

  override def incrementBalance(increment: Int): Option[Int] = bankAccount.incrementBalance(increment)

}

case class OpenBankAccount(balance: AtomicInteger = new AtomicInteger(0)) extends DelegateBankAccount {

  override def getBalance: Option[Int] = Some(balance.intValue())

  override def incrementBalance(increment: Int): Option[Int] = Some(balance.addAndGet(increment))

}

object ClosedBankAccount extends DelegateBankAccount {

  override def getBalance: Option[Int] = None

  override def incrementBalance(increment: Int): Option[Int] = None

}