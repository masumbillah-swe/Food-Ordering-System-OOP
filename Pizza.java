public class Pizza extends FoodItem {
    private String size;

    public Pizza(String id, String name, double price, int quantity, String size) {
        super(id, name, price, quantity);
        this.size = size;
    }

    @Override
    public void displayDetails() {
        System.out.printf("🍕 %-32s\n", getName() + " [" + size + "]");
        System.out.printf("   --> %.1f Tk x %-15d %.1f Tk\n", getPrice(), getQuantity(), getTotalPrice());
    }
}