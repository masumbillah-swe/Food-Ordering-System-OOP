public abstract class FoodItem {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public FoodItem(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters (Encapsulation)
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() {
        return price * quantity;
    }

    // Abstract method to be overridden (Abstraction & Polymorphism)
    public abstract void displayDetails();
}