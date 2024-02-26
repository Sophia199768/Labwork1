package Account;

import Result.ResultInterface;
import Result.UnSafeAccount;
public class IncompleteAccessAccount implements StrategyInterface {
    private final Integer limit;

    public IncompleteAccessAccount(Integer limit) {
        this.limit = limit;
    }

    /**
     * <p>
     *   GetMoney
     *   Function to get money from incomplete user account.
     *   Returns result of operation.
     *   Has limit, user can't set more money than in limit.
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface getMoney(Integer amountOfMoney, AccountInterface account) {
        if (amountOfMoney <= limit) {
            return account.getMoney(amountOfMoney);
        }
        return new UnSafeAccount("You can't get so much money");
    }

    /**
     * <p>
     *   GetMoney
     *   Function to get money from incomplete user account.
     *   Returns result of operation.
     *   Has limit, user can't set more money than in limit.
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface setMoney(Integer amountOfMoney, AccountInterface account) {
        if (amountOfMoney <= limit) { return account.setMoney(amountOfMoney); }

        return new UnSafeAccount("You can't get so much money");
    }
}
