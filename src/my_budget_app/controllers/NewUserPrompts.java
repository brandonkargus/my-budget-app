package my_budget_app.controllers;

import my_budget_app.data.*;
import my_budget_app.model.*;

import java.sql.SQLException;
import java.util.Scanner;

public class NewUserPrompts {
    static Scanner scanner = new Scanner(System.in);

    public static void newUser() throws SQLException, ClassNotFoundException {
        System.out.println("Let's begin by creating your profile....");
        System.out.println();
        System.out.println("Please enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name:");
        String lastName = scanner.nextLine();
        System.out.println();
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        System.out.println("Please enter your address:");
        String address = scanner.nextLine();
        System.out.println("Please enter your phone number:");
        String phone = scanner.nextLine();
        System.out.println("--------------------------");
        System.out.println("Your USER account has been created with the following information: ");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        User user = new User(firstName, lastName, email, address, phone);
        UserToSQL userToSQL = new UserToSQL();
        userToSQL.addUserToTable(user);
        System.out.println("---------------------------");
    }

    public static void newAccountBalances() throws SQLException, ClassNotFoundException {
        String error = "You cannot have an account balance less than 0, please enter a valid amount:";
        System.out.println("Next let's build your financial profile");
        System.out.println("Please enter your initial CHECKING ACCOUNT balance:");
        int checking = scanner.nextInt();
        while (checking < 0) {
            System.out.println(error);
            checking = scanner.nextInt();
        }
        System.out.println("Please enter your initial SAVINGS ACCOUNT balance:");
        int savings = scanner.nextInt();
        while (savings < 0) {
            System.out.println(error);
            savings = scanner.nextInt();
        }
        System.out.println("Thank You!  Your ACCOUNT BALANCES have been updated, with the following values...");
        System.out.println("CHECKING: " + checking);
        System.out.println("SAVINGS: " + savings);
        AccountBalances accountBalances = new AccountBalances(checking, savings);
        AccountBalanceToSQL accountBalanceToSQL = new AccountBalanceToSQL();
        accountBalanceToSQL.addAccountBalanceToTable(accountBalances);
        System.out.println("-------------------------");
    }

    public static void newIncome() throws SQLException, ClassNotFoundException {
        String error = "You can not earn negative dollars, please try again:";
        System.out.println("Next, please enter your INCOME AMOUNT, INCOME SOURCE, and FREQUENCY:");
        System.out.println("AMOUNT:");
        int amount = scanner.nextInt();
        while (amount < 0) {
            System.out.println(error);
            amount = scanner.nextInt();

        }
        scanner.nextLine();
        System.out.println("SOURCE:");
        String source = scanner.nextLine();
        System.out.println("FREQUENCY: (Monthly, Weekly, Bi-Weekly)");
        String frequency = scanner.nextLine();
        System.out.println("INCOME profile created with the following information....");
        System.out.println("AMOUNT: " + amount);
        System.out.println("SOURCE: " + source);
        System.out.println("FREQUENCY: " + frequency);
        Income income = new Income(amount, source, frequency);
        IncomeToSQL incomeToSQL = new IncomeToSQL();
        incomeToSQL.addIncomeToTable(income);
        System.out.println("--------------------------");
    }

    public static void newDebts() throws SQLException, ClassNotFoundException {
        String error = "You cannot have a negative debt, please enter amount (enter 0 for none";
        System.out.println("Please list any DEBT totals you currently have....");
        System.out.println("STUDENT LOANS: ");
        int sl = scanner.nextInt();
        while (sl < 0) {
            System.out.println(error);
            sl = scanner.nextInt();
        }
        System.out.println("HOME LOANS: ");
        int hl = scanner.nextInt();
        while (hl < 0) {
            System.out.println(error);
            hl = scanner.nextInt();
        }
        System.out.println("AUTO LOANS: ");
        int al = scanner.nextInt();
        while (al < 0) {
            System.out.println(error);
            al = scanner.nextInt();
        }
        System.out.println("CREDIT CARD: ");
        int cc = scanner.nextInt();
        while (cc < 0) {
            System.out.println(error);
            cc = scanner.nextInt();
        }
        System.out.println("MISC: ");
        int m = scanner.nextInt();
        while (m < 0) {
            System.out.println(error);
            m = scanner.nextInt();
        }
        System.out.println("DEBTS profile created with the following information...");
        System.out.println("STUDENT LOANS: " + sl);
        System.out.println("HOME LOANS: " + hl);
        System.out.println("AUTO LOANS: " + al);
        System.out.println("CREDIT CARD: " + cc);
        System.out.println("MISC: " + m);
        Debts debt = new Debts(sl, hl, al, cc, m);
        DebtToSQL debtToSQL = new DebtToSQL();
        debtToSQL.addDebtToTable(debt);
        System.out.println("-----------------------------");
    }

    public static void newGoals() throws SQLException, ClassNotFoundException {
        String error = "Number cannot be negative, please try again";
        System.out.println("Next, let's get some information about your future GOALS....");
        System.out.println("SAVINGS: ");
        int s = scanner.nextInt();
        while (s < 0) {
            System.out.println(error);
            s = scanner.nextInt();
        }
        System.out.println("VACATION: ");
        int v = scanner.nextInt();
        while (v < 0) {
            System.out.println(error);
            s = scanner.nextInt();
        }
        System.out.println("RETIREMENT: ");
        int r = scanner.nextInt();
        while (r < 0) {
            System.out.println(error);
            r = scanner.nextInt();
        }
        System.out.println("MISC: ");
        int mg = scanner.nextInt();
        while (mg < 0) {
            System.out.println(error);
            mg = scanner.nextInt();
        }
        System.out.println("Your GOALS have been added with the following values....");
        System.out.println("SAVINGS: " + s);
        System.out.println("VACATION: " + v);
        System.out.println("RETIREMENT: " + r);
        System.out.println("MISC: " + mg);
        Goals goals = new Goals(s, v, r, mg);
        GoalsToSQL goalsToSQL = new GoalsToSQL();
        goalsToSQL.addGoalsToTable(goals);
        System.out.println("--------------------------");
    }


    public static void newWeeklyExpenses() throws SQLException, ClassNotFoundException {
        String error = "Number cannot be negative, please try again";
        System.out.println("Next, let's get some information about your WEEKLY EXPENSES....");
        System.out.println("GROCERIES: ");
        int g = scanner.nextInt();
        while (g < 0) {
            System.out.println(error);
            g = scanner.nextInt();
        }
        System.out.println("CHILDCARE: ");
        int c = scanner.nextInt();
        while (c < 0) {
            System.out.println(error);
            c = scanner.nextInt();
        }
        System.out.println("FUEL: ");
        int af = scanner.nextInt();
        while (af < 0) {
            System.out.println(error);
            af = scanner.nextInt();
        }
        System.out.println("MISC: ");
        int mwe = scanner.nextInt();
        while (mwe < 0) {
            System.out.println(error);
            mwe = scanner.nextInt();
        }
        System.out.println("Your WEEKLY EXPENSES have been added with the following values....");
        System.out.println("GROCERIES: " + g);
        System.out.println("CHILDCARE: " + c);
        System.out.println("FUEL: " + af);
        System.out.println("MISC: " + mwe);
        WeeklyExpenses weeklyExpenses = new WeeklyExpenses(g, c, af, mwe);
        WeeklyExpensesToSQL weeklyExpensesToSQL = new WeeklyExpensesToSQL();
        weeklyExpensesToSQL.addWeeklyExpensesToTable(weeklyExpenses);
        System.out.println("------------------------");
    }

    public static void newMonthlyExpenses() throws SQLException, ClassNotFoundException {
        String error = "Number cannot be negative, please try again";
        System.out.println("Next, let's get some information about your MONTHLY EXPENSES....");
        System.out.println("HOUSE/RENT PAYMENT: ");
        int h = scanner.nextInt();
        while (h < 0) {
            System.out.println(error);
            h = scanner.nextInt();
        }
        System.out.println("AUTO PAYMENT: ");
        int ap = scanner.nextInt();
        while (ap < 0) {
            System.out.println(error);
            ap = scanner.nextInt();
        }
        System.out.println("PHONE BILL: ");
        int pb = scanner.nextInt();
        while (pb < 0) {
            System.out.println(error);
            pb = scanner.nextInt();
        }
        System.out.println("UTILITIES: ");
        int u = scanner.nextInt();
        while (u < 0) {
            System.out.println(error);
            u = scanner.nextInt();
        }
        System.out.println("STUDENT LOANS: ");
        int slp = scanner.nextInt();
        while (slp < 0) {
            System.out.println(error);
            slp = scanner.nextInt();
        }
        System.out.println("CREDIT CARD: ");
        int ccp = scanner.nextInt();
        while (ccp < 0) {
            System.out.println(error);
            ccp = scanner.nextInt();
        }
        System.out.println("MISC: ");
        int mp = scanner.nextInt();
        while (mp < 0) {
            System.out.println(error);
            mp = scanner.nextInt();
        }
        System.out.println("ENTERTAINMENT: ");
        int ep = scanner.nextInt();
        while (ep < 0) {
            System.out.println(error);
            ep = scanner.nextInt();
        }
        System.out.println("Your MONTHLY EXPENSES have been added with the following values....");
        System.out.println("HOUSING: " + h);
        System.out.println("AUTO: " + ap);
        System.out.println("PHONE: " + pb);
        System.out.println("UTILITIES: " + u);
        System.out.println("STUDENT LOANS: " + slp);
        System.out.println("CREDIT CARD: " + ccp);
        System.out.println("MISC: " + mp);
        System.out.println("ENTERTAINMENT: " + ep);
        MonthlyExpenses monthlyExpenses = new MonthlyExpenses(h, ap, pb, u, slp, ccp, mp, ep);
        MonthlyExpensesToSQL monthlyExpensesToSQL = new MonthlyExpensesToSQL();
        monthlyExpensesToSQL.addMonthlyExpensesToTable(monthlyExpenses);
        System.out.println("----------------------------");
    }

    public static void infoEntry() throws SQLException, ClassNotFoundException {
        newUser();
        newAccountBalances();
        newIncome();
        newDebts();
        newGoals();
        newWeeklyExpenses();
        newMonthlyExpenses();
        System.out.println("Returning to main menu.....");
        MainMenuPrompts.mainMenu();
    }

}
