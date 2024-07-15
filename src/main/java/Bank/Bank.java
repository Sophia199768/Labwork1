package Bank;

import Account.*;
import Result.ResultInterface;
import Transaction.*;
import User.User;
import java.util.LinkedList;
import java.util.List;

public class Bank {
    private final BankManager manager = new BankManager();
    private final List<DebitDepositAccountInterface> accounts = new LinkedList<>();
    private final List<CreditAccountInterface> creditAccount = new LinkedList<>();
    private List<TransactionInterface> transactions = new LinkedList<>();
    private final String name;
    private final Integer procent;
    private final Double procentToOverdraft;
    private final Integer limit;

    public Bank(String name, Integer procent, Double procentToOverdraft, Integer limit) {
        this.name = name;
        this.procent = procent;
        this.procentToOverdraft = procentToOverdraft;
        this.limit = limit;
    }


    public BankManager returnManager() {
        return manager;
    }
    public String getName() {
        return name;
    }


    public Integer getLimit() {return limit; }

    /**
     * <p>
     *   CreateAccount
     *   Function to create a new user account.
     *   User can create three variants of account:
     *   -deposit
     *   -credit
     *   -debit
     * </p>
     * @return AccountInterface
     */
    public AccountInterface createAccount(String account, User user, Integer amountOfMoney) {
        switch (account) {
            case "credit" -> {
                CreditAccount newCreditAccount = new CreditAccount(amountOfMoney, procentToOverdraft, 0.0);
                creditAccount.add(newCreditAccount);
                return newCreditAccount;
            }
            case "depit" -> {
                DebitAccount newDebitAccount = new DebitAccount(amountOfMoney, procent, user);
                accounts.add(newDebitAccount);
                return newDebitAccount;
            }
            default -> {
                Deposit newDepositAccount = new Deposit(amountOfMoney, procent, 0, user);
                accounts.add(newDepositAccount);
                return newDepositAccount;
            }
        }
    }

    public void changeProcent(Integer newProcent) {
        accounts.forEach(account -> account.changeProcent(newProcent));
    }

    public void addToBalance() {
        accounts.forEach(account -> account.addProcent());
    }

    public void addComission() {
        creditAccount.forEach(account -> account.addComission());
    }

    public void setProcentToOverdraft(Double newOverdraftProcent) {
        creditAccount.forEach(account -> account.setProcentToOverdraft(newOverdraftProcent));
    }

    /**
     * <p>
     *   CountsDays
     *   Function helps count days
     * </p>
     */
    public void countDays() {
        accounts.forEach(account -> account.countProcentMoney());
    }

    /**
     * <p>
     *   Update
     *   Function to add oparations such as addToBalance, addComission.
     * </p>
     */
    public void update(NotifyMessage filename) {
        if (filename.equals(NotifyMessage.remaining)) {
            addToBalance();
        } else if (filename.equals(NotifyMessage.commission)) {
            addComission();
        }
    }

    /**
     * <p>
     *   transactionSend
     *   Function to send money in on bank
     * </p>
     */
    public ResultInterface transactionSend(StrategyInterface strategyFrom,
                                              StrategyInterface strategyTo,
                                              Integer amountOfMoney,
                                              AccountInterface accountFrom,
                                              AccountInterface accountTo) {
        TransactionSend newTransaction = new TransactionSend(strategyFrom, strategyTo, amountOfMoney, accountFrom, accountTo);
        ResultInterface result = newTransaction.madeTransaction();
        transactions.add(newTransaction);
        return result;
    }

    /**
     * <p>
     *   transactionGet
     *   Function to get money from concrete user account
     * </p>
     */
    public ResultInterface transactionGet(StrategyInterface strategyFrom,
                                          Integer amountOfMoney,
                                          AccountInterface accountFrom) {
        TransactionGet newTransaction = new TransactionGet(strategyFrom, amountOfMoney, accountFrom);
        ResultInterface result = newTransaction.madeTransaction();
        transactions.add(newTransaction);
        return result;
    }

    /**
     * <p>
     *   transactionSet
     *   Function to set money to concrete user account
     * </p>
     */
    public ResultInterface transactionSet(StrategyInterface strategyTo,
                               Integer amountOfMoney,
                               AccountInterface accountTo) {
        TransactionSet newTransaction = new TransactionSet(strategyTo, amountOfMoney, accountTo);
        ResultInterface result = newTransaction.madeTransaction();
        transactions.add(newTransaction);
        return result;
    }

    /**
     * <p>
     *   canselTransaction
     *   Function to cansel some transactions
     * </p>
     */
    public void canselTransaction(Integer indexCancel) {
        transactions.get(indexCancel).canselTransaction();
    }
}
