package expensereport;

public class ExpenseReportNamer implements ExpenseNamer {
    public ExpenseReportNamer() {
    }

    public String getName(Expense expense) {
        String name = "TILT";
        if (expense instanceof DinnerExpense)
            name = "Dinner";
        else if (expense instanceof BreakfastExpense)
            name = "Breakfast";
        else if (expense instanceof CarRentalExpense)
            name = "Car Rental";
        return name;
    }
}