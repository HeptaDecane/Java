public class Main {

    public static void main(String[] args) {
        Account ac001 = new Account();

        ac001.setAccountNumber("777000001");
        ac001.setName("Foo");
        ac001.setEmail("foo@example.com");
        ac001.setPhoneNumber("+1-(998)-877-6655");

        System.out.println("Account Holder: " + ac001.getName());
        System.out.println("A/C No.: " + ac001.getAccountNumber());
        System.out.println("Phone No.: " + ac001.getPhoneNumber());
        System.out.println("Email: " + ac001.getEmail());

        ac001.deposit(100000);
        ac001.withdraw(30000);

        System.out.println();

        Account ac002 = new Account("777000002","Bar",100000);

        ac002.setEmail("bar@example.com");
        ac002.setPhoneNumber("+1(443)-322-1100");

        System.out.println("Account Holder: " + ac002.getName());
        System.out.println("A/C No.: " + ac002.getAccountNumber());
        System.out.println("Phone No.: " + ac001.getPhoneNumber());
        System.out.println("Email: " + ac001.getEmail());

        ac002.withdraw(60000);
        ac002.withdraw(50000);
        ac002.deposit(5000);

    }

}
