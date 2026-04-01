public class Burger extends FoodItem {
    private String type;

    public Burger(String id, String name, double price, int quantity, String type) {
        super(id, name, price, quantity);
        this.type = type;
    }

    @Override
    public void displayDetails() {
        System.out.printf("🍔 %-32s\n", getName() + " [" + type + "]");
        System.out.printf("   --> %.1f Tk x %-15d %.1f Tk\n", getPrice(), getQuantity(), getTotalPrice());
    }
}