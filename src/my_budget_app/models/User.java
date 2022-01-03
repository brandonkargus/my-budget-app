package my_budget_app.models;

import java.util.ArrayList;

public class User extends DBParent3 {

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

        for (Accounts a : accounts){
            System.out.println(a.toString());
        }
    }

    public void printDebts() {
        System.out.println("Here's a summary of your debts");
        System.out.println("------------------------------");

        for (Debts d : debts){
            System.out.println(d.toString());
        }
    }

    public void printGoals() {
        System.out.println("Here's a summary of your goals");
        System.out.println("------------------------------");

        for (Goals g : goals){
            System.out.println(g.toString());
        }
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
                "Phone: " + this.phone ;
    }
}
