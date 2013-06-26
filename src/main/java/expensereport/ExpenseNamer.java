package expensereport;

public class ExpenseNamer {
    public ExpenseNamer() {
    }

    String getName(Expense expense) {
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