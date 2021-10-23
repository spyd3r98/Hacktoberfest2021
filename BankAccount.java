
public class BankAccount {

    private long accountNumber;
    private long balance;
    private String customerName;
    private String email;
    private int mobileNumber;

    public void setAccountNumber(long accountNumber){
        this.accountNumber = accountNumber;
    }

    public long getAccountNumber(){
        return accountNumber;
    }

    public void setBalance(long balance){
        this.balance=balance;
    }

    public long getBalance(){
        return balance;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setMobileNumber(int mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public int getMobileNumber(){
        return mobileNumber;
    }

    public void depositFund(long deposit){
        this.balance += deposit;
        System.out.println("deposit money = "+ deposit);
        System.out.println("Total balance = "+ balance);
    }

    public void withdrawal(long withdrawal){
       if(this.balance-withdrawal > 0){
           this.balance -= withdrawal;
           System.out.println("Withdrawal money = "+ withdrawal);
           System.out.println("Total balance = "+ balance);
       }
       else{
           System.out.println("Only "+ balance+" available. withdrawal not proceed");
       }
    }
}
