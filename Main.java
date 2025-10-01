
package main;

import dao.AccountDAO;
import model.Account;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static AccountDAO accountDAO = new AccountDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Banking Management System ===");
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    readAllAccounts();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    deposit();
                    break;
                case 6:
                    withdraw();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }

    private static void showMenu() {
        System.out.println("\n1. Create Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Update Account");
        System.out.println("4. Delete Account");
        System.out.println("5. Deposit");
        System.out.println("6. Withdraw");
        System.out.println("7. Exit");
        System.out.print("Choose: ");
    }

    private static void createAccount() {
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Account account = new Account(name, balance, email);
        accountDAO.create(account);
    }

    private static void readAllAccounts() {
        List<Account> accounts = accountDAO.readAll();
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            accounts.forEach(System.out::println);
        }
    }

    private static void updateAccount() {
        System.out.print("Enter Account ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("New Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("New Email: ");
        String email = scanner.nextLine();

        Account account = new Account(name, balance, email);
        account.setAccountId(id);
        accountDAO.update(account);
    }

    private static void deleteAccount() {
        System.out.print("Enter Account ID to delete: ");
        int id = scanner.nextInt();
        accountDAO.delete(id);
    }

    private static void deposit() {
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        System.out.print("Deposit Amount: ");
        double amount = scanner.nextDouble();
        accountDAO.deposit(id, amount);
    }

    private static void withdraw() {
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        System.out.print("Withdraw Amount: ");
        double amount = scanner.nextDouble();
        accountDAO.withdraw(id, amount);
    }
}