import java.util.Map;

public class Main {
    static {
        Inventory.addItem(new Item("Bronze",25.95,78));
        Inventory.addItem(new Item("Silver",30.54,67));
        Inventory.addItem(new Item("Gold",45.64,43));
        Inventory.addItem(new Item("Platinum",53.75,37));
        Inventory.addItem(new Item("Diamond",62.36,24));
        Inventory.addItem(new Item("Emerald",74.84,17));
    }
    public static void main(String[] args) {
        inventoryStatus();

        Cart cart1 = new Cart("Player1");
        cart1.add("Emerald",5);
        cart1.add("Platinum",3);
        cart1.add("Diamond",6);
        inventoryStatus();
        cartStatus(cart1);

        cart1.remove("Platinum");
        inventoryStatus();
        cartStatus(cart1);

        //can't remove more than available (i.e. stock-reserved);
        //6 of 24 booked
        Inventory.updateStock("Diamond",-24);
        inventoryStatus();

        cartStatus(cart1);
        System.out.println("CHECKOUT...\nTotal Cost: "+cart1.checkout()+"$");
        cartStatus(cart1);

        inventoryStatus();


    }

    public static void inventoryStatus(){
        Map<String,Item> inventory = Inventory.getInventory();
        System.out.println("\nSUPERETTE:");
        for(String name: inventory.keySet()){
            Item item = Inventory.getItem(name);
            System.out.println(item+"    "+item.status());
        }
    }

    public static void cartStatus(Cart obj){
        Map<Item,Integer> cart = obj.getCart();
        boolean empty = true;
        System.out.println("\nCART: "+obj.getName());
        for(Item item:cart.keySet()) {
            System.out.println(item + "  x" + cart.get(item));
            empty = false;
        }
        if(empty)
            System.out.println("Empty!");
    }
}
