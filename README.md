# my-budget-app

my-budget-app is a basic program for retrieving account, debts, savings, and goal information from new or existing users in a database.  It uses Java 11, Java Database Connectivity(JDBC), and MySQL.

### Requirements

Program uses Java (version 1.5 or greater) and MySQL (version 8.0), please utilize the included dump file for MySQL, and change password for database in class "DBParent" of the Java program to insure proper functionality.  You'll also need an executable "mysql connector JAR file(version 8.0.27 used here)" in the project library.


## Example

```java
Welcome back to your Budget App! What would you like to do? (enter 1 or 2)
1) LOG IN
2) EXIT
1
Please enter your email:
pickle@gmail.com
You're logged in, Peter!

What would you like to do?
1) View ACCOUNT BALANCE(s)
2) View DEBT PROFILE(s)
3) View GOAL ENTRIES
4) View PERSONAL INFO
5) View TOTAL DEBT
6) View TOTAL GOALS
7) Exit
5
Your total debt at this time is....

$280500
---------------------------------
QUICK FACT:  Paying $750 per month toward your total would eliminate your debt in ~561 months (~46 years)..
---------------------------------
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

