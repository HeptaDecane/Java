public class Account {
// Fields
    private String accountNumber;
    private int balance;
    private String name;
    private String email;
    private String phoneNumber;

// Methods
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setBalance(int balance){
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
    public int getBalance(){
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

    public boolean deposit(int amount){
        balance += amount;
        return true;
    }
    public boolean withdraw(int amount){
        if(balance < amount)
            return false;
        balance -= amount;
        return true;
    }
}
