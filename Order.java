import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<FoodItem> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addFoodItem(FoodItem item) {
        items.add(item);
    }

    public double calculateTotalBill() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void printOrderSummary() {
        System.out.println("\n==================================================");
        System.out.println("             🧾 ORDER SUMMARY & MONEY RECEIPT             ");
        System.out.println("==================================================");
        System.out.println(" 🆔 Customer ID : " + customer.getCustomerId());
        System.out.println(" 👤 Name        : " + customer.getName());
        System.out.println(" 📞 Contact     : " + customer.getPhone());
        System.out.println(" 📍 Deliver To  : " + customer.getDeliveryAddress());
        System.out.println("--------------------------------------------------");
        System.out.printf(" %-36s %s\n", "ITEM DETAILS", "SUBTOTAL");
        System.out.println("--------------------------------------------------");

        for (FoodItem item : items) {
            item.displayDetails();
        }

        double totalBill = calculateTotalBill();
        double vat = totalBill * 0.05;
        double grandTotal = totalBill + vat;

        System.out.println("--------------------------------------------------");
        System.out.printf(" %-35s %7.1f Tk\n", "Total Bill:", totalBill);
        System.out.printf(" %-35s %7.1f Tk\n", "VAT (5%):", vat);
        System.out.println("==================================================");
        System.out.printf(" %-35s %7.1f Tk\n", "GRAND TOTAL:", grandTotal);
        System.out.println("==================================================\n");
    }
}