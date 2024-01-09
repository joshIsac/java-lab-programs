import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

// Customer class
class Customer {
    String customerId;
    String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{id='" + customerId + "', name='" + name + "'}";
    }
}

// Product class
class Product {
    String productId;
    String name;

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{id='" + productId + "', name='" + name + "'}";
    }
}

// Order class
class Order {
    String orderId;
    String customerId;

    public Order(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', customerId='" + customerId + "'}";
    }
}

// Amazon CRM System
class AmazonCRMSystem {
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    HashMap<String, Customer> customerMap = new HashMap<>();
    HashMap<String, Product> productMap = new HashMap<>();
    HashMap<Customer, HashSet<Product>> customerProductMap = new HashMap<>();


    TreeSet<Customer> sortedCustomers = new TreeSet<>((c1, c2) -> c1.customerId.compareTo(c2.customerId));
    TreeSet<Product> sortedProducts = new TreeSet<>((p1, p2) -> p1.productId.compareTo(p2.productId));

    public void addCustomer(String customerId, String name) {
        Customer customer = new Customer(customerId, name);
        customers.add(customer);
        customerMap.put(customerId, customer);
        sortedCustomers.add(customer);
    }

    public void addProduct(String productId, String name) {
        Product product = new Product(productId, name);
        products.add(product);
        productMap.put(productId, product);
        sortedProducts.add(product);
    }

    public void placeOrder(String orderId, String customerId) {
        Order order = new Order(orderId, customerId);
        orders.add(order);

        Customer customer = customerMap.get(customerId);
        if (customer != null) {
            customerProductMap.computeIfAbsent(customer, k -> new HashSet<>()).addAll(products);
        }
    }

    public void displayCustomers() {
        System.out.println("Customers:");
        for (Customer customer : sortedCustomers) {
            System.out.println(customer);
        }
    }

    public void displayProducts() {
        System.out.println("Products:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }

    public void displayOrders() {
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

