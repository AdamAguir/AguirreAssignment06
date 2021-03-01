public class Customer{
    private String fName;
    private String lName;
    private double balance;
    private String ssn;

    public class Customer(String fName, String lName, double balance, String ssn){
        this.fName = fName;
        this.lName = lName;
        this.balance = balance;
        this.ssn = ssn;
    }

    public void deposit(double amount){
        try {
            if (amount >= 10000) throw new DepositTooLargeException("Amount must be smaller than 10,000");
        } catch (DepositTooLargeException e) {
            System.out.println(e.getLocalizedMessage());        }
        balance = balance + amount;
    }
    
    public void withdrawl(double amount){
        balance = balance - amount;
    }

    public String getFName(){
        return fName;
    }

    public String getLName(){
        return lName;
    }

    public double getBalance(){
        return balance;
    }

    public String getSsn(){
        return ssn;
    }
    @Override
    public String toString() {
        //TODO
        return null;
    }
}