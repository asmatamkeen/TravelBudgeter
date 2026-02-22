package logic;

import model.Expense;
import java.util.ArrayList;

public class ExpenseManager {

    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public static ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public static double getTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }
}