package my_budget_app.model;

public class AccountBalances {
    private int checking;
    private int savings;

    public AccountBalances(int checking, int savings) {
        this.checking = checking;
        this.savings = savings;
    }

    public int getChecking() {
        return checking;
    }

    public void setChecking(int checking) {
        this.checking = checking;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    @Override
    public String toString() {
        return "Balances for this account profile are as follows...." +
                "Checking: " + checking + "\r\n" +
                "Savings: " + savings;
    }
}
