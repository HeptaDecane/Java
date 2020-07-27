public class Item {
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



}
