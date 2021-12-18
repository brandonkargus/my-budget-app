package my_budget_app.model;

public class Goals {
    private int savings;
    private int vacation;
    private int retirement;
    private int misc;

    public Goals(int savings, int vacation, int retirement, int misc) {
        this.savings = savings;
        this.vacation = vacation;
        this.retirement = retirement;
        this.misc = misc;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public int getVacation() {
        return vacation;
    }

    public void setVacation(int vacation) {
        this.vacation = vacation;
    }

    public int getRetirement() {
        return retirement;
    }

    public void setRetirement(int retirement) {
        this.retirement = retirement;
    }

    public int getMisc() {
        return misc;
    }

    public void setMisc(int misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Your Goals.... " + "\r\n" +
                "Savings: " + savings + "\r\n" +
                "Vacation: " + vacation + "\r\n" +
                "Retirement: " + retirement + "\r\n" +
                "Misc: " + misc;
    }
}
