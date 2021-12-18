package my_budget_app.model;

public class MonthlyExpenses {
    private int housing;
    private int auto;
    private int phone;
    private int utilities;
    private int studentLoans;
    private int creditCard;
    private int misc;
    private int entertainment;

    public MonthlyExpenses(int housing, int auto, int phone, int utilities, int studentLoans, int creditCard, int misc, int entertainment) {
        this.housing = housing;
        this.auto = auto;
        this.phone = phone;
        this.utilities = utilities;
        this.studentLoans = studentLoans;
        this.creditCard = creditCard;
        this.misc = misc;
        this.entertainment = entertainment;
    }

    public int getHousing() {
        return housing;
    }

    public void setHousing(int housing) {
        this.housing = housing;
    }

    public int getAuto() {
        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getUtilities() {
        return utilities;
    }

    public void setUtilities(int utilities) {
        this.utilities = utilities;
    }

    public int getStudentLoans() {
        return studentLoans;
    }

    public void setStudentLoans(int studentLoans) {
        this.studentLoans = studentLoans;
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

    public int getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(int entertainment) {
        this.entertainment = entertainment;
    }

    @Override
    public String toString() {
        return "Your monthly expense profile is as follows.... " +
                "Mortgage/Rent Payment: " + housing + "\r\n" +
                "Vehicle Payment: " + auto + "\r\n" +
                "Phone Bill: " + phone + "\r\n" +
                "Utilities Bill: " + utilities + "\r\n" +
                "Student Loans Payment: " + studentLoans + "\r\n" +
                "Credit Card Payment: " + creditCard + "\r\n" +
                "Misc: " + misc + "\r\n" +
                "Entertainment: " + entertainment;
    }
}
