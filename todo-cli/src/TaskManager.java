import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n===== TO‑DO LIST =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markDone();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(desc));
        System.out.println("Task added!");
    }

    private void viewTasks() {
        System.out.println("\nYour Tasks:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet!");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void markDone() {
        viewTasks();
        System.out.print("Enter task number to mark done: ");
        int num = scanner.nextInt();
        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid task number!");
            return;
        }
        tasks.get(num - 1).markDone();
        System.out.println("Task marked complete!");
    }

    private void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int num = scanner.nextInt();
        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid task number!");
            return;
        }
        tasks.remove(num - 1);
        System.out.println("Task deleted!");
    }
}
