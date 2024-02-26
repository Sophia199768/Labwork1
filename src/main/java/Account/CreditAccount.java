package Account;

import Result.NegativeAmountOfMoney;
import Result.ResultInterface;
import Result.SuccessGetMoney;
import Result.SuccessSetMoney;

import java.util.LinkedList;
import java.util.List;

public class CreditAccount implements CreditAccountInterface {
    private Double procentToOverdraft;
    private Integer amountOfMoney;
    private Integer overdraft;
    private Integer creditMoney;
    private Double comission;
    private final List<Snapshot> snapshots = new LinkedList<>();

    public CreditAccount(Integer creditMoney, Double procentToOverdraft, Double commision) {
        this.amountOfMoney = creditMoney;
        this.procentToOverdraft = procentToOverdraft;
        this.comission = commision;
        this.creditMoney = creditMoney;
        countOverdraft(creditMoney);
    }

    @Override
    public void setProcentToOverdraft(Double _procentToOverdraft) { procentToOverdraft = _procentToOverdraft; }

    public void setAmountOfMoney(Integer _amountOfMoney) { amountOfMoney = _amountOfMoney; }

    public void setOverdraft(Integer _overdraft) { overdraft = _overdraft; }

    public void setCreditMoney(Integer _creditMoney) { creditMoney = _creditMoney; }

    public void setComission(Double _comission) { comission = _comission; }


    /**
     * <p>
     *   AddComission
     *   Function help to add comission
     * </p>
     */
    @Override
    public void addComission() {
        Integer startAmountOfMoney = 0;
        if (amountOfMoney <= startAmountOfMoney) {
            amountOfMoney -= (int)(creditMoney * comission);
        }
    }

    /**
     * <p>
     *     CountOverdraft
     *     Function helps to count overdraft to concrete account
     * </p>
     */
    public void countOverdraft(Integer moneyAmount) {
       overdraft = (int)Math.round(moneyAmount * procentToOverdraft);
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
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface getMoney(Integer getMoneyAmount) {
        if (getMoneyAmount > amountOfMoney + overdraft) {
            return new NegativeAmountOfMoney("Insufficient money in the account");
        }

        createSnapshot();

        if (getMoneyAmount > amountOfMoney) {
            overdraft -= (getMoneyAmount - amountOfMoney);
            amountOfMoney = 0;
            return new SuccessGetMoney();
        }

        amountOfMoney -= getMoneyAmount;
        return new SuccessGetMoney();
    }

    /**
     * <p>
     *     ChangePercent
     *     To change percent to overdraft.
     * </p>
     */
    @Override
    public void changeProcent(double newProcent) { procentToOverdraft = newProcent; }

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
    public void createSnapshot() { snapshots.add(new Snapshot(amountOfMoney, comission, creditMoney, overdraft)); }

    private class Snapshot {
        private final Integer amountOfMoney;
        private final Integer overdraft;
        private final Integer creditMoney;
        private final double comission;

        public Snapshot(Integer amountOfMoney, Double comission, Integer creditMoney, Integer overdraft) {
            this.amountOfMoney = amountOfMoney;
            this.comission = comission;
            this.creditMoney = creditMoney;
            this.overdraft = overdraft;
        }

        /**
         * <p>
         *   Restore
         *   Function to restore old information
         * </p>
         */
        public void restore() {
            setComission(comission);
            setCreditMoney(creditMoney);
            setOverdraft(overdraft);
            setAmountOfMoney(amountOfMoney);
        }

    }
}
