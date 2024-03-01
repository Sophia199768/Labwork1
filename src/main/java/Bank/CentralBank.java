package Bank;

import Account.AccountInterface;
import Account.StrategyInterface;
import Transaction.*;

import java.util.LinkedList;
import java.util.List;

public class CentralBank {
    private final List<Bank> banks = new LinkedList<>();
    private final CentralBankManager centralManager = new CentralBankManager();
    private List<TransactionInterface> transcactionBeetweenTwoBanks = new LinkedList<>();

    /**
     * <p>
     *   CreateBank
     *   Function to create a new bank with parameters such as
     *   name, percent, percent to overdraft and limit
     *   After that we add our new bank in list of banks
     * </p>
     * @return Bank
     */
    public Bank createBank(String name, Integer percent, Double percentToOverdraft, Integer limit) {
        Bank newBank = new Bank(name, percent, percentToOverdraft, limit);
        banks.add(newBank);
        return newBank;
    }

    /**
     * <p>
     *   transactionSendBetweenToBanks
     *   Function to send money between two accounts from another banks
     * </p>
     */
    public void transactionSendBetweenToBanks(StrategyInterface strategyFrom,
                                              StrategyInterface strategyTo,
                                              Integer amountOfMoney,
                                              AccountInterface accountFrom,
                                              AccountInterface accountTo) {
        TransactionSend newTransaction = new TransactionSend(strategyFrom, strategyTo, amountOfMoney, accountFrom, accountTo);
        newTransaction.madeTransaction();
        transcactionBeetweenTwoBanks.add(newTransaction);
    }

    /**
     * <p>
     *   canselTransactions
     *   Function to cansel send transaction
     * </p>
     */
    public void canselTransaction(Integer indexOfCanselTransaction) {
        transcactionBeetweenTwoBanks.get(indexOfCanselTransaction).canselTransaction();
    }
}
