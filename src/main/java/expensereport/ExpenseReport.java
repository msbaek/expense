package expensereport;

import java.util.ArrayList;
import java.util.List;

import static expensereport.Expense.Type.*;

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
        if (isMeal(expense))
            mealExpenses += expense.amount;
        total += expense.amount;
    }

    boolean isMeal(Expense expense) {
        return expense.type == BREAKFAST || expense.type == DINNER;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}