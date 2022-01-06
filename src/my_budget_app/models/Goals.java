package my_budget_app.models;

import java.math.BigDecimal;

public class Goals {

    private int goals_id;
    private int user_id;
    private BigDecimal savings;
    private BigDecimal vacation;
    private BigDecimal retirement;
    private BigDecimal misc;

    public Goals(int user_id, BigDecimal savings, BigDecimal vacation, BigDecimal retirement, BigDecimal misc) {
        this.user_id = user_id;
        this.savings = savings;
        this.vacation = vacation;
        this.retirement = retirement;
        this.misc = misc;
    }

    public Goals(int goals_id, int user_id, BigDecimal savings, BigDecimal vacation, BigDecimal retirement, BigDecimal misc) {
        this.goals_id = goals_id;
        this.user_id = user_id;
        this.savings = savings;
        this.vacation = vacation;
        this.retirement = retirement;
        this.misc = misc;
    }

    public int getGoals_id() {
        return goals_id;
    }

    public void setGoals_id(int goals_id) {
        this.goals_id = goals_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getSavings() {
        return savings;
    }

    public void setSavings(BigDecimal savings) {
        this.savings = savings;
    }

    public BigDecimal getVacation() {
        return vacation;
    }

    public void setVacation(BigDecimal vacation) {
        this.vacation = vacation;
    }

    public BigDecimal getRetirement() {
        return retirement;
    }

    public void setRetirement(BigDecimal retirement) {
        this.retirement = retirement;
    }

    public BigDecimal getMisc() {
        return misc;
    }

    public void setMisc(BigDecimal misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Your goals for this profile " + "(" + this.goals_id + ") are the following..." + "\r\n" +
                "\r\n" +
                "Savings: $" + this.savings + "\r\n" +
                "Vacation: $" + this.vacation + "\r\n" +
                "Retirement: $" + this.retirement + "\r\n" +
                "Misc: $" + this.misc + "\r\n" +
                "--------------------------------------------" +
                "\r\n";
    }
}
