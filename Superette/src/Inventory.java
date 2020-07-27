import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public abstract class Inventory {
    private static final Map<String,Item> inventory;

    static {
        inventory = new TreeMap<>();
    }

    public static Map<String,Item> getInventory(){
        return Collections.unmodifiableMap(inventory);
    }

    public static int addItem(Item item){
        Item found = inventory.get(item.getName());
        if(found == null)
            inventory.put(item.getName(),item);
        else
            found.updateStock(item.getStock());

        return inventory.get(item.getName()).getStock();
    }

    public static int updateStock(String name,int quantity){
        Item item = inventory.get(name);
        if(item == null)
            return -1;
        return item.updateStock(quantity);
    }

    public static Item getItem(String key){
        return inventory.get(key);
    }
}
