package expensereport;

import static expensereport.Expense.Type.BREAKFAST;
import static expensereport.Expense.Type.DINNER;


public class ExpenseReporter {
    private final ExpenseReport expenseReport = new ExpenseReport();
    private ReportPrinter printer;

    public ExpenseReporter() {
        expenseReport.total = 0;
        expenseReport.mealExpenses = 0;
    }

    public void printReport(ReportPrinter printer) {
        this.printer = printer;
        expenseReport.totalUpExpenses();
        printExpensesAndTotals();
    }

    private void printExpensesAndTotals() {
        printHeader();
        printExpenses();
        printTotals();
    }

    private void totalUpExpenses() {
        expenseReport.totalUpExpenses();
    }

    private void addTotals(Expense expense) {
        expenseReport.addTotals(expense);
    }

    private boolean isMeal(Expense expense) {
        return expenseReport.isMeal(expense);
    }

    private void printExpenses() {
        for (Expense expense : expenseReport.expenses)
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
        printer.print(String.format("\nMeal expenses $%.02f", penniesToDollars(expenseReport.mealExpenses)));
        printer.print(String.format("\nTotal $%.02f", penniesToDollars(expenseReport.total)));
    }

    private void printHeader() {
        printer.print("Expenses " + getDate() + "\n");
    }

    private double penniesToDollars(int amount) {
        return amount / 100.0;
    }

    public void addExpense(Expense expense) {
        expenseReport.addExpense(expense);
    }

    private String getDate() {
        return "9/12/2002";
    }
}
