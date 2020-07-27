public class Item implements Comparable<Item> {
    private final String name;
    private double price;
    private int stock,reserved;

    public Item(String name,double price){
        this(name,price,0);
    }
    public Item(String name,double price,int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.reserved = 0;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    public int updateStock(int quantity){
        if(quantity+stock >= 0) {
            stock += quantity;
            return stock;
        }
        return -1;
    }

    public boolean updateReserved(int quantity){
        if(quantity>0){
            if(stock-reserved >= quantity){
                reserved += quantity;
                return true;
            }
        }
        if(quantity<0){
            quantity *= -1;
            if(reserved >= quantity){
                reserved -= quantity;
                return true;
            }
        }
        return false;
    }

    public boolean checkout(int quantity){
        if(quantity<=0)
            return false;
        if(reserved >= quantity){
            reserved -= quantity;
            updateStock(-quantity);
            return true;
        }
        return false;
    }

    public void available(){
        System.out.println(stock-reserved);
    }

    @Override
    public int compareTo(Item second) {
        Item first = this;
        return first.name.compareTo(second.name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj instanceof Item){
            Item first = this;
            Item second = (Item)obj;
            return first.name.equals(second.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name+"  @ "+this.price+"$";
    }
}
