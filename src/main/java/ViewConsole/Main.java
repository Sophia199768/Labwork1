package ViewConsole;

import Bank.Bank;
import Bank.BankInterface;
import User.State;
import User.User;
import User.IncompleteAccessUser;
import User.FullAccessUser;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static List<BankInterface> banks = new LinkedList<>();
    private static Integer currentBank;

    public static void chooseBank() {
        Scanner scanner = new Scanner(System.in);

        String[] choices = new String[banks.size()];

        for (int i = 0; i < banks.size(); i++) {
            choices[i] = banks.get(i).getName();
        }

        System.out.println("Start work");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        int choice;
        do {
            System.out.print("Choose your bank: ");
            choice = scanner.nextInt();
            currentBank = choice;
        } while (choice < 1 || choice > choices.length);
        startWork();
    }
    public static void startWork() {
        Scanner scanner = new Scanner(System.in);

        String[] choices = {"Log in", "Sign up"};

        System.out.println("Start work");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        Integer choice;
        do {
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            if (choice == 1) {
                entrance();
            } else if (choice == 2) {
                register();
            }
        } while (choice < 1 || choice > choices.length);

    }


    public static void entrance() {

    }
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String surname = "";
        Integer passport = 0;
        State newState;

        do {
            System.out.println("Enter your name");
            name = scanner.nextLine();
        } while (name.length() == 0);

        do {
            System.out.println("Enter your surname");
            surname = scanner.nextLine();
        } while (surname.length() == 0);

        System.out.println("Enter your address");
        String address = scanner.nextLine();

        System.out.println("Enter your passport");
        passport = scanner.nextInt();

        User newUser = new User(name, surname, address, passport);

        if (Objects.equals(address, "") || passport == 0) {
            newState = new IncompleteAccessUser(newUser);
        } else {
            newState = new FullAccessUser(newUser);
        }

        banks.get(currentBank).returnManager().subscribe(newState);
        createAccount();
    }

    public static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"Credit account", "Deposit account", "Debit account"};

        System.out.println("Chose what account your want to create");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        int choice;
        do {
            System.out.print("Choose your account: ");
            choice = scanner.nextInt();
            currentBank = choice;
        } while (choice < 1 || choice > choices.length);

        banks.get(currentBank);

        setOrGetMoney();
    }
    public static void setOrGetMoney() {
        String[] choices = {"Set money", "Get Money", "Send money"};

        System.out.println("Enter how much money: ");
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        int choice;
        do {
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(System.in.toString());
        } while (choice < 1 || choice > choices.length);

    }

    public static void days() {
        banks.forEach(bank -> bank.countDays());
    }

    public static void main(String[] args)
    {
        banks.add(new Bank("Sberbank",4,5.0, 200));
        banks.add(new Bank("AlfaBank", 6, 9.3, 400));
        banks.add(new Bank("Tinkoff", 12, 3.0, 600));
        chooseBank();
    }
}