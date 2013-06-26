package expensereport;

public abstract class Expense {
    abstract boolean isOverage();

    abstract boolean isMeal();

    public int amount;

    public Expense(int amount) {
        this.amount = amount;
    }
}
