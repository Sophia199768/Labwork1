package Account;

import Result.*;
import User.User;

import java.util.LinkedList;
import java.util.List;

public class DebitAccount implements DebitDepositAccountInterface {
    private Integer amountOfMoney;
    private Integer procent;
    private Integer emptyAccount = 0;
    private Integer year = 365;
    private Integer procentMoneyAmount;
    private Integer noProcent = 0;
    private List<Snapshot> snapshots = new LinkedList<Snapshot>();
    private User user;

    public DebitAccount(Integer amountOfMoney, Integer procent, User user) {
        this.amountOfMoney = amountOfMoney;
        this.procent = procent;
        procentMoneyAmount = 0;
        this.user = user;
    }

    @Override
    public void addProcent() {
        if (amountOfMoney > emptyAccount) {
            amountOfMoney += procentMoneyAmount;
            procentMoneyAmount = noProcent;
        }
    }

    /**
     * <p>
     *     CountProcentMoney
     *     Function count percent money for concrete user
     * </p>
     */
    @Override
    public void countProcentMoney() {

        procentMoneyAmount += amountOfMoney * (procentMoneyAmount / year);
    }


    public void setAmountOfMoney(Integer _amountOfMoney) { amountOfMoney = _amountOfMoney; }
    public void setProcentMoneyAmount(Integer _procentMoneyAmount) { procentMoneyAmount = _procentMoneyAmount; }

    /**
     * <p>
     *     ChangeProcent
     *     Function changes percent for user
     * </p>
     */
    @Override
    public void changeProcent(Integer newProcent) {
        procent = newProcent;
    }

    /**
     * <p>
     *   SetMoney
     *   Function to set money at user account.
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface setMoney(Integer setMoneyAmount) {
        amountOfMoney += setMoneyAmount;
        createSnapshot();
        return new SuccessSetMoney();
    }

    /**
     * <p>
     *   GetMoney
     *   Function to get money from user account.
     *   If all is alright function will return SuccessGetMoney result.
     *   If user hasn't got insufficient amount of money function will return Negative result.
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface getMoney(Integer getMoneyAmount) {
        if (amountOfMoney >= getMoneyAmount) {
            amountOfMoney -= getMoneyAmount;
            return new NegativeAmountOfMoney("Insufficient money in the account");
        }

        createSnapshot();
        return new SuccessGetMoney();
    }

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
    public void createSnapshot() { snapshots.add(new Snapshot(amountOfMoney, procentMoneyAmount)); }

    /**
     * <p>
     *     Class snapshot
     *     To rememeber all information in current moment. It helps to cansel transaction.
     * </p>
     */
    private class Snapshot {
        private Integer amountOfMoney;
        private Integer procentMoneyAmount;

        public Snapshot(Integer _amountOfMoney, Integer _procentMoneyAmount) {
            amountOfMoney = _amountOfMoney;
            procentMoneyAmount = _procentMoneyAmount;
        }

        /**
         * <p>
         *   Restore
         *   Function to restore old information
         * </p>
         */
        public void restore() {
            setAmountOfMoney(amountOfMoney);
            setProcentMoneyAmount(procentMoneyAmount);
        }

    }
}
