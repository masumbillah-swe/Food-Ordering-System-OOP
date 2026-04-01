import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static List<Customer> customerDatabase = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Customer loggedInCustomer = null;

        System.out.println("==================================================");
        System.out.println("   🚀 WELCOME TO DIU SMART FOOD ORDERING SYSTEM   ");
        System.out.println("==================================================");

        boolean isAppRunning = true;

        // --- AUTHENTICATION LOOP ---
        while (isAppRunning && loggedInCustomer == null) {
            System.out.println("\n--- 🔐 AUTHENTICATION MENU ---");
            System.out.println("1. Register New Account");
            System.out.println("2. Login to Existing Account");
            System.out.println("3. Exit System");
            System.out.print("Select option (1-3): ");

            int authChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (authChoice == 1) {
                System.out.println("\n--- 📝 NEW CUSTOMER REGISTRATION ---");
                System.out.print("Enter Full Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Phone Number: ");
                String phone = scanner.nextLine();
                System.out.print("Enter Delivery Address: ");
                String address = scanner.nextLine();
                System.out.print("Set a Password: ");
                String password = scanner.nextLine();

                String customerId = "CUST-" + (rand.nextInt(9000) + 1000);
                Customer newCustomer = new Customer(customerId, name, phone, address, password);
                customerDatabase.add(newCustomer);

                System.out.println("✅ REGISTRATION SUCCESSFUL! Please Login now.");
                System.out.println("Your Customer ID is: " + customerId);

            } else if (authChoice == 2) {
                System.out.println("\n--- 🔑 SECURE LOGIN ---");
                System.out.print("Enter Phone Number: ");
                String loginPhone = scanner.nextLine();
                System.out.print("Enter Password: ");
                String loginPass = scanner.nextLine();

                boolean found = false;
                for (Customer c : customerDatabase) {
                    if (c.getPhone().equals(loginPhone) && c.verifyPassword(loginPass)) {
                        loggedInCustomer = c;
                        found = true;
                        System.out.println("\n🔓 LOGIN SUCCESSFUL! Welcome back, " + c.getName() + "!");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("❌ Invalid Phone Number or Password. Try again!");
                }

            } else if (authChoice == 3) {
                System.out.println("Shutting down system. Goodbye!");
                isAppRunning = false;
            } else {
                System.out.println("❌ Invalid choice!");
            }
        }

        // --- LOGICAL UX ORDERING PHASE ---
        if (loggedInCustomer != null) {
            Order order = new Order(loggedInCustomer);
            boolean isOrdering = true;

            while (isOrdering) {
                System.out.println("\n--- 🍔 ORDER MENU ---");
                System.out.println("1. Burger (Price depends on type)");
                System.out.println("2. Pizza (Price depends on size)");
                System.out.println("3. Drink (Price depends on volume)");
                System.out.println("4. Finish Order and Generate Bill");
                System.out.print("Select an option (1-4): ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline immediately after choice

                if (choice == 4) {
                    isOrdering = false;
                    break;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Select Burger Type (Chicken/Beef): ");
                        String type = scanner.nextLine();
                        System.out.print("Enter Quantity: ");
                        int burgerQty = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        double burgerPrice = type.equalsIgnoreCase("Beef") ? 400.0 : 350.0;
                        order.addFoodItem(new Burger("B01", type + " Burger", burgerPrice, burgerQty, type));
                        System.out.println("✅ " + burgerQty + " " + type + " Burger(s) added.");
                        break;

                    case 2:
                        System.out.print("Select Pizza Size (Small/Medium/Large): ");
                        String size = scanner.nextLine();
                        System.out.print("Enter Quantity: ");
                        int pizzaQty = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        double pizzaPrice = size.equalsIgnoreCase("Large") ? 1200.0 : (size.equalsIgnoreCase("Medium") ? 850.0 : 500.0);
                        order.addFoodItem(new Pizza("P01", "BBQ Chicken Pizza", pizzaPrice, pizzaQty, size));
                        System.out.println("✅ " + pizzaQty + " " + size + " Pizza(s) added.");
                        break;

                    case 3:
                        System.out.print("Select Drink Volume in ml (e.g., 250, 500): ");
                        int volume = scanner.nextInt();
                        System.out.print("Enter Quantity: ");
                        int drinkQty = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        double drinkPrice = (volume >= 1000) ? 120.0 : ((volume >= 500) ? 70.0 : 40.0);
                        order.addFoodItem(new Drink("D01", "Chilled Cola", drinkPrice, drinkQty, volume));
                        System.out.println("✅ " + drinkQty + " Drink(s) [" + volume + " ml] added.");
                        break;

                    default:
                        System.out.println("❌ Invalid choice! Please select between 1 and 4.");
                }
            }
            order.printOrderSummary();
        }
        scanner.close();
    }
}