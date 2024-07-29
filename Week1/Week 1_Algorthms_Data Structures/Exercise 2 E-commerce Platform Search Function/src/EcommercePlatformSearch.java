
public class EcommercePlatformSearch {
    public static void main(String[] args) {
        Product[] products = {
                new Product("1", "Laptop", "Electronics"),
                new Product("2", "Smartphone", "Electronics"),
                new Product("3", "Tablet", "Electronics"),
                new Product("4", "Headphones", "Accessories"),
                new Product("5", "Charger", "Accessories")
        };

        String searchName = "Tablet";
        int linearSearchIndex = Search.linearSearch(products, searchName);
        if (linearSearchIndex != -1) {
            System.out.println("Linear Search: Product found at index " + linearSearchIndex);
        } else {
            System.out.println("Linear Search: Product not found");
        }

        Search.sortProductsByName(products);

        int binarySearchIndex = Search.binarySearch(products, searchName);
        if (binarySearchIndex != -1) {
            System.out.println("Binary Search: Product found at index " + binarySearchIndex);
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}
