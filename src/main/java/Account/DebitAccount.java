package Account;

import Result.NegativeAmountOfMoney;
import Result.ResultInterface;
import Result.SuccessGetMoney;
import Result.SuccessSetMoney;
import User.User;

import java.util.LinkedList;
import java.util.List;

public class DebitAccount implements DebitDepositAccountInterface {
    private int amountOfMoney;
    private double procent;
    private int emptyAccount = 0;
    private int year = 365;
    private int procentMoneyAmount;
    private List<Snapshot> snapshots = new LinkedList<Snapshot>();
    private User user;

    public DebitAccount(int _amountOfMoney, double _procent, User _user) {
        amountOfMoney = _amountOfMoney;
        procent = _procent;
        procentMoneyAmount = 0;
        user = _user;
    }

    @Override
    public void addProcent() {
        if (amountOfMoney > emptyAccount) {
            amountOfMoney += procentMoneyAmount;
            procentMoneyAmount = 0;
        }
    }

    @Override
    public void countProcentMoney() {

        procentMoneyAmount += amountOfMoney * (procentMoneyAmount / year);
    }


    public void setAmountOfMoney(int _amountOfMoney) { amountOfMoney = _amountOfMoney; }
    public void setProcentMoneyAmount(int _procentMoneyAmount) { procentMoneyAmount = _procentMoneyAmount; }

    @Override
    public void changeProcent(double newProcent) {
        procent = newProcent;
    }
    @Override
    public ResultInterface setMoney(int setMoneyAmount) {
        amountOfMoney += setMoneyAmount;
        createSnapshot();
        return new SuccessSetMoney();
    }
    @Override
    public ResultInterface getMoney(int getMoneyAmount) {
        if (amountOfMoney >= getMoneyAmount) {
            amountOfMoney -= getMoneyAmount;
            return new NegativeAmountOfMoney("Insufficient money in the account");
        }

        createSnapshot();
        return new SuccessGetMoney();
    }

    @Override
    public void restore() {
        snapshots.get(snapshots.size() - 1).restore();
    }
    public void createSnapshot() { snapshots.add(new Snapshot(amountOfMoney, procentMoneyAmount)); }

    private class Snapshot {
        private int amountOfMoney;
        private int procentMoneyAmount;

        public Snapshot(int _amountOfMoney, int _procentMoneyAmount) {
            amountOfMoney = _amountOfMoney;
            procentMoneyAmount = _procentMoneyAmount;
        }

        public void restore() {
            setAmountOfMoney(amountOfMoney);
            setProcentMoneyAmount(procentMoneyAmount);
        }

    }
}
