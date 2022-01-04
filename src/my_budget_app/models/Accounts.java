package my_budget_app.models;

import java.math.BigDecimal;

public class Accounts extends DBParent {

    private int account_id;
    private int user_id;
    private BigDecimal checking;
    private BigDecimal savings;


    public Accounts(int user_id, BigDecimal checking, BigDecimal savings) {
        this.user_id = user_id;
        this.checking = checking;
        this.savings = savings;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getChecking() {
        return checking;
    }

    public void setChecking(BigDecimal checking) {
        this.checking = checking;
    }

    public BigDecimal getSavings() {
        return savings;
    }

    public void setSavings(BigDecimal savings) {
        this.savings = savings;
    }


    @Override
    public String toString() {
        return "Individual account information...." + "\r\n" +
                "\r\n" +
                "Account Number: " + this.account_id + "\r\n" +
                "Checking: $" + this.checking + "\r\n" +
                "Savings: $" + this.savings + "\r\n" +
                "\r\n" +
                "---------------------------------";
    }
}
