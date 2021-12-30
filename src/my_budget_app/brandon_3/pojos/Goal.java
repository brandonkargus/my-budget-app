package my_budget_app.brandon_3.pojos;

public class Goal {

    private int goals_id;
    private int savings;
    private int vacation;
    private int retirement;
    private int misc;

    public Goal(int goals_id, int savings, int vacation, int retirement, int misc) {
        this.goals_id = goals_id;
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
        return "Goal{" +
                "goals_id=" + goals_id +
                ", savings=" + savings +
                ", vacation=" + vacation +
                ", retirement=" + retirement +
                ", misc=" + misc +
                '}';
    }
}
