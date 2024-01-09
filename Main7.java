public class Main7 {
    public static void main(String[] args) {
        AmazonCRMSystem amazonCRMSystem = new AmazonCRMSystem();

        amazonCRMSystem.addCustomer("C1", "John Doe");
        amazonCRMSystem.addCustomer("C2", "Jane Smith");

        amazonCRMSystem.addProduct("P1", "Laptop");
        amazonCRMSystem.addProduct("P2", "Smartphone");

        amazonCRMSystem.placeOrder("O1", "C1");
        amazonCRMSystem.placeOrder("O2", "C2");

        amazonCRMSystem.displayCustomers();
        amazonCRMSystem.displayProducts();
        amazonCRMSystem.displayOrders();
    }
}