package my_budget_app.model;

public class WeeklyExpenses {
    private int groceries;
    private int childcare;
    private int fuelForAutomobile;
    private int misc;

    public WeeklyExpenses(int groceries, int childcare, int fuelForAutomobile, int misc) {
        this.groceries = groceries;
        this.childcare = childcare;
        this.fuelForAutomobile = fuelForAutomobile;
        this.misc = misc;
    }

    public int getGroceries() {
        return groceries;
    }

    public void setGroceries(int groceries) {
        this.groceries = groceries;
    }

    public int getChildcare() {
        return childcare;
    }

    public void setChildcare(int childcare) {
        this.childcare = childcare;
    }

    public int getFuelForAutomobile() {
        return fuelForAutomobile;
    }

    public void setFuelForAutomobile(int fuelForAutomobile) {
        this.fuelForAutomobile = fuelForAutomobile;
    }

    public int getMisc() {
        return misc;
    }

    public void setMisc(int misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Weekly Expenses = " +
                "groceries = " + groceries +
                ", childcare = " + childcare +
                ", fuelForAutomobile = " + fuelForAutomobile +
                ", misc = " + misc;
    }
}
