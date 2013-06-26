package expensereport;

public class CarRentalExpense extends Expense {
    public CarRentalExpense(int amount) {
        super(Type.CAR_RENTAL, amount);
    }

    boolean isOverage() {
        return false;
    }

    boolean isMeal() {
        return false;
    }
}
