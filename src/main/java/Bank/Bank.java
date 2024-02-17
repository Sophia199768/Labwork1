package Bank;

import Account.*;

import User.User;

import java.util.LinkedList;
import java.util.List;

public class Bank implements BankInterface {
    private String message;
    private BankManager manager = new BankManager();
    private List<DebitDepositAccountInterface> accounts = new LinkedList<DebitDepositAccountInterface>();
    private List<CreditAccountInterface> creditAccount = new LinkedList<CreditAccountInterface>();
    private String name;
    private int procent;
    private int procentToOverdraft;

    public Bank(String _name, int _procent, int _procentToOverdraft) {
        name = _name;
        procent = _procent;
        procentToOverdraft = _procentToOverdraft;
    }

    @Override
    public BankManager returnManager() {
        return manager;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void createAccount(String account, User user, int amountOfMoney) {
        switch (account) {
            case "credit":
                 CreditAccount newCreditAccount = new CreditAccount(amountOfMoney, procent,0, user);
                 creditAccount.add(newCreditAccount);
                break;
            case "depit":
                DebitAccount newDebitAccount = new DebitAccount(amountOfMoney, procent,user);
                accounts.add(newDebitAccount);
                break;
            case "deposit":
                Deposit newDepositAccount = new Deposit(amountOfMoney,procent,0, user);
                accounts.add(newDepositAccount);
                break;
        }
    }

    @Override
    public void changeProcent(int newProcent) {
        for (int i = 0; i < accounts.size(); i++) {
        }
    }

    public void addToBalance() {
        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).addProcent();
        }
    }

    public void addComission() {
        for (int i = 0; i < creditAccount.size(); i++) {
            creditAccount.get(i).addComission();
        }
    }

    @Override
    public void setProcentToOverdraft(int newOverdraftProcent) {
        for (int i = 0; i < creditAccount.size(); i++) {
            creditAccount.get(i).setProcentToOverdraft(newOverdraftProcent);
        }
    }

    @Override
    public void countDays() {
        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).countProcentMoney();
        }
    }

    @Override
    public void update(NotifyMessage filename) {
        if (filename.equals(NotifyMessage.remaining)) {
            addToBalance();
        } else if (filename.equals(NotifyMessage.commission)) {
            addComission();
        }
    }
}
