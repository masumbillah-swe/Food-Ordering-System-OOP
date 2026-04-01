public class Drink extends FoodItem {
    private int volume;

    public Drink(String id, String name, double price, int quantity, int volume) {
        super(id, name, price, quantity);
        this.volume = volume;
    }

    @Override
    public void displayDetails() {
        System.out.printf("🥤 %-32s\n", getName() + " [" + volume + " ml]");
        System.out.printf("   --> %.1f Tk x %-15d %.1f Tk\n", getPrice(), getQuantity(), getTotalPrice());
    }
}