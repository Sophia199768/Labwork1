package User;

import Account.FullAccessAccount;
import Account.IncompleteAccessAccount;
import Account.StrategyInterface;
import Bank.Bank;

public class UserMatching {

    /**
     * <p>
     *   Match
     *   Function to match correct strategy behavior in dependence of information that we have.
     * </p>
     * @return StrategyInterface
     */
    public StrategyInterface Match(State userState, Bank bank) {
        if (userState instanceof  FullAccessUser) {
            return new FullAccessAccount();
        }

        return new IncompleteAccessAccount(bank.getLimit());
    }
}
