import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private String name;
    private final Map<Item,Integer> cart;

    public Cart(String name){
        this.name = name;
        cart = new LinkedHashMap<>();
    }

    public String getName(){
        return name;
    }
    public Map<Item,Integer> getCart(){
        return Collections.unmodifiableMap(cart);
    }

    public boolean add(String itemName){
        return add(itemName,1);
    }
    public boolean add(String itemName,int quantity){
        if(quantity <= 0) return false;

        Item item = Inventory.getItem(itemName);
        if(item == null) return false;

        if(item.updateReserved(quantity)) {
            int inCart = cart.getOrDefault(item,0);
            cart.put(item, inCart + quantity);
            return true;
        }
        return false;
    }

    public boolean remove(String itemName){
        Item item = Inventory.getItem(itemName);
        if(item == null) return false;
        int inCart = cart.getOrDefault(item,0);

        return remove(itemName,inCart);
    }
    public boolean remove(String itemName,int quantity){
        if(quantity <= 0) return false;

        Item item = Inventory.getItem(itemName);
        if(item == null) return false;

        int inCart = cart.getOrDefault(item,0);
        if(inCart < quantity) return false;
        if(item.updateReserved(-quantity)) {
            cart.put(item, inCart - quantity);
            if(inCart - quantity == 0)
                cart.remove(item);
            return true;
        }
        return false;
    }

    public double checkout(){
        double total = 0.0;
        for(Item item:cart.keySet()){
            int quantity = cart.get(item);
            double price = item.getPrice();
            total += price*quantity;
            item.checkout(quantity);
        }
        cart.clear();
        return total;
    }
}
