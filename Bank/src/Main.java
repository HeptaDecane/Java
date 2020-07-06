public class Main {

    public static void main(String[] args) {
        Account ac001 = new Account();
        Account ac002 = new Account();

        ac001.setAccountNumber("777000001");
        ac001.setName("Foo");
        ac001.setEmail("foo@example.com");
        ac001.setPhoneNumber("+1-9988776655");

        ac002.setAccountNumber("777000002");
        ac002.setName("Bar");
        ac002.setEmail("bar@example.com");
        ac002.setPhoneNumber("+1-4433221100");

        ac001.deposit(100000);
        ac001.withdraw(30000);

        ac002.deposit(100000);
        ac002.withdraw(60000);
        ac002.withdraw(50000);

        System.out.println("Account Holder: " + ac001.getName());
        System.out.println("A/C No.: " + ac001.getAccountNumber());
        System.out.println("Balance: " +  ac001.getBalance());

        System.out.println();

        System.out.println("Account Holder: " + ac002.getName());
        System.out.println("A/C No.: " + ac002.getAccountNumber());
        System.out.println("Balance: " +  ac002.getBalance());
    }

}
