package my_budget_app.brandon_3.pojos;

import java.util.ArrayList;

public class User extends DBParent3 {

    private int userId;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String phone;
    private ArrayList<Account> accounts;
    private ArrayList<Debt> debts;
    private ArrayList<Goal> goals;

    public User(int userId, String first_name, String last_name, String email, String address, String phone) {
        this.userId = userId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Debt> getDebts() {
        return debts;
    }

    public void setDebts(ArrayList<Debt> debts) {
        this.debts = debts;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public void setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
    }

    public void printAccounts() {
        System.out.println("Here's a summary of your accounts");

        for (Account a : accounts){
            System.out.println(a.toString());
        }
    }

    public void printDebts() {
        System.out.println("Here's a summary of your debts");

        for (Debt d : debts){
            System.out.println(d.toString());
        }
    }

    public void printGoals() {
        System.out.println("Here's a summary of your goals");

        for (Goal g : goals){
            System.out.println(g.toString());
        }
    }

    public void printInfo() {
        System.out.println(toString());
    }

    public int getTotalNetWorth(){
        int worth = 0;

        for(Account a: accounts){
            worth += a.getChecking();
            worth += a.getSavings();
        }

        for(Debt d : debts){
            worth -= d.getAuto_loan();
            // ...
        }

        return worth;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
