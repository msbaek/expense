package expensereport;

import static expensereport.Expense.Type.BREAKFAST;
import static expensereport.Expense.Type.DINNER;

public class BreakfastExpense extends Expense {
    public BreakfastExpense(int amount) {
        super(Type.BREAKFAST, amount);
    }

    boolean isOverage() {
        return ((type == DINNER && amount > 5000)
                || (type == BREAKFAST && amount > 1000));
    }

    boolean isMeal() {
        return type == BREAKFAST || type == DINNER;
    }
}
