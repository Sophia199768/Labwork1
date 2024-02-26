package Bank;

import Account.*;
import User.User;
import java.util.LinkedList;
import java.util.List;

public class Bank implements BankInterface {
    private final BankManager manager = new BankManager();
    private final List<DebitDepositAccountInterface> accounts = new LinkedList<>();
    private final List<CreditAccountInterface> creditAccount = new LinkedList<>();
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

    @Override
    public BankManager returnManager() {
        return manager;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
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
    @Override
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

    @Override
    public void changeProcent(Integer newProcent) {
        accounts.forEach(account -> account.changeProcent(newProcent));
    }

    public void addToBalance() {
        accounts.forEach(account -> account.addProcent());
    }

    public void addComission() {
        creditAccount.forEach(account -> account.addComission());
    }

    @Override
    public void setProcentToOverdraft(Double newOverdraftProcent) {
        creditAccount.forEach(account -> account.setProcentToOverdraft(newOverdraftProcent));
    }

    /**
     * <p>
     *   CountsDays
     *   Function helps count days
     * </p>
     */
    @Override
    public void countDays() {
        accounts.forEach(account -> account.countProcentMoney());
    }

    /**
     * <p>
     *   Update
     *   Function to add oparations such as addToBalance, addComission.
     * </p>
     */
    @Override
    public void update(NotifyMessage filename) {
        if (filename.equals(NotifyMessage.remaining)) {
            addToBalance();
        } else if (filename.equals(NotifyMessage.commission)) {
            addComission();
        }
    }
}
