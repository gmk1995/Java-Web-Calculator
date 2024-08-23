import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static ArrayList<String> toDoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int choice;

        while (!quit) {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    quit = true;
                    System.out.println("Exiting To-Do List App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nTo-Do List App Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Quit");
    }

    private static void addTask() {
        System.out.print("Enter the task description: ");
        String task = scanner.nextLine();
        toDoList.add(task);
        System.out.println("Task added: " + task);
    }

    private static void viewTasks() {
        System.out.println("\nYour To-Do List:");
        if (toDoList.isEmpty()) {
            System.out.println("No tasks in your to-do list.");
        } else {
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    private static void markTaskAsCompleted() {
        viewTasks();
        if (!toDoList.isEmpty()) {
            System.out.print("Enter the number of the task to mark as completed: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (taskNumber > 0 && taskNumber <= toDoList.size()) {
                String completedTask = toDoList.remove(taskNumber - 1);
                System.out.println("Task completed: " + completedTask);
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
