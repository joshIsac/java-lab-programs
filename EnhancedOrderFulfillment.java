import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Item {
    private String itemName;
    private int quantity;

    public Item(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }
}

class Order {
    private int orderId;
    private List<Item> items;

    public Order(int orderId, List<Item> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }
}

class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

class EnhancedOrderFulfillmentSystem {
    private List<Item> inventory;
    private ExecutorService executorService;

    public EnhancedOrderFulfillmentSystem(int numThreads) {
        inventory = new ArrayList<>();
        executorService = Executors.newFixedThreadPool(numThreads);
    }

    public synchronized void updateInventory(Order order) throws InsufficientStockException {
        for (Item orderedItem : order.getItems()) {
            int requestedQuantity = orderedItem.getQuantity();

            if (checkInventoryAvailability(orderedItem)) {
                orderedItem.decreaseQuantity(requestedQuantity);
            } else {
                throw new InsufficientStockException("Insufficient inventory for item: " + orderedItem.getItemName());
            }
        }
    }

    public synchronized boolean checkInventoryAvailability(Item item) {
        int totalQuantity=inventory.stream()
.filter(i -> i.getItemName().equals(item.getItemName()))
            .mapToInt(Item::getQuantity)
            .sum();

    return totalQuantity >= item.getQuantity();
}

   public void placeOrder(Order order) {
        executorService.submit(() -> {
            try {
                updateInventory(order);
                // Simulate order processing
                System.out.println("Processing Order: " + order.getOrderId());
                // Your order processing logic here
            } catch (InsufficientStockException e) {
                System.out.println("Order " + order.getOrderId() + " failed: " + e.getMessage());
            }
        });
    }

    public void trackOrderStatus(int orderId) {
        // Simulate tracking information retrieval
        System.out.println("Tracking Order Status for Order ID: " + orderId);
        // Your tracking information retrieval logic here
    }

    public void waitForCompletion() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EnhancedOrderFulfillmentSystem orderFulfillmentSystem = new EnhancedOrderFulfillmentSystem(5);

        // Place some sample orders
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("Item1", 10));
        items1.add(new Item("Item2", 100));
        Order order1 = new Order(1, items1);

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Item1", 200));
        items2.add(new Item("Item2", 1000));
        Order order2 = new Order(2, items2);

        orderFulfillmentSystem.placeOrder(order1);
        orderFulfillmentSystem.placeOrder(order2);

        // Wait for all orders to be processed
        orderFulfillmentSystem.waitForCompletion();
    }
}
