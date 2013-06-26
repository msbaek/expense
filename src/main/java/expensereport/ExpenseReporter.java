package expensereport;


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

    private void printExpenses() {
        for (Expense expense : expenseReport.expenses)
            printExpense(expense);
    }

    private void printExpense(Expense expense) {
        printer.print(String.format("%s\t%s\t$%.02f\n",
                expense.isOverage() ? "X" : " ",
                getName(expense), penniesToDollars(expense.amount)));
    }

    private String getName(Expense expense) {
        String name = "TILT";
        if(expense instanceof DinnerExpense)
            name = "Dinner";
        else if(expense instanceof BreakfastExpense)
            name = "Breakfast";
        else if(expense instanceof CarRentalExpense)
            name = "Car Rental";
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
