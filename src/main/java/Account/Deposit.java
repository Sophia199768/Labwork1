package Account;

import Result.*;
import User.User;

import java.util.LinkedList;
import java.util.List;

public class Deposit implements DebitDepositAccountInterface {
    private int amountOfMoney;
    private double procent;
    private int year = 365;
    private int day = 1;
    private int procentMoneyAmount;
    private int amountOfDayAccountTaken;
    private  List<Snapshot> snapshots = new LinkedList<Snapshot>();
    private User user;

    public Deposit(int _amountOfMoney, double _procent, int _amountOfDayAccountTaken, User _user) {
        amountOfMoney = _amountOfMoney;
        countProcent(_amountOfMoney);
        procent = _procent;
        procentMoneyAmount = 0;
        amountOfDayAccountTaken = _amountOfDayAccountTaken;
        user = _user;
    }

    public void countProcent(int amountOfMoney) {
        procent = (double)((8 * amountOfMoney) / 50000);
    }

    @Override
    public void countProcentMoney() {
        procentMoneyAmount += amountOfMoney * (procentMoneyAmount / year);
        amountOfDayAccountTaken -= day;
    }

    public void setAmountOfMoney(int _amountOfMoney) { amountOfMoney = _amountOfMoney; }
    public void setSendProcent(double _procent) { procent = _procent; }
    public void setProcentMoneyAmount(int _procentMoneyAmount) { procentMoneyAmount = _procentMoneyAmount; }

    @Override
    public void addProcent() {
        amountOfMoney += procentMoneyAmount;
        procentMoneyAmount = 0;
    }
    @Override
    public ResultInterface setMoney(int moneyAmount) {
        amountOfMoney += moneyAmount;
        createSnapshot();
        return new SuccessSetMoney();
    }

    @Override
    public ResultInterface getMoney(int getMoneyAmount) {
        if (amountOfDayAccountTaken != 0) {
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
    public void changeProcent(double newProcent) {
        procent = newProcent;
    }

    public void createSnapshot() { snapshots.add(new Snapshot(amountOfMoney, procent, procentMoneyAmount)); }

    @Override
    public void restore() {
        snapshots.get(snapshots.size() - 1).restore();
    }

    private class Snapshot {
        private int amountOfMoney;
        private double procent;
        private int procentMoneyAmount;
        public Snapshot(int _amountOfMoney, double _procent, int _procentMoneyAmount) {
            amountOfMoney = _amountOfMoney;
            procent = _procent;
            procentMoneyAmount = _procentMoneyAmount;
        }

        public void restore() {
            setAmountOfMoney(amountOfMoney);
            setSendProcent(procent);
            setProcentMoneyAmount(procentMoneyAmount);
        }

    }
}
