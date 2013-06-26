package expensereport;

import java.util.ArrayList;
import java.util.List;

import static expensereport.Expense.Type.BREAKFAST;
import static expensereport.Expense.Type.DINNER;


public class ExpenseReport {
    private List<Expense> expenses = new ArrayList<Expense>();
    private int total;
    private int mealExpenses;
    private ReportPrinter printer;

    public ExpenseReport() {
        total = 0;
        mealExpenses = 0;
    }

    public void printReport(ReportPrinter printer) {
        this.printer = printer;
        totalUpExpenses();
        printExpensesAndTotals();
    }

    private void printExpensesAndTotals() {
        printHeader();
        printExpenses();
        printTotals();
    }

    private void totalUpExpenses() {
        for (Expense expense : expenses)
            addTotals(expense);
    }

    private void addTotals(Expense expense) {
        if (isMeal(expense))
            mealExpenses += expense.amount;
        total += expense.amount;
    }

    private boolean isMeal(Expense expense) {
        return expense.type == BREAKFAST || expense.type == DINNER;
    }

    private void printExpenses() {
        for (Expense expense : expenses)
            printExpense(expense);
    }

    private void printExpense(Expense expense) {
        printer.print(String.format("%s\t%s\t$%.02f\n",
                isOverage(expense) ? "X" : " ",
                getName(expense), penniesToDollars(expense.amount)));
    }

    private boolean isOverage(Expense expense) {
        return ((expense.type == DINNER && expense.amount > 5000)
                || (expense.type == BREAKFAST && expense.amount > 1000));
    }

    private String getName(Expense expense) {
        String name = "TILT";
        switch (expense.type) {
            case DINNER:
                name = "Dinner";
                break;
            case BREAKFAST:
                name = "Breakfast";
                break;
            case CAR_RENTAL:
                name = "Car Rental";
                break;
        }
        return name;
    }

    private void printTotals() {
        printer.print(String.format("\nMeal expenses $%.02f", penniesToDollars(mealExpenses)));
        printer.print(String.format("\nTotal $%.02f", penniesToDollars(total)));
    }

    private void printHeader() {
        printer.print("Expenses " + getDate() + "\n");
    }

    private double penniesToDollars(int amount) {
        return amount / 100.0;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    private String getDate() {
        return "9/12/2002";
    }
}
