package expensereport;


public class ExpenseReporter {
    private final ExpenseReport expenseReport = new ExpenseReport();
    private final ExpenseNamer expenseNamer = new ExpenseReportNamer();
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

    private void printExpenses() {
        for (Expense expense : expenseReport.expenses)
            printExpense(expense);
    }

    private void printExpense(Expense expense) {
        printer.print(String.format("%s\t%s\t$%.02f\n",
                expense.isOverage() ? "X" : " ",
                expenseNamer.getName(expense), penniesToDollars(expense.amount)));
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
