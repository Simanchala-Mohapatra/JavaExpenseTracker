import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


 class Expense {
    private String category;
    private String description;
    private double amount;
    private Date date;

     Expense(String category, String description, double amount, Date date) {
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }   

}

 class ExpenseTracker {
    private List<Expense> expenses;

     ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

     void addExpense(Expense expense) {
        expenses.add(expense);
    }

     List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }
}


 class ExpenseTrackerMain {
    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    Date date = new Date(); // Current date
                    Expense expense = new Expense(category, description, amount, date);
                    expenseTracker.addExpense(expense);
                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    List<Expense> allExpenses = expenseTracker.getAllExpenses();
                    if (allExpenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        System.out.println("All Expenses:");
                        for (Expense e : allExpenses) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
