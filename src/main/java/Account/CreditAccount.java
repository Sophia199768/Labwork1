package Account;

import Result.*;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data

public class CreditAccount implements CreditAccountInterface {
    private Double percentToOverdraft;
    private Integer amountOfMoney;
    private Integer overdraft;
    private Integer creditMoney;
    private Double commission;
    private final List<Snapshot> snapshots = new LinkedList<>();

    public CreditAccount(Integer creditMoney, Double percentToOverdraft, Double commission) {
        this.amountOfMoney = creditMoney;
        this.percentToOverdraft = percentToOverdraft;
        this.commission = commission;
        countOverdraft(creditMoney);
    }

    /**
     * <p>
     *   setPercentToOverdraft
     *   Function help to set percents to overdraft
     * </p>
     */
    @Override
    public void setProcentToOverdraft(Double percentToOverdraft) { this.percentToOverdraft = percentToOverdraft; }

    /**
     * <p>
     *   AddCommission
     *   Function helps to add commission
     * </p>
     */
    @Override
    public void addComission() {
        Integer startAmountOfMoney = 0;
        if (amountOfMoney <= startAmountOfMoney) {
            amountOfMoney -= (int)(creditMoney * commission);
        }
    }

    /**
     * <p>
     *     CountOverdraft
     *     Function helps to count overdraft to concrete account
     * </p>
     *  @param moneyAmount it takes amount of money that user take and count percent to overdraft.
     */
    public void countOverdraft(Integer moneyAmount) {
       overdraft = (int)Math.round(moneyAmount * percentToOverdraft);
    }

    /**
     * <p>
     *   SetMoney
     *   Function to set money at user account.
     * </p>
     *  @param moneyAmount the amount of money that user want to set in his account.
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
     * @param getMoneyAmount the amount of money that user want to get from his account.
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
     * @param newPercent the new percent for credit account
     * </p>
     */
    @Override
    public void changeProcent(double newPercent) { percentToOverdraft = newPercent; }

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
     *     To remember all information in current moment. It helps to cansel transaction.
     * </p>
     */
    public void createSnapshot() { snapshots.add(new Snapshot(amountOfMoney, commission, creditMoney, overdraft)); }

    private class Snapshot {
        private final Integer amountOfMoney;
        private final Integer overdraft;
        private final Integer creditMoney;
        private final double commission;

        public Snapshot(Integer amountOfMoney, Double commission, Integer creditMoney, Integer overdraft) {
            this.amountOfMoney = amountOfMoney;
            this.commission = commission;
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
            setCommission(commission);
            setCreditMoney(creditMoney);
            setOverdraft(overdraft);
            setAmountOfMoney(amountOfMoney);
        }

    }
}
