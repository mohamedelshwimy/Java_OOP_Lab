import java.util.Objects;
abstract public class Transaction {
    public static int transactionId;
    abstract double execute(Account obj);
}

class Deposit extends Transaction  implements Rollback{
    double amount;
    @Override
    double execute(Account obj) {
        obj.balance += amount;
        Transaction.transactionId = 1;
        return obj.balance;
    }
    @Override
    public double cancelTransaction(Account obj) {
        obj.balance -= amount;
        return obj.balance;
    }
}

class Withdraw extends Transaction implements Rollback{
    double amount;
    @Override
    double execute(Account obj) {
        obj.balance -= amount;
        Transaction.transactionId = 2;
        return obj.balance;
    }
    @Override
    public double cancelTransaction(Account obj) {
        obj.balance += amount;
        return obj.balance;
    }
}

class BalanceInquiry extends Transaction{
    String currencyType;
    final double exchangeRate = 0.93;
    public BalanceInquiry(String currencyType){
        this.currencyType = currencyType;
    }
    @Override
    double execute(Account obj) {
        if(Objects.equals(currencyType, "U")){
            return obj.balance;
        }
        else if(Objects.equals(currencyType, "E")){
           return obj.balance*exchangeRate;
        }
        else{
            System.out.println("Enter a valid Currency");
        }
        return 0;
    }
}
