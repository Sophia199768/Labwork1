package Account;

import Result.NegativeAmountOfMoney;
import Result.ResultInterface;
import Result.SuccessGetMoney;
import Result.SuccessSetMoney;
import User.User;

import java.util.LinkedList;
import java.util.List;

public class CreditAccount implements CreditAccountInterface {
    private double procentToOverdraft = 0.2;
    private int amountOfMoney;
    private int overdraft;
    private int creditMoney;
    private double comission;
    private List<Snapshot> snapshots = new LinkedList<Snapshot>();
    private User user;

    public CreditAccount(int _creditMoney, int _procentToOverdraft, int _commision, User _user) {
        amountOfMoney = _creditMoney;
        countOverdraft(_creditMoney);
        procentToOverdraft = _procentToOverdraft;
        comission = _commision;
        creditMoney = _creditMoney;
        user = _user;
    }

    @Override
    public void setProcentToOverdraft(int _procentToOverdraft) { procentToOverdraft = _procentToOverdraft; }

    public void setAmountOfMoney(int _amountOfMoney) { amountOfMoney = _amountOfMoney; }

    public void setOverdraft(int _overdraft) { overdraft = _overdraft; }

    public void setCreditMoney(int _creditMoney) { creditMoney = _creditMoney; }

    public void setComission(double _comission) { comission = _comission; }


    @Override
    public void addComission() {
        if (amountOfMoney <= 0) {
            amountOfMoney -= (int)(creditMoney * comission);
        }
    }

    public void countOverdraft(int _amountOfMoney) {
       overdraft = (int) Math.round(_amountOfMoney * procentToOverdraft);
    }

    @Override
    public ResultInterface setMoney(int moneyAmount) {
        amountOfMoney += moneyAmount;
        createSnapshot();
        return new SuccessSetMoney();
    }

    @Override
    public ResultInterface getMoney(int getMoneyAmount) {
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

    @Override
    public void changeProcent(double newProcent) { procentToOverdraft = newProcent; }

    @Override
    public void restore() {
        snapshots.get(snapshots.size() - 1).restore();
    }

    public void createSnapshot() { snapshots.add(new Snapshot(amountOfMoney, comission, creditMoney, overdraft)); }

    private class Snapshot {
        private double procentToOverdraft = 0.2;
        private int amountOfMoney;
        private int overdraft;
        private int creditMoney;
        private double comission;

        public Snapshot(int _amountOfMoney, double _comission, int _creditMoney, int _overdraft) {
            amountOfMoney = _amountOfMoney;
            comission = _comission;
            creditMoney = _creditMoney;
            overdraft = _overdraft;
        }

        public void restore() {
            setComission(comission);
            setCreditMoney(creditMoney);
            setOverdraft(overdraft);
            setAmountOfMoney(amountOfMoney);
        }

    }
}
