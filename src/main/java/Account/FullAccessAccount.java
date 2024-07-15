package Account;

import Result.ResultInterface;

public class FullAccessAccount implements StrategyInterface {

    /**
     * <p>
     *   GetMoney
     *   Function to get money from full user account.
     *   Returns result of operation.
     *   Has no limits.
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface getMoney(Integer amountOfMoney, AccountInterface account) {
        return account.getMoney(amountOfMoney);
    }

    /**
     * <p>
     *   SetMoney
     *   Function to set money from full user account.
     *   Returns result of operation.
     *   Has no limits.
     * </p>
     * @return Result interface
     */
    @Override
    public ResultInterface setMoney(Integer amountOfMoney, AccountInterface account) {
        return account.setMoney(amountOfMoney);
    }
}
