package my_budget_app.models;

import java.math.BigDecimal;

public class Debts {

    private int debt_id;
    private int user_id;
    private BigDecimal student_loans;
    private BigDecimal home_loan;
    private BigDecimal auto_loan;
    private BigDecimal credit_card;
    private BigDecimal misc;


    public Debts(BigDecimal student_loans, BigDecimal home_loan, BigDecimal auto_loan, BigDecimal credit_card, BigDecimal misc) {
        this.student_loans = student_loans;
        this.home_loan = home_loan;
        this.auto_loan = auto_loan;
        this.credit_card = credit_card;
        this.misc = misc;
    }

    public Debts(int user_id, BigDecimal student_loans, BigDecimal home_loan, BigDecimal auto_loan, BigDecimal credit_card, BigDecimal misc) {
        this.user_id = user_id;
        this.student_loans = student_loans;
        this.home_loan = home_loan;
        this.auto_loan = auto_loan;
        this.credit_card = credit_card;
        this.misc = misc;
    }

    public Debts(int debt_id, int user_id, BigDecimal student_loans, BigDecimal home_loan, BigDecimal auto_loan, BigDecimal credit_card, BigDecimal misc) {
        this.debt_id = user_id;
        this.student_loans = student_loans;
        this.home_loan = home_loan;
        this.auto_loan = auto_loan;
        this.credit_card = credit_card;
        this.misc = misc;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getStudent_loans() {
        return student_loans;
    }

    public void setStudent_loans(BigDecimal student_loans) {
        this.student_loans = student_loans;
    }

    public BigDecimal getHome_loan() {
        return home_loan;
    }

    public void setHome_loan(BigDecimal home_loan) {
        this.home_loan = home_loan;
    }

    public BigDecimal getAuto_loan() {
        return auto_loan;
    }

    public void setAuto_loan(BigDecimal auto_loan) {
        this.auto_loan = auto_loan;
    }

    public BigDecimal getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(BigDecimal credit_card) {
        this.credit_card = credit_card;
    }

    public BigDecimal getMisc() {
        return misc;
    }

    public void setMisc(BigDecimal misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Your debts on entry (" + this.debt_id + ") include the following..." + "\r\n" +
                "\r\n" +
                "Student Loans: $" + student_loans + "\r\n" +
                "Home Loan: $" + home_loan + "\r\n" +
                "Auto Loans: $" + auto_loan + "\r\n" +
                "Credit Card: $" + credit_card + "\r\n" +
                "Misc: $" + misc;
    }
}
