
public class TaskManager {
    private Task head;

    public TaskManager() {
        this.head = null;
    }

    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newTask);
        }
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId() == taskId) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.getTaskId() == taskId) {
            head = head.getNext();
            return;
        }

        Task current = head;
        while (current.getNext() != null) {
            if (current.getNext().getTaskId() == taskId) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }

        System.out.println("Task not found.");
    }
}
