package my_budget_app.model;

public class Debts {
    private int studentLoans;
    private int homeLoan;
    private int autoLoan;
    private int creditCard;
    private int misc;

    public Debts(int studentLoans, int homeLoans, int autoLoan, int creditCard, int misc) {
        this.studentLoans = studentLoans;
        this.homeLoan = homeLoans;
        this.autoLoan = autoLoan;
        this.creditCard = creditCard;
        this.misc = misc;
    }

    public int getStudentLoans() {
        return studentLoans;
    }

    public void setStudentLoans(int studentLoans) {
        this.studentLoans = studentLoans;
    }

    public int getHomeLoans() {
        return homeLoan;
    }

    public void setHomeLoans(int homeLoans) {
        this.homeLoan = homeLoans;
    }

    public int getAutoLoan() {
        return autoLoan;
    }

    public void setAutoLoan(int autoLoan) {
        this.autoLoan = autoLoan;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    public int getMisc() {
        return misc;
    }

    public void setMisc(int misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Dept profile is as follows....." + "\r\n" +
                "Student Loans: " + studentLoans + "\r\n" +
                "Home Loan: " + homeLoan +"\r\n" +
                "Auto Loan: " + autoLoan +"\r\n" +
                "Credit Card: " + creditCard + "\r\n" +
                "Misc: " + misc;
    }
}
