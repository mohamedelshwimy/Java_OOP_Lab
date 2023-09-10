public class Account {
    int accountNumber;
    String ownerName;
    double balance;
    private static Account instance;
    public Account(int accountNumber,String ownerName,double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }



}
