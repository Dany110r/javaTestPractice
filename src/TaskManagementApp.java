import java.util.ArrayList;
import java.util.Scanner;

// Task class to represent individual tasks
class Task {
    private int taskId;
    private String description;
    private String dueDate;
    private boolean completed;

    // Constructor to initialize a task
    public Task(int taskId, String description, String dueDate) {
        this.taskId = taskId;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    // Getter method for taskId
    public int getTaskId() {
        return taskId;
    }

    // Method to mark task completed
    public void markCompleted() {
        this.completed = true;
    }

    // Getter methods f0r task attributes
    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }
}

// TaskManager classs
class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    // Method to add a new task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method to mark task complete
    public void taskComplete(int taskId) {
        for (Task task : tasks) {
            if (!task.isCompleted() && task.getTaskId() == taskId) {
                task.markCompleted();
                System.out.println("Task with ID " + taskId + " marked as completed.");
                return;
            }
        }
        System.out.println("Task with ID " + taskId + " not found or already completed.");
    }

    // Method to view tasks
    public void viewTasks() {
        for (Task task : tasks) {
            System.out.println("Task ID: " + task.getTaskId());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println("------------------------------");//Lines used for readability
        }
    }

    // Method to generate report for tasks due today
    public void generateReport(String todayDate) {
        System.out.println("Tasks due today (" + todayDate + "):");
        for (Task task : tasks) {
            if (task.getDueDate().equals(todayDate)) {
                System.out.println("Task ID: " + task.getTaskId());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Due Date: " + task.getDueDate());
                System.out.println("Completed: " + task.isCompleted());
                System.out.println("---------------------");
            }
        }
    }
}

public class TaskManagementApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View All Tasks");
            System.out.println("4. Generate Report for Tasks Due Today");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();//Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Due Date: ");
                    String dueDate = scanner.nextLine();
                    Task newTask = new Task(taskId, description, dueDate);
                    taskManager.addTask(newTask);
                    System.out.println("Task added");
                    break;
                case 2:
                    System.out.print("Enter Task ID to mark as completed: ");
                    int taskIdToComplete = scanner.nextInt();
                    taskManager.taskComplete(taskIdToComplete);
                    break;
                case 3:
                    taskManager.viewTasks();
                    break;
                case 4:
                    System.out.print("Enter today's date (format: dd/mm/yyyy): ");
                    String todayDate = scanner.nextLine();
                    taskManager.generateReport(todayDate);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Exiting Task Management App");
        scanner.close();
    }
}