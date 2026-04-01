public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private String deliveryAddress;
    private String password; // New Field for Login

    public Customer(String customerId, String name, String phone, String deliveryAddress, String password) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.deliveryAddress = deliveryAddress;
        this.password = password;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getDeliveryAddress() { return deliveryAddress; }

    // Authentication Method (Encapsulation in action)
    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}