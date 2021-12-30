package my_budget_app.brandon_3.pojos;

public class Debt {

    private int debt_id;
    private int student_loans;
    private int home_loan;
    private int auto_loan;
    private int credit_card;
    private int misc;

    public Debt(int debt_id, int student_loans, int home_loan, int auto_loan, int credit_card, int misc) {
        this.debt_id = debt_id;
        this.student_loans = student_loans;
        this.home_loan = home_loan;
        this.auto_loan = auto_loan;
        this.credit_card = credit_card;
        this.misc = misc;
    }

    public int getDebt_id() {
        return debt_id;
    }

    public void setDebt_id(int debt_id) {
        this.debt_id = debt_id;
    }

    public int getStudent_loans() {
        return student_loans;
    }

    public void setStudent_loans(int student_loans) {
        this.student_loans = student_loans;
    }

    public int getHome_loan() {
        return home_loan;
    }

    public void setHome_loan(int home_loan) {
        this.home_loan = home_loan;
    }

    public int getAuto_loan() {
        return auto_loan;
    }

    public void setAuto_loan(int auto_loan) {
        this.auto_loan = auto_loan;
    }

    public int getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(int credit_card) {
        this.credit_card = credit_card;
    }

    public int getMisc() {
        return misc;
    }

    public void setMisc(int misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Debt{" +
                "debt_id=" + debt_id +
                ", student_loans=" + student_loans +
                ", home_loan=" + home_loan +
                ", auto_loan=" + auto_loan +
                ", credit_card=" + credit_card +
                ", misc=" + misc +
                '}';
    }
}
