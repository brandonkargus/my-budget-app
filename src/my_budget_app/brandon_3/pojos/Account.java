package my_budget_app.brandon_3.pojos;

public class Account {

    private int account_id;
    private int checking;
    private int savings;

    public Account(int account_id, int checking, int savings) {
        this.account_id = account_id;
        this.checking = checking;
        this.savings = savings;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
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
        return "Account{" +
                "account_id=" + account_id +
                ", checking=" + checking +
                ", savings=" + savings +
                '}';
    }
}
