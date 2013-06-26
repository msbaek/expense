package expensereport;

import java.util.ArrayList;
import java.util.List;

public class ExpenseReport {
    List<Expense> expenses = new ArrayList<Expense>();
    int total;
    int mealExpenses;

    public ExpenseReport() {
    }

    void totalUpExpenses() {
        for (Expense expense : expenses)
            addTotals(expense);
    }

    void addTotals(Expense expense) {
        if (expense.isMeal())
            mealExpenses += expense.amount;
        total += expense.amount;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}