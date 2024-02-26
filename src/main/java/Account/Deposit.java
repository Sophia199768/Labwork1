package Account;

import Result.*;
import User.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Deposit implements DebitDepositAccountInterface {
    private Integer amountOfMoney;
    private Integer procent;
    private Integer year = 365;
    private Integer day = 1;
    private Integer procentMoneyAmount;
    private Integer amountOfDayAccountTaken;
    private Integer startMoneyAmount = 0;
    private Integer startProcentAmount = 0;
    private Integer endOfDebitAccount = 0;
    private  List<Snapshot> snapshots = new LinkedList<Snapshot>();
    private User user;

    public Deposit(Integer amountOfMoney, Integer procent, Integer amountOfDayAccountTaken, User user) {
        this.amountOfMoney = amountOfMoney;
        countProcent(amountOfMoney);
        this.procent = procent;
        procentMoneyAmount = startMoneyAmount;
        this.amountOfDayAccountTaken = amountOfDayAccountTaken;
        this.user = user;
    }

    public void countProcent(Integer amountOfMoney) {
        procent = ((8 * amountOfMoney) / 50000);
    }

    @Override
    public void countProcentMoney() {
        procentMoneyAmount += amountOfMoney * (procentMoneyAmount / year);
        amountOfDayAccountTaken -= day;
    }

    public void setAmountOfMoney(Integer _amountOfMoney) { amountOfMoney = _amountOfMoney; }
    public void setSendProcent(Integer _procent) { procent = _procent; }
    public void setProcentMoneyAmount(Integer _procentMoneyAmount) { procentMoneyAmount = _procentMoneyAmount; }

    /**
     * <p>
     *     AddProcent
     *     Function helps add procent to concrete user
     * </p>
     */
    @Override
    public void addProcent() {
        amountOfMoney += procentMoneyAmount;
        procentMoneyAmount = startProcentAmount;
    }

    /**
     * <p>
     *   SetMoney
     *   Function to set money at user account.
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface setMoney(Integer moneyAmount) {
        amountOfMoney += moneyAmount;
        createSnapshot();
        return new SuccessSetMoney();
    }

    /**
     * <p>
     *   GetMoney
     *   Function to get money from user account.
     *   If all is alright function will return SuccessGetMoney result.
     *   If user hasn't got insufficient amount of money function will return Negative result.
     *   User can get money only after time has ended, so if user tries to get money earlier he will have a result: "Debit account has not ended".
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface getMoney(Integer getMoneyAmount) {
        if (!Objects.equals(amountOfDayAccountTaken, endOfDebitAccount)) {
            return new DebitAccountHasNotEnded("You need to wait till the end of debit account");
        }

        if (getMoneyAmount > amountOfMoney) {
            return new NegativeAmountOfMoney("Insufficient money in the account");
        }

        createSnapshot();

        amountOfMoney -= getMoneyAmount;
        return new SuccessGetMoney();
    }

    @Override
    public void changeProcent(Integer newProcent) {
        procent = newProcent;
    }

    public void createSnapshot() { snapshots.add(new Snapshot(amountOfMoney, procent, procentMoneyAmount)); }

    /**
     * <p>
     *     Restore
     *     Helps cansel transactions.
     * </p>
     */
    @Override
    public void restore() {
        snapshots.get(snapshots.size() - 1).restore();
    }

    /**
     * <p>
     *     Class snapshot
     *     To rememeber all information in current moment. It helps to cansel transaction.
     * </p>
     */
    private class Snapshot {
        private final Integer amountOfMoney;
        private final Integer procent;
        private final Integer procentMoneyAmount;
        public Snapshot(Integer amountOfMoney, Integer procent, Integer procentMoneyAmount) {
            this.amountOfMoney = amountOfMoney;
            this.procent = procent;
            this.procentMoneyAmount = procentMoneyAmount;
        }

        /**
         * <p>
         *   Restore
         *   Function to restore old information
         * </p>
         */
        public void restore() {
            setAmountOfMoney(amountOfMoney);
            setSendProcent(procent);
            setProcentMoneyAmount(procentMoneyAmount);
        }

    }
}
