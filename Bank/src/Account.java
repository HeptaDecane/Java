public class Account {
// Fields
    private String accountNumber;
    private double balance;
    private String name;
    private String email;
    private String phoneNumber;

// Constructors
    public Account(){
        this.accountNumber = "None";
        this.name = "None";
        this.balance = 0.0;
        this.email = "None";
        this.phoneNumber = "None";
        System.out.println("======= New Account Created =======");
    }
    public Account(String accountNumber,String name,double balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.email = "None";
        this.phoneNumber = "None";
        System.out.println("======= New Account Created for " + this.name + " =======" );
    }

// Methods
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String  getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public String getEmail(){
        return email;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public boolean deposit(double amount){
        System.out.println("\t "+this.balance);
        System.out.println("\t+"+amount);

        balance += amount;

        System.out.println("\tTransaction Successful.");
        System.out.println("\tBalance: "+this.balance+"\n");
        return true;
    }
    public boolean withdraw(double amount){
        if(balance < amount) {
            System.out.println("\t "+this.balance);
            System.out.println("\t-"+amount);
            System.out.println("\tTransaction Failed.");
            System.out.println("\tBalance: "+this.balance+"\n");
            return false;
        }
        System.out.println("\t "+this.balance);
        System.out.println("\t-"+amount);

        balance -= amount;

        System.out.println("\tTransaction Successful.");
        System.out.println("\tBalance: "+this.balance+"\n");
        return true;
    }
}
