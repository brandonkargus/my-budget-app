package my_budget_app.models;

import java.math.BigDecimal;
import java.util.ArrayList;

public class User extends DBParent {

    private int userId;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String phone;
    private ArrayList<Accounts> accounts;
    private ArrayList<Debts> debts;
    private ArrayList<Goals> goals;


    public User(int userId, String first_name, String last_name, String email, String address, String phone) {
        this.userId = userId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public User(String first_name, String last_name, String email, String address, String phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Accounts> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(ArrayList<Accounts> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Debts> getDebts() {
        return this.debts;
    }

    public void setDebts(ArrayList<Debts> debts) {
        this.debts = debts;
    }

    public ArrayList<Goals> getGoals() {
        return this.goals;
    }

    public void setGoals(ArrayList<Goals> goals) {
        this.goals = goals;
    }

    public void printAccounts() {
        System.out.println("Here's a summary of your accounts");
        System.out.println("---------------------------------");

        for (Accounts a : accounts) {
            System.out.println(a.toString());
        }
    }

    public void printDebts() {
        System.out.println("Here's a summary of your debts");
        System.out.println("------------------------------");

        for (Debts d : debts) {
            System.out.println(d.toString());
        }

    }

    public void printGoals() {
        System.out.println("Here's a summary of your goals");
        System.out.println("------------------------------");

        for (Goals g : goals) {
            System.out.println(g.toString());
        }
    }

    public void printTotalDebts() {
        System.out.println("Your total debt at this time is....");
        System.out.println();
        ArrayList<BigDecimal> allDebts = new ArrayList<>();
        for (Debts d : debts) {
            allDebts.add(d.getAuto_loan());
            allDebts.add(d.getCredit_card());
            allDebts.add(d.getHome_loan());
            allDebts.add(d.getStudent_loans());
            allDebts.add(d.getMisc());

        }
        BigDecimal total = allDebts.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        int totalMonths = (int) (Math.round(total.doubleValue()) / 500);
        int years = totalMonths / 12;
        System.out.println("$" + total);
        System.out.println("---------------------------------");
        System.out.println("QUICK FACT:  Paying $750 per month toward your total would eliminate your debt in ~" + totalMonths + " months (~" + years + " years)..");
        System.out.println("---------------------------------");
    }

    public void printTotalGoals() {
        System.out.println("Your total savings goal at this time.....");
        System.out.println();
        ArrayList<BigDecimal> allGoals = new ArrayList<>();
        for (Goals g : goals) {
            allGoals.add(g.getVacation());
            allGoals.add(g.getSavings());
            allGoals.add(g.getRetirement());
            allGoals.add(g.getMisc());
        }
        BigDecimal total = allGoals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("$ " + total);

        ArrayList<BigDecimal> allVaca = new ArrayList<>();
        for (Goals g : goals) {
            allVaca.add(g.getVacation());
        }

        BigDecimal totalVacation = allVaca.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        int totalMonths = (int) (Math.round(totalVacation.doubleValue()) / 250);
        System.out.println("---------------------------------");
        System.out.println("QUICK FACT: If you saved $250 per month toward your vacation goals, you'd achieve them in ~" + totalMonths + " months!...");
        System.out.println("---------------------------------");
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Your user profile is as follows...." + "\r\n" +
                "\r\n" +
                "Id: " + this.userId + "\r\n" +
                "First Name: " + this.first_name + "\r\n" +
                "Last Name: " + this.last_name + "\r\n" +
                "Email: " + this.email + "\r\n" +
                "Address: " + this.address + "\r\n" +
                "Phone: " + this.phone + "\r\n" +
                "---------------------------------------" +
                "\r\n";
    }
}
