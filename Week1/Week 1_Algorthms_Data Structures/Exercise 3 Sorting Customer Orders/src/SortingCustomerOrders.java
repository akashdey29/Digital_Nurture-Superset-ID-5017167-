
import java.util.Arrays;

public class SortingCustomerOrders {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("1", "Alice", 250.0),
                new Order("2", "Bob", 150.0),
                new Order("3", "Charlie", 300.0),
                new Order("4", "David", 200.0),
                new Order("5", "Eve", 100.0)
        };

        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        SortOrders.bubbleSort(bubbleSortedOrders);
        System.out.println("Orders sorted by Bubble Sort:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        SortOrders.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("Orders sorted by Quick Sort:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}
