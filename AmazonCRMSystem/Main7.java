import java.util.Scanner;
public class Main7 {
    public static void main(String[] args) {
      AmazonCRMSystem amazonCRMSystem = new AmazonCRMSystem();
        Scanner in = new Scanner(System.in);

        // Taking user input for adding customers
        System.out.println("Enter customer details:");
        System.out.print("Customer ID: ");
        String customerId = in.next();
        System.out.print("Customer Name: ");
        String customerName = in.next();
        amazonCRMSystem.addCustomer(customerId, customerName);

        // Taking user input for adding products
        System.out.println("\nEnter product details:");
        System.out.print("Product ID: ");
        String productId = in.next();
        System.out.print("Product Name: ");
        String productName = in.next();
        amazonCRMSystem.addProduct(productId, productName);

        // Taking user input for placing orders
        System.out.println("\nEnter order details:");
        System.out.print("Order ID: ");
        String orderId = in.next();
        System.out.print("Customer ID for the order: ");
        String orderCustomerId = in.next();
        amazonCRMSystem.placeOrder(orderId, orderCustomerId);

        // Displaying the information
        System.out.println("\nDisplaying Information:");
        amazonCRMSystem.displayCustomers();
        amazonCRMSystem.displayProducts();
        amazonCRMSystem.displayOrders();

        in.close();
    }
}