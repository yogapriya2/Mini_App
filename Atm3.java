
import java.util.Scanner;

public class Atm3 {
  static Scanner sc;
  static int den[] = { 2000, 500, 100, 50 };
  static int amountlocker[] = { 10, 10, 10, 10 };
  static String username[] = { "Priya", "Karthi" };
  static int passcode[] = { 123, 456 };
  static int amount[] = { 20000, 10000 };
  static int ind, bal = 0;

  static void home() {
    sc = new Scanner(System.in);
    System.out.println(
        "Welcome ATM" + "\n" + "\n" + "1.admin" + "\n" + "2.user" + "\n" + "3.exit" + "\n" + "Enter your choice");
    while (true) {
      int ch = sc.nextInt();
      switch (ch) {
        case 1:
          admin();
          break;
        case 2:
          user();
          break;
        case 3:
          System.exit(0);
          break;
        default:
          System.out.println("Invalid Input");
          break;
      }
    }
  }

  static void admin() {
    System.out.println("Enter the name");
    String name = sc.next();
    System.out.println("Enter the pin");
    int b = sc.nextInt();
    if (name.equals("Priya") && (b == 123) || (name.equals("Karthi")) && (b == 456)) {
      System.out.println("1.add money" + "\n" + "2.show balance" + "\n" + "3.exit");
      while (true) {
        int a = sc.nextInt();
        if (a == 1) {
          addmoney();
        } else if (a == 2) {
          showbalance();
        } else if (a == 3) {
          System.exit(0);
        }
      }
    }
  }

  static void user() {
    System.out.println("Enter user name");
    String c = sc.next();
    System.out.println("Enter pin code");
    int d = sc.nextInt();

    for (int i = 0; i < username.length; i++) {
      if (c.equals(username[i])) {
        ind = i;
      }
    }
    if (c.equals(username[ind]) && d == passcode[ind]) {
      System.out.println("Wecome to the user login" + "\n" + "\n" + "1.withdraw" + "\n" + "2.balance" + "\n"
          + "3.deposit" + "\n" + "4.pin change" + "\n" + "5.exit" + "\n" + "enter your choice");
      int s = sc.nextInt();
      if (s == 1) {
        withdraw();
      } else if (s == 2) {
        balance();
      } else if (s == 3) {
        System.out.println("deposit");
      } else {
        home();
      }
    }

  }

  static void addmoney() {
    System.out.println("enter the denomination");
    for (int i = 0; i < amountlocker.length; i++) {
      System.out.println("enter no of " + den[i] + ":");
      amountlocker[i] = amountlocker[i] + sc.nextInt();

      System.out.println("Amount added successfully");
    }
    System.out.println("Welcomw Admin");
    admin();

  }

  static void showbalance() {
    int sum = 0;
    for (int i = 0; i < amountlocker.length; i++) {
      System.out.println(den[i] + " = " + (amountlocker[i]));
      sum = sum + (den[i] * (amountlocker[i]));
    }
    System.out.println("Over All Amount");
    System.out.println(sum);
    System.out.println("If you want to go back" + "\n" + " 1. admin page " + "\n" + "or" + "\n" + "2. exit" + "\n"
        + "enter your choice");
    int q = sc.nextInt();
    if (q == 1) {
      admin();
    } else if (q == 2) {
      home();
    }
  }

  static void withdraw() {
    System.out.println("Enter the amount");
    int g = sc.nextInt();
    if (g < amount[ind]) {
      System.out.println("Please collect your cash");
      bal = amount[ind] - g;

      user();

    } else {
      System.out.println("Insufficient balance");
    }
  }

  static void balance() {
    System.out.println("your balance is " + bal);
  }

  static void deposit() {

  }

  public static void main(String[] args) {
    home();
  }
}