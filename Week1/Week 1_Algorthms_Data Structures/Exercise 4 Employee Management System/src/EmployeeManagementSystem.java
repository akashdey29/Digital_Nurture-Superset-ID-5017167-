
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);

        manager.addEmployee(new Employee(1, "Alice", "Developer", 80000));
        manager.addEmployee(new Employee(2, "Bob", "Manager", 90000));
        manager.addEmployee(new Employee(3, "Charlie", "Designer", 70000));

        System.out.println("All Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearch Employee with ID 2:");
        Employee employee = manager.searchEmployee(2);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee with ID 2:");
        manager.deleteEmployee(2);
        manager.traverseEmployees();
    }
}
