
public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task(1, "Design Database", "Pending"));
        manager.addTask(new Task(2, "Develop API", "In Progress"));
        manager.addTask(new Task(3, "Test Application", "Completed"));

        System.out.println("All Tasks:");
        manager.traverseTasks();

        System.out.println("\nSearch Task with ID 2:");
        Task task = manager.searchTask(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task with ID 2:");
        manager.deleteTask(2);
        manager.traverseTasks();
    }
}
