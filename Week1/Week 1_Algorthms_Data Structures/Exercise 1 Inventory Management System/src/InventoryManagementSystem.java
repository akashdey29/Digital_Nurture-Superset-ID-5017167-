
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product("1", "Laptop", 10, 999.99);
        Product product2 = new Product("2", "Smartphone", 20, 499.99);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        System.out.println("Inventory after adding products:");
        inventory.displayProducts();

        product1.setPrice(899.99);
        inventory.updateProduct(product1);

        System.out.println("Inventory after updating a product:");
        inventory.displayProducts();

        inventory.deleteProduct("2");

        System.out.println("Inventory after deleting a product:");
        inventory.displayProducts();
    }
}
